/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ACallStatement extends PStatement
{
    private PCallStmt _callStmt_;

    public ACallStatement()
    {
        // Constructor
    }

    public ACallStatement(
        @SuppressWarnings("hiding") PCallStmt _callStmt_)
    {
        // Constructor
        setCallStmt(_callStmt_);

    }

    @Override
    public Object clone()
    {
        return new ACallStatement(
            cloneNode(this._callStmt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACallStatement(this);
    }

    public PCallStmt getCallStmt()
    {
        return this._callStmt_;
    }

    public void setCallStmt(PCallStmt node)
    {
        if(this._callStmt_ != null)
        {
            this._callStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._callStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._callStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._callStmt_ == child)
        {
            this._callStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._callStmt_ == oldChild)
        {
            setCallStmt((PCallStmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}