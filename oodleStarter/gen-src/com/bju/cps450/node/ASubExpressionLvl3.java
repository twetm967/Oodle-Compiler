/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ASubExpressionLvl3 extends PExpressionLvl3
{
    private PExpressionLvl3 _expressionLvl3_;
    private TSubtraction _subtraction_;
    private PExpressionLvl2 _expressionLvl2_;

    public ASubExpressionLvl3()
    {
        // Constructor
    }

    public ASubExpressionLvl3(
        @SuppressWarnings("hiding") PExpressionLvl3 _expressionLvl3_,
        @SuppressWarnings("hiding") TSubtraction _subtraction_,
        @SuppressWarnings("hiding") PExpressionLvl2 _expressionLvl2_)
    {
        // Constructor
        setExpressionLvl3(_expressionLvl3_);

        setSubtraction(_subtraction_);

        setExpressionLvl2(_expressionLvl2_);

    }

    @Override
    public Object clone()
    {
        return new ASubExpressionLvl3(
            cloneNode(this._expressionLvl3_),
            cloneNode(this._subtraction_),
            cloneNode(this._expressionLvl2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASubExpressionLvl3(this);
    }

    public PExpressionLvl3 getExpressionLvl3()
    {
        return this._expressionLvl3_;
    }

    public void setExpressionLvl3(PExpressionLvl3 node)
    {
        if(this._expressionLvl3_ != null)
        {
            this._expressionLvl3_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionLvl3_ = node;
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

    public PExpressionLvl2 getExpressionLvl2()
    {
        return this._expressionLvl2_;
    }

    public void setExpressionLvl2(PExpressionLvl2 node)
    {
        if(this._expressionLvl2_ != null)
        {
            this._expressionLvl2_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expressionLvl2_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expressionLvl3_)
            + toString(this._subtraction_)
            + toString(this._expressionLvl2_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expressionLvl3_ == child)
        {
            this._expressionLvl3_ = null;
            return;
        }

        if(this._subtraction_ == child)
        {
            this._subtraction_ = null;
            return;
        }

        if(this._expressionLvl2_ == child)
        {
            this._expressionLvl2_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expressionLvl3_ == oldChild)
        {
            setExpressionLvl3((PExpressionLvl3) newChild);
            return;
        }

        if(this._subtraction_ == oldChild)
        {
            setSubtraction((TSubtraction) newChild);
            return;
        }

        if(this._expressionLvl2_ == oldChild)
        {
            setExpressionLvl2((PExpressionLvl2) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}