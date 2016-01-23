/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethodMiddle extends PMethodMiddle
{
    private TBegin _begin_;
    private TNewline _newline_;
    private PStatementList _statementList_;

    public AMethodMiddle()
    {
        // Constructor
    }

    public AMethodMiddle(
        @SuppressWarnings("hiding") TBegin _begin_,
        @SuppressWarnings("hiding") TNewline _newline_,
        @SuppressWarnings("hiding") PStatementList _statementList_)
    {
        // Constructor
        setBegin(_begin_);

        setNewline(_newline_);

        setStatementList(_statementList_);

    }

    @Override
    public Object clone()
    {
        return new AMethodMiddle(
            cloneNode(this._begin_),
            cloneNode(this._newline_),
            cloneNode(this._statementList_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodMiddle(this);
    }

    public TBegin getBegin()
    {
        return this._begin_;
    }

    public void setBegin(TBegin node)
    {
        if(this._begin_ != null)
        {
            this._begin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._begin_ = node;
    }

    public TNewline getNewline()
    {
        return this._newline_;
    }

    public void setNewline(TNewline node)
    {
        if(this._newline_ != null)
        {
            this._newline_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._newline_ = node;
    }

    public PStatementList getStatementList()
    {
        return this._statementList_;
    }

    public void setStatementList(PStatementList node)
    {
        if(this._statementList_ != null)
        {
            this._statementList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._statementList_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._begin_)
            + toString(this._newline_)
            + toString(this._statementList_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._begin_ == child)
        {
            this._begin_ = null;
            return;
        }

        if(this._newline_ == child)
        {
            this._newline_ = null;
            return;
        }

        if(this._statementList_ == child)
        {
            this._statementList_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._begin_ == oldChild)
        {
            setBegin((TBegin) newChild);
            return;
        }

        if(this._newline_ == oldChild)
        {
            setNewline((TNewline) newChild);
            return;
        }

        if(this._statementList_ == oldChild)
        {
            setStatementList((PStatementList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
