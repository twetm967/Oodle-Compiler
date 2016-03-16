package com.bju.cps450.declarations;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class VariableDeclaration extends AbstractVariableDeclaration {
    private ClassDeclaration classOwner;

    public ClassDeclaration getClassOwner() {
        return classOwner;
    }

    public void setClassOwner(ClassDeclaration classOwner) {
        this.classOwner = classOwner;
    }
}
