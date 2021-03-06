package com.bju.cps450.instruction.parameters;

/**
 * Created by tcwetmore on 3/30/16.
 */
public class Label extends Parameter{

    private String label;

    public Label(String label) {
        this.label = label;
    }

    /* toString
     * Arguments:
     *
     * returns the label as a formatted string
     */
    public String toString() {
        return this.label;
    }
}
