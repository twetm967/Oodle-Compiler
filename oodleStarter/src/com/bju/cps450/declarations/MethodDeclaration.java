package com.bju.cps450.declarations;

import com.bju.cps450.application.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class MethodDeclaration extends AbstractDeclaration {
    private String name;
    private List<ArgumentDeclaration> arguments;
    private List<VariableDeclaration> variables;
    private ClassDeclaration owner;

    public Type getReturnType() {
        return type;
    }

    public void setReturnType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArgumentDeclaration> getArguments() {
        if(arguments == null) {
            this.arguments = new ArrayList<>();
        }
        return arguments;
    }

    public void setArguments(List<ArgumentDeclaration> arguments) {
        this.arguments = arguments;
    }

    public List<VariableDeclaration> getVariables() {
        if(variables == null) {
            this.variables = new ArrayList<>();
        }
        return variables;
    }

    public void setVariables(List<VariableDeclaration> variables) {
        this.variables = variables;
    }

    public ClassDeclaration getOwner() {
        return owner;
    }

    public void setOwner(ClassDeclaration owner) {
        this.owner = owner;
    }

    public AbstractVariableDeclaration lookupVariable(String name) {
        for(int i = 0; i < getVariables().size(); ++i) {
            if(getVariables().get(i).getName().equals(name)) {
                return getVariables().get(i);
            }
        }
        for(int i = 0; i < getArguments().size(); ++i) {
            if(getArguments().get(i).getName().equals(name)) {
                return getArguments().get(i);
            }
        }
        return getOwner().lookupVariable(name);
    }
}

