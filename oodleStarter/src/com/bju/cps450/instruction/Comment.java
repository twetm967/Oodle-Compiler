package com.bju.cps450.instruction;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class Comment extends InstructionCommand {
    private String comment;

    public Comment(String comment) {
        this.comment = comment;
    }

    /* emit
     * Arguments:
     *
     * Purpose: returns the instruction as a formatted string
     */
    @Override
    public String emit() {
        return "# " + comment + "\n";
    }
}
