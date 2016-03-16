/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.analysis;

import java.util.*;
import com.bju.cps450.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPStart().apply(this);
        outStart(node);
    }

    public void inAStart(AStart node)
    {
        defaultIn(node);
    }

    public void outAStart(AStart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStart(AStart node)
    {
        inAStart(node);
        {
            List<PClassDecl> copy = new ArrayList<PClassDecl>(node.getClassDecl());
            Collections.reverse(copy);
            for(PClassDecl e : copy)
            {
                e.apply(this);
            }
        }
        outAStart(node);
    }

    public void inAClassDecl(AClassDecl node)
    {
        defaultIn(node);
    }

    public void outAClassDecl(AClassDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAClassDecl(AClassDecl node)
    {
        inAClassDecl(node);
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        {
            List<PMethodDecl> copy = new ArrayList<PMethodDecl>(node.getMethodDecl());
            Collections.reverse(copy);
            for(PMethodDecl e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            Collections.reverse(copy);
            for(PVarDecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getInheritsFrom() != null)
        {
            node.getInheritsFrom().apply(this);
        }
        if(node.getStart() != null)
        {
            node.getStart().apply(this);
        }
        outAClassDecl(node);
    }

    public void inAInheritsFrom(AInheritsFrom node)
    {
        defaultIn(node);
    }

    public void outAInheritsFrom(AInheritsFrom node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInheritsFrom(AInheritsFrom node)
    {
        inAInheritsFrom(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAInheritsFrom(node);
    }

    public void inAVarDecl(AVarDecl node)
    {
        defaultIn(node);
    }

    public void outAVarDecl(AVarDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarDecl(AVarDecl node)
    {
        inAVarDecl(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAVarDecl(node);
    }

    public void inAMethodDecl(AMethodDecl node)
    {
        defaultIn(node);
    }

    public void outAMethodDecl(AMethodDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethodDecl(AMethodDecl node)
    {
        inAMethodDecl(node);
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PVarDecl> copy = new ArrayList<PVarDecl>(node.getVarDecl());
            Collections.reverse(copy);
            for(PVarDecl e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        {
            List<PArg> copy = new ArrayList<PArg>(node.getArg());
            Collections.reverse(copy);
            for(PArg e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getStart() != null)
        {
            node.getStart().apply(this);
        }
        outAMethodDecl(node);
    }

    public void inAArg(AArg node)
    {
        defaultIn(node);
    }

    public void outAArg(AArg node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArg(AArg node)
    {
        inAArg(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAArg(node);
    }

    public void inAMethod(AMethod node)
    {
        defaultIn(node);
    }

    public void outAMethod(AMethod node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMethod(AMethod node)
    {
        inAMethod(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAMethod(node);
    }

    public void inAIntType(AIntType node)
    {
        defaultIn(node);
    }

    public void outAIntType(AIntType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntType(AIntType node)
    {
        inAIntType(node);
        if(node.getInt() != null)
        {
            node.getInt().apply(this);
        }
        outAIntType(node);
    }

    public void inAStringType(AStringType node)
    {
        defaultIn(node);
    }

    public void outAStringType(AStringType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringType(AStringType node)
    {
        inAStringType(node);
        if(node.getString() != null)
        {
            node.getString().apply(this);
        }
        outAStringType(node);
    }

    public void inABooleanType(ABooleanType node)
    {
        defaultIn(node);
    }

    public void outABooleanType(ABooleanType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseABooleanType(ABooleanType node)
    {
        inABooleanType(node);
        if(node.getBoolean() != null)
        {
            node.getBoolean().apply(this);
        }
        outABooleanType(node);
    }

    public void inAIdType(AIdType node)
    {
        defaultIn(node);
    }

    public void outAIdType(AIdType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdType(AIdType node)
    {
        inAIdType(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdType(node);
    }

    public void inAArrayType(AArrayType node)
    {
        defaultIn(node);
    }

    public void outAArrayType(AArrayType node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayType(AArrayType node)
    {
        inAArrayType(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outAArrayType(node);
    }

    public void inAAsgnStatement(AAsgnStatement node)
    {
        defaultIn(node);
    }

    public void outAAsgnStatement(AAsgnStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAsgnStatement(AAsgnStatement node)
    {
        inAAsgnStatement(node);
        if(node.getSecond() != null)
        {
            node.getSecond().apply(this);
        }
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getFirst());
            Collections.reverse(copy);
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAAsgnStatement(node);
    }

    public void inAIfStatement(AIfStatement node)
    {
        defaultIn(node);
    }

    public void outAIfStatement(AIfStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStatement(AIfStatement node)
    {
        inAIfStatement(node);
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getFalse());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getTrue());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getCond() != null)
        {
            node.getCond().apply(this);
        }
        if(node.getIf() != null)
        {
            node.getIf().apply(this);
        }
        outAIfStatement(node);
    }

    public void inALoopStatement(ALoopStatement node)
    {
        defaultIn(node);
    }

    public void outALoopStatement(ALoopStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALoopStatement(ALoopStatement node)
    {
        inALoopStatement(node);
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatement());
            Collections.reverse(copy);
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getCond() != null)
        {
            node.getCond().apply(this);
        }
        outALoopStatement(node);
    }

    public void inACallStatement(ACallStatement node)
    {
        defaultIn(node);
    }

    public void outACallStatement(ACallStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACallStatement(ACallStatement node)
    {
        inACallStatement(node);
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getArgs());
            Collections.reverse(copy);
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        if(node.getCaller() != null)
        {
            node.getCaller().apply(this);
        }
        outACallStatement(node);
    }

    public void inAOrExpression(AOrExpression node)
    {
        defaultIn(node);
    }

    public void outAOrExpression(AOrExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOrExpression(AOrExpression node)
    {
        inAOrExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAOrExpression(node);
    }

    public void inAAndExpression(AAndExpression node)
    {
        defaultIn(node);
    }

    public void outAAndExpression(AAndExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAndExpression(AAndExpression node)
    {
        inAAndExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAAndExpression(node);
    }

    public void inAEqExpression(AEqExpression node)
    {
        defaultIn(node);
    }

    public void outAEqExpression(AEqExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqExpression(AEqExpression node)
    {
        inAEqExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAEqExpression(node);
    }

    public void inAGtExpression(AGtExpression node)
    {
        defaultIn(node);
    }

    public void outAGtExpression(AGtExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGtExpression(AGtExpression node)
    {
        inAGtExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAGtExpression(node);
    }

    public void inAGteExpression(AGteExpression node)
    {
        defaultIn(node);
    }

    public void outAGteExpression(AGteExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGteExpression(AGteExpression node)
    {
        inAGteExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAGteExpression(node);
    }

    public void inAConcatExpression(AConcatExpression node)
    {
        defaultIn(node);
    }

    public void outAConcatExpression(AConcatExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAConcatExpression(AConcatExpression node)
    {
        inAConcatExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAConcatExpression(node);
    }

    public void inAAddExpression(AAddExpression node)
    {
        defaultIn(node);
    }

    public void outAAddExpression(AAddExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAddExpression(AAddExpression node)
    {
        inAAddExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAAddExpression(node);
    }

    public void inASubExpression(ASubExpression node)
    {
        defaultIn(node);
    }

    public void outASubExpression(ASubExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubExpression(ASubExpression node)
    {
        inASubExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outASubExpression(node);
    }

    public void inAMulExpression(AMulExpression node)
    {
        defaultIn(node);
    }

    public void outAMulExpression(AMulExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMulExpression(AMulExpression node)
    {
        inAMulExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outAMulExpression(node);
    }

    public void inADivExpression(ADivExpression node)
    {
        defaultIn(node);
    }

    public void outADivExpression(ADivExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivExpression(ADivExpression node)
    {
        inADivExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        if(node.getLhs() != null)
        {
            node.getLhs().apply(this);
        }
        outADivExpression(node);
    }

    public void inANotExpression(ANotExpression node)
    {
        defaultIn(node);
    }

    public void outANotExpression(ANotExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANotExpression(ANotExpression node)
    {
        inANotExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        outANotExpression(node);
    }

    public void inAIncExpression(AIncExpression node)
    {
        defaultIn(node);
    }

    public void outAIncExpression(AIncExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIncExpression(AIncExpression node)
    {
        inAIncExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        outAIncExpression(node);
    }

    public void inANegExpression(ANegExpression node)
    {
        defaultIn(node);
    }

    public void outANegExpression(ANegExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegExpression(ANegExpression node)
    {
        inANegExpression(node);
        if(node.getRhs() != null)
        {
            node.getRhs().apply(this);
        }
        outANegExpression(node);
    }

    public void inAIdentifierExpression(AIdentifierExpression node)
    {
        defaultIn(node);
    }

    public void outAIdentifierExpression(AIdentifierExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIdentifierExpression(AIdentifierExpression node)
    {
        inAIdentifierExpression(node);
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAIdentifierExpression(node);
    }

    public void inAStringExpression(AStringExpression node)
    {
        defaultIn(node);
    }

    public void outAStringExpression(AStringExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringExpression(AStringExpression node)
    {
        inAStringExpression(node);
        if(node.getStrIteral() != null)
        {
            node.getStrIteral().apply(this);
        }
        if(node.getStrStart() != null)
        {
            node.getStrStart().apply(this);
        }
        outAStringExpression(node);
    }

    public void inAIntExpression(AIntExpression node)
    {
        defaultIn(node);
    }

    public void outAIntExpression(AIntExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIntExpression(AIntExpression node)
    {
        inAIntExpression(node);
        if(node.getIntLiteral() != null)
        {
            node.getIntLiteral().apply(this);
        }
        outAIntExpression(node);
    }

    public void inATrueExpression(ATrueExpression node)
    {
        defaultIn(node);
    }

    public void outATrueExpression(ATrueExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATrueExpression(ATrueExpression node)
    {
        inATrueExpression(node);
        if(node.getTrue() != null)
        {
            node.getTrue().apply(this);
        }
        outATrueExpression(node);
    }

    public void inAFalseExpression(AFalseExpression node)
    {
        defaultIn(node);
    }

    public void outAFalseExpression(AFalseExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFalseExpression(AFalseExpression node)
    {
        inAFalseExpression(node);
        if(node.getFalse() != null)
        {
            node.getFalse().apply(this);
        }
        outAFalseExpression(node);
    }

    public void inANewObjExpression(ANewObjExpression node)
    {
        defaultIn(node);
    }

    public void outANewObjExpression(ANewObjExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANewObjExpression(ANewObjExpression node)
    {
        inANewObjExpression(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        outANewObjExpression(node);
    }

    public void inAMeExpression(AMeExpression node)
    {
        defaultIn(node);
    }

    public void outAMeExpression(AMeExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMeExpression(AMeExpression node)
    {
        inAMeExpression(node);
        if(node.getMe() != null)
        {
            node.getMe().apply(this);
        }
        outAMeExpression(node);
    }

    public void inAExprExpression(AExprExpression node)
    {
        defaultIn(node);
    }

    public void outAExprExpression(AExprExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprExpression(AExprExpression node)
    {
        inAExprExpression(node);
        if(node.getExpression() != null)
        {
            node.getExpression().apply(this);
        }
        outAExprExpression(node);
    }

    public void inAMcallExpression(AMcallExpression node)
    {
        defaultIn(node);
    }

    public void outAMcallExpression(AMcallExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMcallExpression(AMcallExpression node)
    {
        inAMcallExpression(node);
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getArgs());
            Collections.reverse(copy);
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getMethod() != null)
        {
            node.getMethod().apply(this);
        }
        if(node.getStart() != null)
        {
            node.getStart().apply(this);
        }
        outAMcallExpression(node);
    }

    public void inAArrayExpression(AArrayExpression node)
    {
        defaultIn(node);
    }

    public void outAArrayExpression(AArrayExpression node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAArrayExpression(AArrayExpression node)
    {
        inAArrayExpression(node);
        {
            List<PExpression> copy = new ArrayList<PExpression>(node.getExpression());
            Collections.reverse(copy);
            for(PExpression e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getIdentifier() != null)
        {
            node.getIdentifier().apply(this);
        }
        outAArrayExpression(node);
    }
}
