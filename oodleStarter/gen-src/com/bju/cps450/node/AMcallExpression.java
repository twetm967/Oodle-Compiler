/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMcallExpression extends PExpression
{
    private PExpression _start_;
    private TIdentifier _method_;
    private final LinkedList<PExpression> _args_ = new LinkedList<PExpression>();

    public AMcallExpression()
    {
        // Constructor
    }

    public AMcallExpression(
        @SuppressWarnings("hiding") PExpression _start_,
        @SuppressWarnings("hiding") TIdentifier _method_,
        @SuppressWarnings("hiding") List<?> _args_)
    {
        // Constructor
        setStart(_start_);

        setMethod(_method_);

        setArgs(_args_);

    }

    @Override
    public Object clone()
    {
        return new AMcallExpression(
            cloneNode(this._start_),
            cloneNode(this._method_),
            cloneList(this._args_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMcallExpression(this);
    }

    public PExpression getStart()
    {
        return this._start_;
    }

    public void setStart(PExpression node)
    {
        if(this._start_ != null)
        {
            this._start_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._start_ = node;
    }

    public TIdentifier getMethod()
    {
        return this._method_;
    }

    public void setMethod(TIdentifier node)
    {
        if(this._method_ != null)
        {
            this._method_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._method_ = node;
    }

    public LinkedList<PExpression> getArgs()
    {
        return this._args_;
    }

    public void setArgs(List<?> list)
    {
        for(PExpression e : this._args_)
        {
            e.parent(null);
        }
        this._args_.clear();

        for(Object obj_e : list)
        {
            PExpression e = (PExpression) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._args_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._start_)
            + toString(this._method_)
            + toString(this._args_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._start_ == child)
        {
            this._start_ = null;
            return;
        }

        if(this._method_ == child)
        {
            this._method_ = null;
            return;
        }

        if(this._args_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._start_ == oldChild)
        {
            setStart((PExpression) newChild);
            return;
        }

        if(this._method_ == oldChild)
        {
            setMethod((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PExpression> i = this._args_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PExpression) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
