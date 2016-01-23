/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ALoopStmt extends PLoopStmt
{
    private TLoop _left_;
    private TWhile _while_;
    private PExpression _expression_;
    private final LinkedList<TNewline> _newline_ = new LinkedList<TNewline>();
    private PStatementList _statementList_;
    private TEnd _end_;
    private TLoop _right_;

    public ALoopStmt()
    {
        // Constructor
    }

    public ALoopStmt(
        @SuppressWarnings("hiding") TLoop _left_,
        @SuppressWarnings("hiding") TWhile _while_,
        @SuppressWarnings("hiding") PExpression _expression_,
        @SuppressWarnings("hiding") List<?> _newline_,
        @SuppressWarnings("hiding") PStatementList _statementList_,
        @SuppressWarnings("hiding") TEnd _end_,
        @SuppressWarnings("hiding") TLoop _right_)
    {
        // Constructor
        setLeft(_left_);

        setWhile(_while_);

        setExpression(_expression_);

        setNewline(_newline_);

        setStatementList(_statementList_);

        setEnd(_end_);

        setRight(_right_);

    }

    @Override
    public Object clone()
    {
        return new ALoopStmt(
            cloneNode(this._left_),
            cloneNode(this._while_),
            cloneNode(this._expression_),
            cloneList(this._newline_),
            cloneNode(this._statementList_),
            cloneNode(this._end_),
            cloneNode(this._right_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALoopStmt(this);
    }

    public TLoop getLeft()
    {
        return this._left_;
    }

    public void setLeft(TLoop node)
    {
        if(this._left_ != null)
        {
            this._left_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._left_ = node;
    }

    public TWhile getWhile()
    {
        return this._while_;
    }

    public void setWhile(TWhile node)
    {
        if(this._while_ != null)
        {
            this._while_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._while_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
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

    public TEnd getEnd()
    {
        return this._end_;
    }

    public void setEnd(TEnd node)
    {
        if(this._end_ != null)
        {
            this._end_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._end_ = node;
    }

    public TLoop getRight()
    {
        return this._right_;
    }

    public void setRight(TLoop node)
    {
        if(this._right_ != null)
        {
            this._right_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._right_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._left_)
            + toString(this._while_)
            + toString(this._expression_)
            + toString(this._newline_)
            + toString(this._statementList_)
            + toString(this._end_)
            + toString(this._right_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._left_ == child)
        {
            this._left_ = null;
            return;
        }

        if(this._while_ == child)
        {
            this._while_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
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

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        if(this._right_ == child)
        {
            this._right_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._left_ == oldChild)
        {
            setLeft((TLoop) newChild);
            return;
        }

        if(this._while_ == oldChild)
        {
            setWhile((TWhile) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
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

        if(this._end_ == oldChild)
        {
            setEnd((TEnd) newChild);
            return;
        }

        if(this._right_ == oldChild)
        {
            setRight((TLoop) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
