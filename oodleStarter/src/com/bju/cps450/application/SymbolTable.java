package com.bju.cps450.application;


import com.bju.cps450.declarations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SymbolTable {
    private Stack<List<AbstractDeclaration>> symbolTableStack = new Stack<>();

    public void beginScope() {
        symbolTableStack.push(new ArrayList<AbstractDeclaration>());
        if(symbolTableStack.size() == 1) {
            ClassDeclaration writerDeclaration = new ClassDeclaration();
            writerDeclaration.setType(new Type("Writer"));

            ClassDeclaration readerDeclaration = new ClassDeclaration();
            readerDeclaration.setType(new Type("Reader"));

            /*MethodDeclaration println = new MethodDeclaration();
            println.setReturnType(Type.mjVoid);
            println.setName("println");
            ArgumentDeclaration printlnArg1 = new ArgumentDeclaration();
            printlnArg1.setName("str");
            printlnArg1.setType(Type.mjString);
            printlnArg1.setMethodOwner(println);
            println.getArguments().add(printlnArg1);
            println.setOwner(writerDeclaration);
            writerDeclaration.getMethods().add(println);*/
            MethodDeclaration writeint = new MethodDeclaration();
            writeint.setReturnType(Type.oodVoid);
            writeint.setName("writeint");
            ArgumentDeclaration writeintArg1 = new ArgumentDeclaration();
            writeintArg1.setName("int");
            writeintArg1.setType(Type.oodInt);
            writeintArg1.setMethodOwner(writeint);
            writeint.getArguments().add(writeintArg1);
            writeint.setOwner(writerDeclaration);
            writerDeclaration.getMethods().add(writeint);

            symbolTableStack.get(0).add(writerDeclaration);

            /*MethodDeclaration readln = new MethodDeclaration();
            readln.setReturnType(Type.mjString);
            readln.setName("readln");
            readln.setOwner(readerDeclaration);
            readerDeclaration.getMethods().add(readln);*/
            MethodDeclaration readint = new MethodDeclaration();
            readint.setReturnType(Type.oodInt);
            readint.setName("readint");
            readint.setOwner(readerDeclaration);
            readerDeclaration.getMethods().add(readint);

            symbolTableStack.get(0).add(readerDeclaration);

            VariableDeclaration in = new VariableDeclaration();
            in.setType(readerDeclaration.getType());
            in.setName("in");

            VariableDeclaration out = new VariableDeclaration();
            out.setType(writerDeclaration.getType());
            out.setName("out");

            symbolTableStack.get(0).add(in);
            symbolTableStack.get(0).add(out);
        }
    }

    private void addDeclToSymbolTable(AbstractDeclaration decl) {
        symbolTableStack.get(symbolTableStack.size() - 1).add(decl);
    }

    private ClassDeclaration currentClassDeclaration;
    private MethodDeclaration currentMethodDeclaration;

    public ClassDeclaration getCurrentClassDeclaration() {
        return currentClassDeclaration;
    }

    public MethodDeclaration getCurrentMethodDeclaration() {
        return currentMethodDeclaration;
    }

    public ClassDeclaration addClassDeclaration(String name) throws Exception {
        if(lookup(name, ClassDeclaration.class) == null) {
            if(symbolTableStack.size() == 1) {
                ClassDeclaration decl = new ClassDeclaration();
                decl.setType(new Type(name));
                addDeclToSymbolTable(decl);
                currentClassDeclaration = decl;
                return decl;
            } else {
                throw new Exception("can only add classes at global level");
            }
        } else {
            throw new Exception("a class with name " + name + " already exists in the current scope");
        }
    }

    public MethodDeclaration addMethodDeclaration(String name) throws Exception {
        if(lookup(name, MethodDeclaration.class) == null) {
            if (symbolTableStack.size() == 2) {
                MethodDeclaration decl = new MethodDeclaration();
                decl.setName(name);
                addDeclToSymbolTable(decl);
                currentMethodDeclaration = decl;
                return decl;
            } else {
                throw new Exception("can only add methods at class level");
            }
        } else {
            throw new Exception("a method with name " + name + " already exists in the current scope");
        }
    }

    public ArgumentDeclaration addArgumentDeclaration(String name, Type t) throws Exception {
        if(lookup(name, ArgumentDeclaration.class) == null) {
            if(symbolTableStack.size() == 3) {
                ArgumentDeclaration decl = new ArgumentDeclaration();
                decl.setName(name);
                decl.setType(t);
                addDeclToSymbolTable(decl);
                return decl;
            } else {
                throw new Exception("can only add arguments at method level");
            }
        } else {
            throw new Exception("a variable or argument with name " + name + " already exists in the current scope");
        }
    }

    public VariableDeclaration addVariableDeclaration(String name, Type t) throws Exception {
        if(lookup(name, VariableDeclaration.class) == null && lookup(name, ArgumentDeclaration.class) == null) {
            if (symbolTableStack.size() == 2 || symbolTableStack.size() == 3) {
                VariableDeclaration decl = new VariableDeclaration();
                decl.setName(name);
                decl.setType(t);
                addDeclToSymbolTable(decl);
                return decl;
            } else {
                throw new Exception("can only add variables at class or method level");
            }
        } else {
            throw new Exception("a variable or argument with name " + name + " already exists in the current scope");
        }
    }


    public <T extends AbstractDeclaration> T lookup(String name, Class<T> clazz) {
        return lookup(name, false, clazz);
    }

    public <T extends AbstractDeclaration> T lookup(String name, boolean allScopes, Class<T> clazz) {
        for(int i = symbolTableStack.size() - 1; i >= 0; --i) {
            for (int j = 0; j < symbolTableStack.get(i).size(); ++j) {
                if (symbolTableStack.get(i).get(j).getClass().equals(clazz)) {
                    AbstractDeclaration decl = symbolTableStack.get(i).get(j);
                    if (clazz.equals(ClassDeclaration.class)) {
                        if (((ClassDeclaration) decl).getType().getName().equals(name)) {
                            return (T) decl;
                        }
                    } else if (clazz.equals(MethodDeclaration.class)) {
                        if (((MethodDeclaration) decl).getName().equals(name)) {
                            return (T) decl;
                        }
                    } else if (clazz.equals(VariableDeclaration.class) || clazz.equals(ArgumentDeclaration.class)) {
                        if (((AbstractVariableDeclaration) decl).getName().equals(name)) {
                            return (T) decl;
                        }
                    }
                }
            }
            if(!allScopes) {
                return null;
            }
        }
        return null;
    }

    public void endScope() throws Exception {
        int i = symbolTableStack.size() - 1;
        switch (i) {
            case 2:
                for(int j = 0; j < symbolTableStack.get(i).size(); ++j) {
                    if(symbolTableStack.get(i).get(j) instanceof ArgumentDeclaration) {
                        ((ArgumentDeclaration)symbolTableStack.get(i).get(j)).setMethodOwner(currentMethodDeclaration);
                        currentMethodDeclaration.getArguments().add((ArgumentDeclaration)symbolTableStack.get(i).get(j));
                    }
                    if(symbolTableStack.get(i).get(j) instanceof VariableDeclaration) {
                        ((VariableDeclaration)symbolTableStack.get(i).get(j)).setMethodOwner(currentMethodDeclaration);
                        currentMethodDeclaration.getVariables().add((VariableDeclaration) symbolTableStack.get(i).get(j));
                    }
                }
                break;
            case 1:
                for(int j = 0; j < symbolTableStack.get(i).size(); ++j) {
                    if(symbolTableStack.get(i).get(j) instanceof MethodDeclaration) {
                        ((MethodDeclaration)symbolTableStack.get(i).get(j)).setOwner(currentClassDeclaration);
                        currentClassDeclaration.getMethods().add((MethodDeclaration) symbolTableStack.get(i).get(j));
                    }
                    if(symbolTableStack.get(i).get(j) instanceof VariableDeclaration) {
                        ((VariableDeclaration)symbolTableStack.get(i).get(j)).setClassOwner(currentClassDeclaration);
                        currentClassDeclaration.getVariables().add((VariableDeclaration)symbolTableStack.get(i).get(j));
                    }
                }
                break;
            case 0:
                throw new Exception("attempted to pop empty symbol table");
        }
        symbolTableStack.pop();
    }
}


