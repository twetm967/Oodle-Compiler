/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.analysis;

import java.util.*;
import com.bju.cps450.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStart(AStart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAClassDecl(AClassDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInheritsFrom(AInheritsFrom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVarDecl(AVarDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethodDecl(AMethodDecl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArg(AArg node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMethod(AMethod node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringType(AStringType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdType(AIdType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayType(AArrayType node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAsgnStatement(AAsgnStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALoopStatement(ALoopStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseACallStatement(ACallStatement node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAOrExpression(AOrExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAndExpression(AAndExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEqExpression(AEqExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGtExpression(AGtExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAGteExpression(AGteExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAConcatExpression(AConcatExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddExpression(AAddExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubExpression(ASubExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMulExpression(AMulExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivExpression(ADivExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANotExpression(ANotExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIncExpression(AIncExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegExpression(ANegExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAStringExpression(AStringExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIntExpression(AIntExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseATrueExpression(ATrueExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANewObjExpression(ANewObjExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMeExpression(AMeExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprExpression(AExprExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMcallExpression(AMcallExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAArrayExpression(AArrayExpression node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIgnoredNewline(TIgnoredNewline node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNewline(TNewline node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBoolean(TBoolean node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBegin(TBegin node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTClassKey(TClassKey node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTElse(TElse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnd(TEnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFalse(TFalse node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFrom(TFrom node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIf(TIf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInherits(TInherits node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInt(TInt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIs(TIs node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLoop(TLoop node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMe(TMe node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNew(TNew node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNull(TNull node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTString(TString node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTThen(TThen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTrue(TTrue node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTWhile(TWhile node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAnd(TAnd node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOr(TOr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNot(TNot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIntLiteral(TIntLiteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStrStart(TStrStart node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStrIteral(TStrIteral node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTUnterminatedStr(TUnterminatedStr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIllegalStr(TIllegalStr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStrconcat(TStrconcat node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAddition(TAddition node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSubtraction(TSubtraction node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMultiplication(TMultiplication node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDivision(TDivision node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEqual(TEqual node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterThan(TGreaterThan node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTGreaterEq(TGreaterEq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAssignment(TAssignment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLparen(TLparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRparen(TRparen node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLbrace(TLbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRbrace(TRbrace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComma(TComma node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSemicolon(TSemicolon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTColon(TColon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDot(TDot node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTIdentifier(TIdentifier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInvalidIdentifier(TInvalidIdentifier node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTComment(TComment node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTUnknown(TUnknown node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
