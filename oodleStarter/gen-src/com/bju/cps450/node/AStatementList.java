/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AStatementList extends PStatementList
{
    private final LinkedList<PStatementListHelper> _statementListHelper_ = new LinkedList<PStatementListHelper>();

    public AStatementList()
    {
        // Constructor
    }

    public AStatementList(
        @SuppressWarnings("hiding") List<?> _statementListHelper_)
    {
        // Constructor
        setStatementListHelper(_statementListHelper_);

    }

    @Override
    public Object clone()
    {
        return new AStatementList(
            cloneList(this._statementListHelper_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStatementList(this);
    }

    public LinkedList<PStatementListHelper> getStatementListHelper()
    {
        return this._statementListHelper_;
    }

    public void setStatementListHelper(List<?> list)
    {
        for(PStatementListHelper e : this._statementListHelper_)
        {
            e.parent(null);
        }
        this._statementListHelper_.clear();

        for(Object obj_e : list)
        {
            PStatementListHelper e = (PStatementListHelper) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._statementListHelper_.add(e);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._statementListHelper_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._statementListHelper_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PStatementListHelper> i = this._statementListHelper_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PStatementListHelper) newChild);
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
