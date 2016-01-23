/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ALoopStatement extends PStatement
{
    private PLoopStmt _loopStmt_;

    public ALoopStatement()
    {
        // Constructor
    }

    public ALoopStatement(
        @SuppressWarnings("hiding") PLoopStmt _loopStmt_)
    {
        // Constructor
        setLoopStmt(_loopStmt_);

    }

    @Override
    public Object clone()
    {
        return new ALoopStatement(
            cloneNode(this._loopStmt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALoopStatement(this);
    }

    public PLoopStmt getLoopStmt()
    {
        return this._loopStmt_;
    }

    public void setLoopStmt(PLoopStmt node)
    {
        if(this._loopStmt_ != null)
        {
            this._loopStmt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._loopStmt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._loopStmt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._loopStmt_ == child)
        {
            this._loopStmt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._loopStmt_ == oldChild)
        {
            setLoopStmt((PLoopStmt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
