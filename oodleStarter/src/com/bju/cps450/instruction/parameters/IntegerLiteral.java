package com.bju.cps450.instruction.parameters;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class IntegerLiteral extends Parameter{
    private int integer;

    public IntegerLiteral(int integer) {
        this.integer = integer;
    }

    /* toString
     * Arguments:
     *
     * returns the integer literal as a formatted string
     */
    public String toString() {
        return "$" + this.integer;
    }
}
