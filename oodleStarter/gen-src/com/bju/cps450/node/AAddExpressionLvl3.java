/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AAddExpressionLvl3 extends PExpressionLvl3
{
    private PExpressionLvl3 _expressionLvl3_;
    private TAddition _addition_;
    private PExpressionLvl2 _expressionLvl2_;

    public AAddExpressionLvl3()
    {
        // Constructor
    }

    public AAddExpressionLvl3(
        @SuppressWarnings("hiding") PExpressionLvl3 _expressionLvl3_,
        @SuppressWarnings("hiding") TAddition _addition_,
        @SuppressWarnings("hiding") PExpressionLvl2 _expressionLvl2_)
    {
        // Constructor
        setExpressionLvl3(_expressionLvl3_);

        setAddition(_addition_);

        setExpressionLvl2(_expressionLvl2_);

    }

    @Override
    public Object clone()
    {
        return new AAddExpressionLvl3(
            cloneNode(this._expressionLvl3_),
            cloneNode(this._addition_),
            cloneNode(this._expressionLvl2_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAddExpressionLvl3(this);
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

    public TAddition getAddition()
    {
        return this._addition_;
    }

    public void setAddition(TAddition node)
    {
        if(this._addition_ != null)
        {
            this._addition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._addition_ = node;
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
            + toString(this._addition_)
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

        if(this._addition_ == child)
        {
            this._addition_ = null;
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

        if(this._addition_ == oldChild)
        {
            setAddition((TAddition) newChild);
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