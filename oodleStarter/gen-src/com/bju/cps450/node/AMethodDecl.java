/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethodDecl extends PMethodDecl
{
    private PMethodHeader _methodHeader_;
    private PMethodMiddle _methodMiddle_;
    private PMethodEnd _methodEnd_;

    public AMethodDecl()
    {
        // Constructor
    }

    public AMethodDecl(
        @SuppressWarnings("hiding") PMethodHeader _methodHeader_,
        @SuppressWarnings("hiding") PMethodMiddle _methodMiddle_,
        @SuppressWarnings("hiding") PMethodEnd _methodEnd_)
    {
        // Constructor
        setMethodHeader(_methodHeader_);

        setMethodMiddle(_methodMiddle_);

        setMethodEnd(_methodEnd_);

    }

    @Override
    public Object clone()
    {
        return new AMethodDecl(
            cloneNode(this._methodHeader_),
            cloneNode(this._methodMiddle_),
            cloneNode(this._methodEnd_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodDecl(this);
    }

    public PMethodHeader getMethodHeader()
    {
        return this._methodHeader_;
    }

    public void setMethodHeader(PMethodHeader node)
    {
        if(this._methodHeader_ != null)
        {
            this._methodHeader_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodHeader_ = node;
    }

    public PMethodMiddle getMethodMiddle()
    {
        return this._methodMiddle_;
    }

    public void setMethodMiddle(PMethodMiddle node)
    {
        if(this._methodMiddle_ != null)
        {
            this._methodMiddle_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodMiddle_ = node;
    }

    public PMethodEnd getMethodEnd()
    {
        return this._methodEnd_;
    }

    public void setMethodEnd(PMethodEnd node)
    {
        if(this._methodEnd_ != null)
        {
            this._methodEnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._methodEnd_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._methodHeader_)
            + toString(this._methodMiddle_)
            + toString(this._methodEnd_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._methodHeader_ == child)
        {
            this._methodHeader_ = null;
            return;
        }

        if(this._methodMiddle_ == child)
        {
            this._methodMiddle_ = null;
            return;
        }

        if(this._methodEnd_ == child)
        {
            this._methodEnd_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._methodHeader_ == oldChild)
        {
            setMethodHeader((PMethodHeader) newChild);
            return;
        }

        if(this._methodMiddle_ == oldChild)
        {
            setMethodMiddle((PMethodMiddle) newChild);
            return;
        }

        if(this._methodEnd_ == oldChild)
        {
            setMethodEnd((PMethodEnd) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
