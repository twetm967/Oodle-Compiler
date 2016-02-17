/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class APassExpressionLvl4 extends PExpressionLvl4
{
    private PExpressionLvlc _expressionLvlc_;

    public APassExpressionLvl4()
    {
        // Constructor
    }

    public APassExpressionLvl4(
        @SuppressWarnings("hiding") PExpressionLvlc _expressionLvlc_)
    {
        // Constructor
        setExpressionLvlc(_expressionLvlc_);

    }

    @Override
    public Object clone()
    {
        return new APassExpressionLvl4(
            cloneNode(this._expressionLvlc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPassExpressionLvl4(this);
    }

    public PExpressionLvlc getExpressionLvlc()
    {
        return this._expressionLvlc_;
    }

    public void setExpressionLvlc(PExpressionLvlc node)
    {
        if(this._expressionLvlc_ != null)
        {
            this._expressionLvlc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionLvlc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expressionLvlc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expressionLvlc_ == child)
        {
            this._expressionLvlc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expressionLvlc_ == oldChild)
        {
            setExpressionLvlc((PExpressionLvlc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}