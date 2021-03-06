/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ANotExpression extends PExpression
{
    private PExpression _rhs_;

    public ANotExpression()
    {
        // Constructor
    }

    public ANotExpression(
        @SuppressWarnings("hiding") PExpression _rhs_)
    {
        // Constructor
        setRhs(_rhs_);

    }

    @Override
    public Object clone()
    {
        return new ANotExpression(
            cloneNode(this._rhs_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANotExpression(this);
    }

    public PExpression getRhs()
    {
        return this._rhs_;
    }

    public void setRhs(PExpression node)
    {
        if(this._rhs_ != null)
        {
            this._rhs_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rhs_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._rhs_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._rhs_ == child)
        {
            this._rhs_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._rhs_ == oldChild)
        {
            setRhs((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
