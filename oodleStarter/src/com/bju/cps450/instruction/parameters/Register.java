package com.bju.cps450.instruction.parameters;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class Register extends Parameter{
    private String name;

    public static Register eax = new Register("eax"),
            al = new Register("al"),
            ebx = new Register("ebx"),
            bl = new Register("bl"),
            ecx = new Register("ecx"),
            cl = new Register("cl"),
            edx = new Register("edx"),
            dl = new Register("dl"),
            edi = new Register("edi"),
            esi = new Register("esi"),
            esp = new Register("esp"),
            ebp = new Register("ebp"),
            eip = new Register("eip");

    public Register(String name) {
        this.name = name;
    }

    /* toString
     * Arguments:
     *
     * returns the register as a string
     */
    public String toString() {
        return "%" + this.name;
    }
}
