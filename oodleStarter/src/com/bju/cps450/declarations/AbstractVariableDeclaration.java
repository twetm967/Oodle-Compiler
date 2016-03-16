package com.bju.cps450.declarations;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class AbstractVariableDeclaration extends AbstractDeclaration {
    protected String name;
    protected MethodDeclaration methodOwner;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public MethodDeclaration getMethodOwner() {
        return methodOwner;
    }

    public void setMethodOwner(MethodDeclaration methodOwner){
        this.methodOwner = methodOwner;
    }
}
