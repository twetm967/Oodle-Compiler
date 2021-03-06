/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.analysis;

import com.bju.cps450.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAStart(AStart node);
    void caseAClassDecl(AClassDecl node);
    void caseAInheritsFrom(AInheritsFrom node);
    void caseAVarDecl(AVarDecl node);
    void caseAMethodDecl(AMethodDecl node);
    void caseAArg(AArg node);
    void caseAMethod(AMethod node);
    void caseAIntType(AIntType node);
    void caseAStringType(AStringType node);
    void caseABooleanType(ABooleanType node);
    void caseAIdType(AIdType node);
    void caseAArrayType(AArrayType node);
    void caseAAsgnStatement(AAsgnStatement node);
    void caseAIfStatement(AIfStatement node);
    void caseALoopStatement(ALoopStatement node);
    void caseACallStatement(ACallStatement node);
    void caseAOrExpression(AOrExpression node);
    void caseAAndExpression(AAndExpression node);
    void caseAEqExpression(AEqExpression node);
    void caseAGtExpression(AGtExpression node);
    void caseAGteExpression(AGteExpression node);
    void caseAConcatExpression(AConcatExpression node);
    void caseAAddExpression(AAddExpression node);
    void caseASubExpression(ASubExpression node);
    void caseAMulExpression(AMulExpression node);
    void caseADivExpression(ADivExpression node);
    void caseANotExpression(ANotExpression node);
    void caseAIncExpression(AIncExpression node);
    void caseANegExpression(ANegExpression node);
    void caseAIdentifierExpression(AIdentifierExpression node);
    void caseAStringExpression(AStringExpression node);
    void caseAIntExpression(AIntExpression node);
    void caseATrueExpression(ATrueExpression node);
    void caseAFalseExpression(AFalseExpression node);
    void caseANewObjExpression(ANewObjExpression node);
    void caseAMeExpression(AMeExpression node);
    void caseAExprExpression(AExprExpression node);
    void caseAMcallExpression(AMcallExpression node);
    void caseAArrayExpression(AArrayExpression node);

    void caseTIgnoredNewline(TIgnoredNewline node);
    void caseTNewline(TNewline node);
    void caseTBlank(TBlank node);
    void caseTBoolean(TBoolean node);
    void caseTBegin(TBegin node);
    void caseTClassKey(TClassKey node);
    void caseTElse(TElse node);
    void caseTEnd(TEnd node);
    void caseTFalse(TFalse node);
    void caseTFrom(TFrom node);
    void caseTIf(TIf node);
    void caseTInherits(TInherits node);
    void caseTInt(TInt node);
    void caseTIs(TIs node);
    void caseTLoop(TLoop node);
    void caseTMe(TMe node);
    void caseTNew(TNew node);
    void caseTNull(TNull node);
    void caseTString(TString node);
    void caseTThen(TThen node);
    void caseTTrue(TTrue node);
    void caseTWhile(TWhile node);
    void caseTAnd(TAnd node);
    void caseTOr(TOr node);
    void caseTNot(TNot node);
    void caseTIntLiteral(TIntLiteral node);
    void caseTStrStart(TStrStart node);
    void caseTStrIteral(TStrIteral node);
    void caseTUnterminatedStr(TUnterminatedStr node);
    void caseTIllegalStr(TIllegalStr node);
    void caseTStrconcat(TStrconcat node);
    void caseTAddition(TAddition node);
    void caseTSubtraction(TSubtraction node);
    void caseTMultiplication(TMultiplication node);
    void caseTDivision(TDivision node);
    void caseTEqual(TEqual node);
    void caseTGreaterThan(TGreaterThan node);
    void caseTGreaterEq(TGreaterEq node);
    void caseTAssignment(TAssignment node);
    void caseTLparen(TLparen node);
    void caseTRparen(TRparen node);
    void caseTLbrace(TLbrace node);
    void caseTRbrace(TRbrace node);
    void caseTComma(TComma node);
    void caseTSemicolon(TSemicolon node);
    void caseTColon(TColon node);
    void caseTDot(TDot node);
    void caseTIdentifier(TIdentifier node);
    void caseTComment(TComment node);
    void caseTUnknown(TUnknown node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
