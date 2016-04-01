package com.bju.cps450;

import com.bju.cps450.analysis.DepthFirstAdapter;
import com.bju.cps450.application.Application;
import com.bju.cps450.declarations.ClassDeclaration;
import com.bju.cps450.declarations.MethodDeclaration;
import com.bju.cps450.instruction.*;
import com.bju.cps450.instruction.parameters.IntegerLiteral;
import com.bju.cps450.instruction.parameters.Label;
import com.bju.cps450.instruction.parameters.Register;
import com.bju.cps450.node.*;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class OodleCodeGenerator extends DepthFirstAdapter {
    private int labelCtr = 0;
    private ClassDeclaration currentClass;
    private MethodDeclaration currentMethod;

    @Override
    public void outStart(Start node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getPStart()).getCode());
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAStart(AStart node) {
        InstructionSet set = new InstructionSet();
        for(PClassDecl c : node.getClassDecl()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void inAClassDecl(AClassDecl node) {
        currentClass = Application.getSymbolTable().lookup(node.getStart().getText(), ClassDeclaration.class);
    }

    @Override
    public void outAClassDecl(AClassDecl node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new StabsInstruction("data"));
        for(PVarDecl c : node.getVarDecl()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        for(PMethodDecl c : node.getMethodDecl()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAInheritsFrom(AInheritsFrom node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAVarDecl(AVarDecl node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new StabsInstruction("data"));
        set.appendInstruction(new StabsInstruction("comm", node.getIdentifier().getText() + ", 4, 4"));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void inAMethodDecl(AMethodDecl node) {
        currentMethod = currentClass.lookupMethod(node.getStart().getText());
    }

    @Override
    public void outAMethodDecl(AMethodDecl node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new StabsInstruction("text"));
        if(node.getStart().getText().equals("start")) {
            set.appendInstruction(new StabsInstruction("global", "main"));
            set.appendInstruction(new LabelInstruction("main"));
        } else {
            set.appendInstruction(new StabsInstruction("global", node.getStart().getText()));
            set.appendInstruction(new LabelInstruction(node.getStart().getText()));
        }
        for(PStatement c : node.getStatement()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        set.appendInstruction(new InstructionCommand(Instruction.ret));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAIntType(AIntType node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outABooleanType(ABooleanType node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAStringType(AStringType node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }


    @Override
    public void outAIdType(AIdType node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAArg(AArg node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAIfStatement(AIfStatement node) {
        labelCtr += 2;
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getCond()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, new IntegerLiteral(0), Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.je, new Label("label_" + (labelCtr - 2))));
        for(PStatement c : node.getTrue()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        set.appendInstruction(new InstructionCommand(Instruction.jump, new Label("label_" + (labelCtr - 1))));
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 2)));
        for(PStatement c : node.getFalse()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 1)));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outALoopStatement(ALoopStatement node) {
        labelCtr += 2;
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 2)));
        set.appendInstructionSet(Application.getNodeProperties(node.getCond()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, new IntegerLiteral(0), Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.je, new Label("label_" + (labelCtr - 1))));
        for(PStatement c : node.getStatement()) {
            set.appendInstructionSet(Application.getNodeProperties(c).getCode());
        }
        set.appendInstruction(new InstructionCommand(Instruction.jump, new Label("label_" + (labelCtr - 2))));
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 1)));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAAsgnStatement(AAsgnStatement node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getSecond()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, new Label(node.getIdentifier().getText())));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outACallStatement(ACallStatement node) {
        InstructionSet set = new InstructionSet();
        for(int i = node.getArgs().size() - 1; i >= 0; --i) {
            set.appendInstructionSet(Application.getNodeProperties(node.getArgs().get(i)).getCode());
        }
        set.appendInstruction(new InstructionCommand(Instruction.call, new Label("writeint")));
        set.appendInstruction(new InstructionCommand(Instruction.add, new IntegerLiteral(node.getArgs().size() * 4), Register.esp));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAOrExpression(AOrExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.or, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAAndExpression(AAndExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.and, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAGtExpression(AGtExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.setg, Register.al));
        set.appendInstruction(new InstructionCommand(Instruction.movzbl, Register.al, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAGteExpression(AGteExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.setge, Register.al));
        set.appendInstruction(new InstructionCommand(Instruction.movzbl, Register.al, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAEqExpression(AEqExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.sete, Register.al));
        set.appendInstruction(new InstructionCommand(Instruction.movzbl, Register.al, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAAddExpression(AAddExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.add, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outASubExpression(ASubExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.sub, Register.ebx, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAMulExpression(AMulExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.mul, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outADivExpression(ADivExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getLhs()).getCode());
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.cdq));
        set.appendInstruction(new InstructionCommand(Instruction.div, Register.ebx));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outANotExpression(ANotExpression node) {
        labelCtr +=2;
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.compare, new IntegerLiteral(0), Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.je, new Label("label_" + (labelCtr - 2))));
        set.appendInstruction(new InstructionCommand(Instruction.push, new IntegerLiteral(0)));
        set.appendInstruction(new InstructionCommand(Instruction.jump, new Label("label_" + (labelCtr - 1))));
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 2)));
        set.appendInstruction(new InstructionCommand(Instruction.push, new IntegerLiteral(1)));
        set.appendInstruction(new LabelInstruction("label_" + (labelCtr - 1)));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outANegExpression(ANegExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.neg, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAArrayExpression(AArrayExpression node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAMcallExpression(AMcallExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new InstructionCommand(Instruction.call, new Label("readint")));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAIntExpression(AIntExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new InstructionCommand(Instruction.push, new IntegerLiteral(Integer.parseInt(node.getIntLiteral().getText()))));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAStringExpression(AStringExpression node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outATrueExpression(ATrueExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new InstructionCommand(Instruction.push, new IntegerLiteral(1)));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAFalseExpression(AFalseExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new InstructionCommand(Instruction.push, new IntegerLiteral(0)));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAIdentifierExpression(AIdentifierExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstruction(new InstructionCommand(Instruction.push, new Label(node.getIdentifier().getText())));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAMeExpression(AMeExpression node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outANewObjExpression(ANewObjExpression node) {
        InstructionSet set = new InstructionSet();
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAConcatExpression(AConcatExpression node) {
        super.outAConcatExpression(node);
    }

    @Override
    public void outAIncExpression(AIncExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getRhs()).getCode());
        set.appendInstruction(new InstructionCommand(Instruction.pop, Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.add, new IntegerLiteral(1), Register.eax));
        set.appendInstruction(new InstructionCommand(Instruction.push, Register.eax));
        Application.getNodeProperties(node).setCode(set);
    }

    @Override
    public void outAExprExpression(AExprExpression node) {
        InstructionSet set = new InstructionSet();
        set.appendInstructionSet(Application.getNodeProperties(node.getExpression()).getCode());
        Application.getNodeProperties(node).setCode(set);
    }
}
