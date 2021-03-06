/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class ACallStatement extends PStatement
{
    private PExpression _caller_;
    private TIdentifier _identifier_;
    private final LinkedList<PExpression> _args_ = new LinkedList<PExpression>();

    public ACallStatement()
    {
        // Constructor
    }

    public ACallStatement(
        @SuppressWarnings("hiding") PExpression _caller_,
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _args_)
    {
        // Constructor
        setCaller(_caller_);

        setIdentifier(_identifier_);

        setArgs(_args_);

    }

    @Override
    public Object clone()
    {
        return new ACallStatement(
            cloneNode(this._caller_),
            cloneNode(this._identifier_),
            cloneList(this._args_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseACallStatement(this);
    }

    public PExpression getCaller()
    {
        return this._caller_;
    }

    public void setCaller(PExpression node)
    {
        if(this._caller_ != null)
        {
            this._caller_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._caller_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
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
            + toString(this._caller_)
            + toString(this._identifier_)
            + toString(this._args_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._caller_ == child)
        {
            this._caller_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
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
        if(this._caller_ == oldChild)
        {
            setCaller((PExpression) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
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
