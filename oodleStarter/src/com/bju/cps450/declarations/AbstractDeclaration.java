package com.bju.cps450.declarations;


import com.bju.cps450.application.Type;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class AbstractDeclaration {
    protected Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

