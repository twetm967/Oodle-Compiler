package com.bju.cps450;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.application.Application;
import com.bju.cps450.application.Type;
import com.bju.cps450.declarations.*;
import com.bju.cps450.node.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tcwetmore on 3/11/16.
 */
public class SemanticChecker extends DepthFirstAdapter {

    private HashMap<Node, Type> typeMap = new HashMap<Node, Type>();

    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;
    private Token lastToken;

    private void reportError(String error) {
        Application.addSemanticError();
        if(lastToken != null) {
            System.out.println(Application.getTokenFileAndLine(lastToken) + error);
        } else {
            System.out.println(error);
        }
    }

    @Override
    public void inAClassDecl(AClassDecl node) {
        lastToken = node.getStart();
        currentClass = Application.getSymbolTable().lookup(node.getStart().getText(), ClassDeclaration.class);
        if(currentClass == null) {
            reportError("class " + node.getStart().getText() + " does not exist in the current scope");
        }
    }

    @Override
    public void outAClassDecl(AClassDecl node) {
        currentClass = null;
    }

    @Override
    public void outAInheritsFrom(AInheritsFrom node) {
        lastToken = node.getIdentifier();
        ClassDeclaration decl = Application.getSymbolTable().lookup(node.getIdentifier().getText(), ClassDeclaration.class);
        if(decl == null) {
            reportError("class " + node.getIdentifier().getText() + " does not exist in the current scope");
        } else {
            currentClass.setParent(decl);
        }
    }

    @Override
    public void inAMethodDecl(AMethodDecl node) {
        lastToken = node.getStart();
        currentMethod = currentClass.lookupMethod(node.getStart().getText());
        if(currentMethod == null) {
            reportError("method " + node.getStart().getText() + " does not exist in the current scope");
        }
    }

    @Override
    public void outAMethodDecl(AMethodDecl node) {
        currentMethod = null;
    }

    @Override
    public void outAVarDecl(AVarDecl node) {
        lastToken = node.getIdentifier();
        Type t = Application.getNodeProperties(node.getExpression()).getType();
        if (t == null)
        {
            t = Application.getNodeProperties(node.getType()).getType();
            if (t == null)
            {
                Application.getNodeProperties(node).setType(Type.oodError);
                reportError("No type specified");
                return;
            }
        }
        if(currentMethod == null && node.getExpression() != null)
        {
            reportError("Unsupported Feature: Variable declaration outside method");
        }
        else if (node.getType() == null && currentClass.lookupVariable(node.getIdentifier().toString()) == null)
        {
            reportError("No type specified");
        }

        if (t.equals(Type.oodString))
        {
            reportError("Unsupported Feature: type string");
        }
        Application.getNodeProperties(node).setType(t);
    }

    @Override
    public void outAIfStatement(AIfStatement node) {
        lastToken = node.getIf();
        if(!Application.getNodeProperties(node.getCond()).getType().equals(Type.oodBool)) {
            reportError("if statement condition must be of type boolean");
        }
    }

    @Override
    public void outALoopStatement(ALoopStatement node) {
        if(!Application.getNodeProperties(node.getCond()).getType().equals(Type.oodBool)) {
            reportError("while statement condition must be of type boolean");
        }
    }

    @Override
    public void outAAsgnStatement(AAsgnStatement node) {
        //first is a list of array indicies
        Type wanted = null;
        lastToken = node.getIdentifier();
        AbstractVariableDeclaration decl = null;
        if(currentMethod == null) {
            decl = currentClass.lookupVariable(node.getIdentifier().getText());
            reportError("Unsupported Feature: Assignment outside method");
        } else {
            decl = currentMethod.lookupVariable(node.getIdentifier().getText());
        }
        if(decl == null) {
            reportError("variable / argument " + node.getIdentifier().getText() + " does not exist in the current scope");
        } else {
            Type t = decl.getType();
            for(int i = 0; i < node.getFirst().size(); ++i) {
                if(!Application.getNodeProperties(node.getFirst().get(i)).getType().equals(Type.oodInt)) {
                    reportError("ith expression " + i + " is not of type integer");
                }
                if(t.getName().length() > 2) {
                    t = new Type(t.getName().substring(0, t.getName().length() - 2));
                }
            }
            wanted = t;
            Type given = Application.getNodeProperties(node.getSecond()).getType();
            if (given == null)
            {
                reportError("variable " + node.getIdentifier().getText() + " expects type of " + wanted.getName() + " but got void");
            }
            else if(!given.equals(wanted)) {
                reportError("variable " + node.getIdentifier().getText() + " expects type of " + wanted.getName() + " but got " + given.getName());
            }
        }
    }

    @Override
    public void outACallStatement(ACallStatement node) {
        ClassDeclaration parentClass = currentClass;
        lastToken = node.getIdentifier();
        if(node.getCaller() != null) {
            Type t = Application.getNodeProperties(node.getCaller()).getType();
            ClassDeclaration decl = Application.getSymbolTable().lookup(t.getName(), ClassDeclaration.class);
            if(decl == null) {
                reportError("class " + t.getName() + " does not exist in the current scope");
                Application.getNodeProperties(node).setType(Type.oodError);
            } else {
                parentClass = decl;
            }
        }
        MethodDeclaration decl = parentClass.lookupMethod(node.getIdentifier().getText());
        if(decl == null) {
            reportError("method " + node.getIdentifier().getText() + " does not exist in " + parentClass.getType().getName());
        } else {
            if(node.getArgs().size() != decl.getArguments().size()) {
                reportError("method " + decl.getName() + " exepcted " + decl.getArguments().size() + " arguments but was given " + node.getArgs().size());
            } else {
                for(int i = 0; i < node.getArgs().size(); ++i) {
                    Type given = Application.getNodeProperties(node.getArgs().get(i)).getType();
                    Type wanted = decl.getArguments().get(i).getType();
                    if(!given.equals(wanted)) {
                        reportError("method " + decl.getName() + "'s ith argument " + i + " wanted type " + wanted.getName() + " but got " + given.getName());
                    }
                }
            }
        }
    }

    private void checkExpression(String expression, Node node, Type lhs, Type rhs, List<Type> wanted, Type result) {
        String s = "";
        for(int i = 0; i < wanted.size(); ++i) {
            if(i > 0) {
                s += " / " + wanted.get(i).getName();
            } else {
                s = wanted.get(i).getName();
            }
            if(lhs.equals(rhs) && lhs.equals(wanted.get(i))) {
                Application.getNodeProperties(node).setType(result);
                return;
            }
        }
        reportError(expression + " wanted type(s) " + s + " but got type(s) " + lhs.getName() + " / " + rhs.getName());
        Application.getNodeProperties(node).setType(Type.oodError);
    }

    private void checkExpression(String expression, Node node, Type lhs, Type rhs, Type wanted, Type result) {
        if(lhs.equals(rhs) && lhs.equals(wanted)) {
            Application.getNodeProperties(node).setType(result);
        } else {
            reportError(expression + " wanted type(s) " + wanted.getName() + " but got type(s) " + lhs.getName() + " / " + rhs.getName());
            Application.getNodeProperties(node).setType(Type.oodError);
        }
    }

    @Override
    public void outAOrExpression(AOrExpression node) {
        checkExpression("or", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodBool, Type.oodBool);
    }

    @Override
    public void outAAndExpression(AAndExpression node) {
        checkExpression("and", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodBool, Type.oodBool);
    }

    @Override
    public void outAGtExpression(AGtExpression node) {
        List<Type> wanted = new ArrayList<Type>();
        wanted.add(Type.oodInt);
        wanted.add(Type.oodString);
        checkExpression("greater", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), wanted, Type.oodBool);
    }

    @Override
    public void outAGteExpression(AGteExpression node) {
        List<Type> wanted = new ArrayList<Type>();
        wanted.add(Type.oodInt);
        wanted.add(Type.oodString);
        checkExpression("greater equal", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), wanted, Type.oodBool);
    }

    @Override
    public void outAEqExpression(AEqExpression node) {
        List<Type> wanted = new ArrayList<Type>();
        wanted.add(Type.oodInt);
        wanted.add(Type.oodString);
        checkExpression("equals", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), wanted, Type.oodBool);
    }

    @Override
    public void outAAddExpression(AAddExpression node) {
        checkExpression("addition", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outASubExpression(ASubExpression node) {
        checkExpression("subtraction", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outAMulExpression(AMulExpression node) {
        checkExpression("multiplication", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outADivExpression(ADivExpression node) {
        checkExpression("division", node, Application.getNodeProperties(node.getLhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outANotExpression(ANotExpression node) {
        checkExpression("not", node, Application.getNodeProperties(node.getRhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodBool, Type.oodBool);
    }

    @Override
    public void outANegExpression(ANegExpression node) {
        checkExpression("negation", node, Application.getNodeProperties(node.getRhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outAIncExpression(AIncExpression node) {
        checkExpression("inc", node, Application.getNodeProperties(node.getRhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodInt, Type.oodInt);
    }

    @Override
    public void outAConcatExpression(AConcatExpression node) {
        checkExpression("concat", node, Application.getNodeProperties(node.getRhs()).getType(), Application.getNodeProperties(node.getRhs()).getType(), Type.oodString, Type.oodString);
    }

    @Override
    public void outAArrayExpression(AArrayExpression node) {
        /*lastToken = node.getIdentifier();
        AbstractVariableDeclaration decl = null;
        if(currentMethod == null) {
            decl = currentClass.lookupVariable(node.getIdentifier().getText());
        } else {
            decl = currentMethod.lookupVariable(node.getIdentifier().getText());
        }
        if(decl == null) {
            reportError("variable / argument " + node.getIdentifier().getText() + " does not exist in the current scope");
            Application.getNodeProperties(node).setType(Type.oodError);
        } else {
            Type t = decl.getType();
            for(int i = 0; i < node.getExpression().size(); ++i) {
                if(!Application.getNodeProperties(node.getExpression().get(i)).getType().equals(Type.oodInt)) {
                    reportError("ith expression " + i + " is not of type integer");
                }
                if(t.getName().length() > 2) {
                    t = new Type(t.getName().substring(0, t.getName().length() - 2));
                }
            }
            Application.getNodeProperties(node).setType(t);
        }*/
        reportError(Application.getTokenFileAndLine(lastToken) + ": Unsupported Feature: array");
        Application.getNodeProperties(node).setType(Type.oodError);
    }

    @Override
    public void outAMcallExpression(AMcallExpression node) {
        lastToken = node.getMethod();
        ClassDeclaration parentClass = currentClass;
        if(node.getStart() != null) {
            Type t = Application.getNodeProperties(node.getStart()).getType();
            ClassDeclaration decl = Application.getSymbolTable().lookup(t.getName(), ClassDeclaration.class);
            if(decl == null) {
                reportError("class " + t.getName() + " does not exist in the current scope");
                Application.getNodeProperties(node).setType(Type.oodError);
            } else {
                parentClass = decl;
            }
        }
        MethodDeclaration decl = parentClass.lookupMethod(node.getMethod().getText());
        if(decl == null) {
            reportError("method " + node.getMethod().getText() + " does not exist in " + parentClass.getType().getName());
            Application.getNodeProperties(node).setType(Type.oodError);
        } else {
            if(node.getArgs().size() != decl.getArguments().size()) {
                reportError("method " + decl.getName() + " exepcted " + decl.getArguments().size() + " arguments but was given " + node.getArgs().size());
            } else {
                for(int i = 0; i < node.getArgs().size(); ++i) {
                    Type given = Application.getNodeProperties(node.getArgs().get(i)).getType();
                    Type wanted = decl.getArguments().get(i).getType();
                    if(!given.equals(wanted)) {
                        reportError("method " + decl.getName() + "'s ith argument " + i + " wanted type " + wanted.getName() + " but got " + given.getName());
                    }
                }
            }
            Application.getNodeProperties(node).setType(decl.getType());
        }
    }

    @Override
    public void outAIntExpression(AIntExpression node) {
        lastToken = node.getIntLiteral();
        Application.getNodeProperties(node).setType(Type.oodInt);
    }

    @Override
    public void outAStringExpression(AStringExpression node) {
        lastToken = node.getStrIteral();
        reportError("Unsupported Feature: type string");
        Application.getNodeProperties(node).setType(Type.oodString);
    }

    @Override
    public void outATrueExpression(ATrueExpression node) {
        lastToken = node.getTrue();
        Application.getNodeProperties(node).setType(Type.oodBool);
    }

    @Override
    public void outAFalseExpression(AFalseExpression node) {
        lastToken = node.getFalse();
        Application.getNodeProperties(node).setType(Type.oodBool);
    }

    @Override
    public void outAIdentifierExpression(AIdentifierExpression node) {
        AbstractVariableDeclaration decl = null;
        lastToken = node.getIdentifier();
        if(currentMethod == null) {
            decl = currentClass.lookupVariable(node.getIdentifier().getText());
        } else {
            decl = currentMethod.lookupVariable(node.getIdentifier().getText());
        }
        if(decl == null) {
            reportError("variable / argument " + node.getIdentifier().getText() + " does not exist in the current scope");
            Application.getNodeProperties(node).setType(Type.oodError);
        } else {
            if (decl.getType().getName().equals("oodString"))
            {
                reportError("Unsupported Feature: type string");
            }
            Application.getNodeProperties(node).setType(decl.getType());
        }
    }

    @Override
    public void outAMeExpression(AMeExpression node) {
        lastToken = node.getMe();
        Application.getNodeProperties(node).setType(currentClass.getType());
    }

    @Override
    public void outANewObjExpression(ANewObjExpression node){
        ClassDeclaration decl = Application.getSymbolTable().lookup(node.getType().toString(), ClassDeclaration.class);
        if(decl == null) {
            reportError("class " + node.getType().toString() + " does not exist in the current scope");
            Application.getNodeProperties(node).setType(Type.oodError);
        } else {
            Application.getNodeProperties(node).setType(decl.getType());
        }
    }
}


