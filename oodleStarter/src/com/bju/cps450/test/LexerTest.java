package com.bju.cps450.test;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.*;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

public class LexerTest extends TestCase {
	Lexer lex;

	public void testSuccessfulScan() throws IOException, LexerException {
		Lexer lexer = new Lexer(new PushbackReader(new BufferedReader(new FileReader("test1.ood"))));
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TAnd.class);
		assertNextToken(lexer, TBoolean.class);
		assertNextToken(lexer, TBegin.class);
		assertNextToken(lexer, TClass.class);
		assertNextToken(lexer, TElse.class);
		assertNextToken(lexer, TEnd.class);
		assertNextToken(lexer, TFalse.class);
		assertNextToken(lexer, TFrom.class);
		assertNextToken(lexer, TIf.class);
		assertNextToken(lexer, TInherits.class);
		assertNextToken(lexer, TInt.class);
		assertNextToken(lexer, TIs.class);
		assertNextToken(lexer, TLoop.class);
		assertNextToken(lexer, TNew.class);
		assertNextToken(lexer, TNot.class);
		assertNextToken(lexer, TOr.class);
		assertNextToken(lexer, TString.class);
		assertNextToken(lexer, TThen.class);
		assertNextToken(lexer, TTrue.class);
		assertNextToken(lexer, TWhile.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TIdentifier.class);
		assertNextToken(lexer, TIdentifier.class);
		assertNextToken(lexer, TInvalidIdentifier.class);
		assertNextToken(lexer, TIntLiteral.class);
		assertNextToken(lexer, TIntLiteral.class);
		assertNextToken(lexer, TIntLiteral.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TStrIteral.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TAssignment.class);
		assertNextToken(lexer, TLparen.class);
		assertNextToken(lexer, TRparen.class);
		assertNextToken(lexer, TLbrace.class);
		assertNextToken(lexer, TRbrace.class);
		assertNextToken(lexer, TComma.class);
		assertNextToken(lexer, TSemicolon.class);
		assertNextToken(lexer, TColon.class);
		assertNextToken(lexer, TDot.class);
		assertNextToken(lexer, TAddition.class);
		assertNextToken(lexer, TSubtraction.class);
		assertNextToken(lexer, TMultiplication.class);
		assertNextToken(lexer, TDivision.class);
		assertNextToken(lexer, TStrconcat.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TStrIteral.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TStrIteral.class);
		assertNextToken(lexer, TStrIteral.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TStrIteral.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TIllegalStr.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TIllegalStr.class);
		assertNextToken(lexer, TNewline.class);
		assertNextToken(lexer, TUnterminatedStr.class);
		assertNextToken(lexer, TUnterminatedStr.class);
		assertNextToken(lexer, TUnknown.class);
		assertNextToken(lexer, EOF.class);
	}

	public boolean isIgnore(Token _token)
	{
		if (_token instanceof TComment || _token instanceof TIgnoredNewline || _token instanceof TBlank || _token instanceof TStrStart)
		{
			return true;
		}
		return false;
	}

	public void assertNextToken(Lexer lexer, Class tokenExpected) throws IOException, LexerException {
		Token t = lexer.next();
		if (isIgnore(t))
		{
			while(isIgnore(t))
			{
				t = lexer.next();
			}
		}
		if(t.getClass().equals(tokenExpected))
		{
			return;
		} else {
			System.out.println("Error: " + t.getLine() + "," + t.getPos() + ": " + t.getClass() + ", Expected: " + tokenExpected.getCanonicalName());
			fail();
		}
	}
}
