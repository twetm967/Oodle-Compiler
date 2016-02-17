/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ANegExpressionLvl1 extends PExpressionLvl1
{
    private TSubtraction _subtraction_;
    private PExpressionLvl1 _expressionLvl1_;

    public ANegExpressionLvl1()
    {
        // Constructor
    }

    public ANegExpressionLvl1(
        @SuppressWarnings("hiding") TSubtraction _subtraction_,
        @SuppressWarnings("hiding") PExpressionLvl1 _expressionLvl1_)
    {
        // Constructor
        setSubtraction(_subtraction_);

        setExpressionLvl1(_expressionLvl1_);

    }

    @Override
    public Object clone()
    {
        return new ANegExpressionLvl1(
            cloneNode(this._subtraction_),
            cloneNode(this._expressionLvl1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANegExpressionLvl1(this);
    }

    public TSubtraction getSubtraction()
    {
        return this._subtraction_;
    }

    public void setSubtraction(TSubtraction node)
    {
        if(this._subtraction_ != null)
        {
            this._subtraction_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._subtraction_ = node;
    }

    public PExpressionLvl1 getExpressionLvl1()
    {
        return this._expressionLvl1_;
    }

    public void setExpressionLvl1(PExpressionLvl1 node)
    {
        if(this._expressionLvl1_ != null)
        {
            this._expressionLvl1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionLvl1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._subtraction_)
            + toString(this._expressionLvl1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._subtraction_ == child)
        {
            this._subtraction_ = null;
            return;
        }

        if(this._expressionLvl1_ == child)
        {
            this._expressionLvl1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._subtraction_ == oldChild)
        {
            setSubtraction((TSubtraction) newChild);
            return;
        }

        if(this._expressionLvl1_ == oldChild)
        {
            setExpressionLvl1((PExpressionLvl1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}