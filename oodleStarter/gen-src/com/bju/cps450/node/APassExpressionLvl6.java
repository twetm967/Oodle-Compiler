/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class APassExpressionLvl6 extends PExpressionLvl6
{
    private PExpressionLvl5 _expressionLvl5_;

    public APassExpressionLvl6()
    {
        // Constructor
    }

    public APassExpressionLvl6(
        @SuppressWarnings("hiding") PExpressionLvl5 _expressionLvl5_)
    {
        // Constructor
        setExpressionLvl5(_expressionLvl5_);

    }

    @Override
    public Object clone()
    {
        return new APassExpressionLvl6(
            cloneNode(this._expressionLvl5_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPassExpressionLvl6(this);
    }

    public PExpressionLvl5 getExpressionLvl5()
    {
        return this._expressionLvl5_;
    }

    public void setExpressionLvl5(PExpressionLvl5 node)
    {
        if(this._expressionLvl5_ != null)
        {
            this._expressionLvl5_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionLvl5_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expressionLvl5_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expressionLvl5_ == child)
        {
            this._expressionLvl5_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expressionLvl5_ == oldChild)
        {
            setExpressionLvl5((PExpressionLvl5) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
