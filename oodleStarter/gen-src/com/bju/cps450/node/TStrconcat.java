/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class TStrconcat extends Token
{
    public TStrconcat()
    {
        super.setText("&");
    }

    public TStrconcat(int line, int pos)
    {
        super.setText("&");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TStrconcat(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTStrconcat(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TStrconcat text.");
    }
}
