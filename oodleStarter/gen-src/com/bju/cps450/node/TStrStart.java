/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class TStrStart extends Token
{
    public TStrStart()
    {
        super.setText("\"");
    }

    public TStrStart(int line, int pos)
    {
        super.setText("\"");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TStrStart(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTStrStart(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TStrStart text.");
    }
}
