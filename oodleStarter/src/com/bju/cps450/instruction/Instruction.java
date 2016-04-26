package com.bju.cps450.instruction;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class Instruction {
    public static Instruction add = new Instruction("addl"),
            sub = new Instruction("subl"),
            push = new Instruction("pushl"),
            pop = new Instruction("popl"),
            call = new Instruction("call"),
            ret = new Instruction("ret"),
            compare = new Instruction("cmpl"),
            je = new Instruction("je"),
            jump = new Instruction("jmp"),
            move = new Instruction("movl"),
            or = new Instruction("orl"),
            and = new Instruction("andl"),
            jg = new Instruction("jg"),
            jge = new Instruction("jge"),
            mul = new Instruction("imul"),
            div = new Instruction("idiv"),
            neg = new Instruction("negl"),
            movzbl = new Instruction("movzbl"),
            sete = new Instruction("sete"),
            setg = new Instruction("setg"),
            setge = new Instruction("setge"),
            setl = new Instruction("setl"),
            jne = new Instruction("jne"),
            cdq = new Instruction("cdq"),
            enter = new Instruction("enter"),
            leave = new Instruction("leave");

    private String name;

    public Instruction(String name) {
        this.name = name;
    }

    /* getName
     * Arguments:
     *
     * Purpose: returns the name of an instruction
     */
    public String getName() {
        return this.name;
    }
}
