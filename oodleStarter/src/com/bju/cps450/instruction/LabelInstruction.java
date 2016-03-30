package com.bju.cps450.instruction;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class LabelInstruction extends InstructionCommand {
    private String label;

    public LabelInstruction(String label) {
        this.label = label;
    }

    /* emit
     * Arguments:
     *
     * Purpose: returns the instruction as a formatted string
     */
    @Override
    public String emit() {
        return label + ":\n";
    }
}
