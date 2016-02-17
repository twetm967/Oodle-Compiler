/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethodMiddle extends PMethodMiddle
{
    private TBegin _begin_;
    private final LinkedList<TNewline> _newline_ = new LinkedList<TNewline>();
    private PStatementList _statementList_;

    public AMethodMiddle()
    {
        // Constructor
    }

    public AMethodMiddle(
        @SuppressWarnings("hiding") TBegin _begin_,
        @SuppressWarnings("hiding") List<?> _newline_,
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
            cloneList(this._newline_),
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

    public LinkedList<TNewline> getNewline()
    {
        return this._newline_;
    }

    public void setNewline(List<?> list)
    {
        for(TNewline e : this._newline_)
        {
            e.parent(null);
        }
        this._newline_.clear();

        for(Object obj_e : list)
        {
            TNewline e = (TNewline) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._newline_.add(e);
        }
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

        if(this._newline_.remove(child))
        {
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

        for(ListIterator<TNewline> i = this._newline_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((TNewline) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._statementList_ == oldChild)
        {
            setStatementList((PStatementList) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}