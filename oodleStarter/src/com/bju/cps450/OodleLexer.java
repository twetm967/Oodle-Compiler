package com.bju.cps450;

import com.bju.cps450.lexer.Lexer;
import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.*;

import java.io.*;

public class OodleLexer extends Lexer {
	private boolean _print;
	private FileManager _manager;
	private boolean error = false;
	
	public OodleLexer(FileManager manager, String fileName, boolean print) throws FileNotFoundException {
		super(new PushbackReader(new BufferedReader(new FileReader(fileName)), 1024));
		_print = print;
		_manager = manager;
	}

	//checks to see if token is a NewLine
	public boolean isNewLine(Token _token)
	{
		if (_token instanceof TNewline)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is a keyword
	public boolean isKeyword(Token _token)
	{
		if(this.token instanceof TBoolean || _token instanceof TBegin || _token instanceof TClassKey || _token instanceof TElse ||
				_token instanceof TEnd || _token instanceof TFalse || _token instanceof TFrom || _token instanceof TIf ||
				_token instanceof TInherits || _token instanceof TInt || _token instanceof TIs || _token instanceof TLoop ||
				_token instanceof TMe || _token instanceof TNew || _token instanceof TNull || _token instanceof TString ||
				_token instanceof TThen || _token instanceof TTrue || _token instanceof TWhile || _token instanceof TAnd ||
				_token instanceof TOr || _token instanceof TNot )
		{
			return true;
		}
		return false;
	}
	//checks to see if token is a string literal
	public boolean isStrLiteral (Token _token)
	{
		if (_token instanceof TStrIteral)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is an unterminated string
	public boolean isUnterminatedString(Token _token)
	{
		if (_token instanceof TUnterminatedStr)
		{
			error = true;
			return true;
		}
		return false;
	}

	//checks to see if token is an illegal string
	public boolean isIllegalStr(Token _token)
	{
		if (_token instanceof TIllegalStr)
		{
			error = true;
			return true;
		}
		return false;
	}

	//checks to see if token is an operator
	public boolean isOperator(Token _token)
	{
		if (_token instanceof TStrconcat || _token instanceof TAddition || _token instanceof TSubtraction ||_token instanceof TMultiplication ||
				_token instanceof TDivision || _token instanceof TGreaterEq || _token instanceof TGreaterThan || _token instanceof TEqual || _token instanceof TAssignment)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is a symbol
	public boolean isSymbol(Token _token)
	{
		if (_token instanceof TLparen || _token instanceof TRparen || _token instanceof TLbrace || _token instanceof TRbrace ||
				_token instanceof TComma || _token instanceof TSemicolon || _token instanceof TColon || _token instanceof TDot)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is an identifier
	public boolean isIdentifier(Token _token)
	{
		if (_token instanceof TIdentifier)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is an invalid identifier
	/*public boolean isInvalidIdentifier(Token _token)
	{
		if (_token instanceof TInvalidIdentifier)
		{
			error = true;
			return true;
		}
		return false;
	}*/

	//checks to see if token is an ignored token
	public boolean isIgnore(Token _token)
	{
		if (_token instanceof TComment || _token instanceof TIgnoredNewline || _token instanceof TBlank)
		{
			return true;
		}
		return false;
	}

	//checks to see if token is an unknown token
	public boolean isUnknown(Token _token)
	{
		if (_token instanceof TUnknown)
		{
			error = true;
			return true;
		}
		return false;
	}

	//checks to see if token is an int literal
	public boolean isIntLiteral(Token _token)
	{
		if (_token instanceof TIntLiteral)
		{
			return true;
		}
		return false;
	}

	//determine what the token is and print
	public void parseToken()
	{
		if(isNewLine( this.token)){
			printCurrentToken(this.token, "cr");
		}
		else if(isKeyword(this.token))
		{
			printCurrentToken(this.token, "Keyword:" + this.token);
		}
		else if(isStrLiteral(this.token))
		{
			printCurrentToken(this.token, "String Literal:" + '"' +this.token);
		}
		else if(isIntLiteral(this.token))
		{
			printCurrentToken(this.token, "Int Literal:" + '"' +this.token);
		}
		else if(isUnterminatedString(this.token))
		{
			printCurrentToken(this.token, "Unterminated String:" + '"' +this.token.getText().replaceAll("\r", "").replaceAll("\n", ""));
		}
		else if(isIllegalStr(this.token))
		{
			printCurrentToken(this.token, "Illegal String:" + '"' +this.token);
		}

		else if(isOperator(this.token))
		{
			printCurrentToken(this.token, "Operator:" + this.token);
		}
		else if(isSymbol(this.token))
		{
			printCurrentToken(this.token, "'" + this.token.getText() + "'");
		}

		else if(isIdentifier(this.token))
		{
			printCurrentToken(this.token, "Identifier:" + this.token);
		}
		//else if(isInvalidIdentifier(this.token))
		//{
		//	printCurrentToken(this.token, "Invalid Identifier:" + this.token);
		//}
		else if(isIgnore(this.token))
		{
			this.token = null;
		}

		else if(isUnknown(this.token))
		{
			printCurrentToken(this.token, "Unrecognized Char:" + this.token);
		}
	}

	protected void filter() throws LexerException, IOException
	{
		//determine what the token is and print
		parseToken();
	}
	public void printCurrentToken(Token token, String tokenMessage)
	{
		if(this._print || this.error) //if -ds or error
		{
			//gets the file information and line numbers from the FileManager class
			String fileInfo = _manager.getFileInformation(token.getLine());
			if(this.error) {
				System.out.println("Error: " + fileInfo + token.getPos() + ":" + "" + tokenMessage);
				try
				{
					//if there is a lexer error, continue with the parse
					this.next();
				}
				catch (LexerException e)
				{
					System.out.println("Lexer Error: " + e.getMessage());
				}
				catch (IOException e)
				{
					System.out.println("IO Error: " + e.getMessage());
				}
			}
			else
			{
				//print out the token information if -ds was used
				System.out.println(fileInfo + token.getPos() + ":" + "" + tokenMessage);
			}
		}

	}
}
