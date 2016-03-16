package com.bju.cps450.application;

/**
 * Created by tcwetmore on 3/12/16.
 */
public class Type {
    public static Type oodInt = new Type("int");
    public static Type oodString = new Type("string");
    public static Type oodVoid = new Type("void");
    public static Type oodBool = new Type("bool");
    public static Type oodError = new Type("error");

    private String name;

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        return name.equals(type.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

