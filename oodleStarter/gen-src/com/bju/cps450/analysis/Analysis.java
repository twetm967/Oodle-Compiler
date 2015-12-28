/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.analysis;

import com.bju.cps450.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseTString(TString node);
    void caseTThen(TThen node);
    void caseTTrue(TTrue node);
    void caseTWhile(TWhile node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTColon(TColon node);
    void caseTDot(TDot node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}