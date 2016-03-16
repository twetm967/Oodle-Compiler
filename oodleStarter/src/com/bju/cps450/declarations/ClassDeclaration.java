package com.bju.cps450.declarations;

import com.bju.cps450.application.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ethanmcgee on 2/24/16.
 */
public class ClassDeclaration extends AbstractDeclaration {
    private ClassDeclaration parent;
    private List<MethodDeclaration> methods;
    private List<VariableDeclaration> variables;

    public ClassDeclaration getParent() {
        return parent;
    }

    public void setParent(ClassDeclaration parent) {
        this.parent = parent;
    }

    public List<MethodDeclaration> getMethods() {
        if(methods == null) {
            methods = new ArrayList<>();
        }
        return methods;
    }

    public void setMethods(List<MethodDeclaration> methods) {
        this.methods = methods;
    }

    public List<VariableDeclaration> getVariables() {
        if(variables == null) {
            variables = new ArrayList<>();
        }
        return variables;
    }

    public void setVariables(List<VariableDeclaration> variables) {
        this.variables = variables;
    }

    public MethodDeclaration lookupMethod(String name) {
        for(int i = 0; i < getMethods().size(); ++i) {
            if(getMethods().get(i).getName().equals(name)) {
                return getMethods().get(i);
            }
        }
        if(getParent() != null) {
            return getParent().lookupMethod(name);
        }
        return null;
    }

    public AbstractVariableDeclaration lookupVariable(String name) {
        for(int i = 0; i < getVariables().size(); ++i) {
            if(getVariables().get(i).getName().equals(name)) {
                return getVariables().get(i);
            }
        }
        if(getParent() != null) {
            return getParent().lookupVariable(name);
        }
        return Application.getSymbolTable().lookup(name, true, VariableDeclaration.class);
    }
}