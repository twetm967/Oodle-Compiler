package com.bju.cps450;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.node.*;
import com.bju.cps450.FileManager.*;

import java.io.*;

public class OodleLexer extends Lexer {
	private boolean _print;
	private FileManager _manager;
	
	public OodleLexer(FileManager manager, String fileName, boolean print) throws FileNotFoundException {
		super(new PushbackReader(new BufferedReader(new FileReader(fileName)), 1024));
		_print = print;
		_manager = manager;
	}
	protected void filter() 
	{
		if(this.token instanceof TNewline){
			printCurrentToken(this.token, "cr");
			
		}
		else if(this.token instanceof TBoolean || this.token instanceof TBegin || this.token instanceof TClass || this.token instanceof TElse || 
				this.token instanceof TEnd || this.token instanceof TFalse || this.token instanceof TFrom || this.token instanceof TIf || 
				this.token instanceof TInherits || this.token instanceof TInt || this.token instanceof TIs || this.token instanceof TLoop || 
				this.token instanceof TMe || this.token instanceof TNew || this.token instanceof TNull || this.token instanceof TString || 
				this.token instanceof TThen || this.token instanceof TTrue || this.token instanceof TWhile || this.token instanceof TAnd || 
				this.token instanceof TOr || this.token instanceof TNot )
		{
			printCurrentToken(this.token, "Keyword:" + this.token);
		}
		else if(this.token instanceof TStrIteral)
		{
			printCurrentToken(this.token, "String Literal:" + '"' +this.token);
		}
		else if(this.token instanceof TUnterminatedStr)
		{
			printCurrentToken(this.token, "Unterminated String:" + '"' +this.token.getText().replaceAll("\r", "").replaceAll("\n", ""));
		}
		else if(this.token instanceof TIllegalStr)
		{
			printCurrentToken(this.token, "Illegal String:" + '"' +this.token);
		}
		
		else if(this.token instanceof TStrconcat || this.token instanceof TAddition || this.token instanceof TSubtraction || this.token instanceof TMultiplication || 
				this.token instanceof TDivision || this.token instanceof TComparison || this.token instanceof TAssignment)
		{
			printCurrentToken(this.token, "Operator:" + this.token);
		}
		else if(this.token instanceof TLparen || this.token instanceof TRparen || this.token instanceof TLbrace || this.token instanceof TRbrace || 
				this.token instanceof TComma || this.token instanceof TSemicolon || this.token instanceof TColon || this.token instanceof TDot) 
		{
			printCurrentToken(this.token, "'" + this.token.getText() + "'");
		}
		
		else if(this.token instanceof TIdentifier)
		{
			printCurrentToken(this.token, "Identifer:" + this.token);
		}
		else if(this.token instanceof TInvalidIdentifier)
		{
			printCurrentToken(this.token, "Invalid Identifier:" + this.token);
		}
		else if(this.token instanceof TComment || this.token instanceof TIgnoredNewline || this.token instanceof TBlank)
		{
			this.token = null;
		}
		
		else if(this.token instanceof TUnknown)
		{
			printCurrentToken(this.token, "Unrecognized Char:" + this.token);
		}
	}
	public void printCurrentToken(Token token, String tokenMessage)
	{
		if(this._print)
		{
			String fileInfo = _manager.getFileInformation(token.getLine());
			System.out.println(fileInfo + token.getPos( )+ ":" + "" + tokenMessage);
		}
	}
}
