/* Oodle.java
 * Author: Ethan McGee
 * Date: 2014-01-23
 * 
 * Purpose: Main class for Oodle compiler project
 */

package com.bju.cps450;
import com.bju.cps450.CmdParser.*;
import com.bju.cps450.FileManager.*;
import com.bju.cps450.node.*;

import java.io.IOException;

import com.bju.cps450.lexer.LexerException;

public class Oodle
{
	/* printHelp
	 * Arguments:
	 * 
	 * Purpose: Writes a help statement to standard out
	 */
	public static void printHelp() {
		System.out.println("Oodle Compiler");
		System.out.println("v 0.1");
		System.out.println("Author: Thomas Wetmore");
		System.out.println("");
		System.out.println("Usage:");
		System.out.println(" java -jar oodle.jar [options] [files]");
	}
	
	/* main
	 * Arguments:
	 *  @args - the list of command line arguments
	 * Purpose: main execution function for compiler
	 */
    public static void main(String[] args) throws IOException, LexerException {
    	String mergedFile;
    	Token token;
    	System.out.println("Oodle compiler successfully started.");
    	if(args.length < 1)
    	{
    		System.out.println("Incorrect system input.");
    		System.exit(1);
    	}
    	else 
    	{
    		System.out.println("Correct input.");
	    	
	    	//command line options
			//parse command line arguments
			CmdParser.ParseCmd(args);
			
			//set applicable values from options class
			if ((Boolean)CmdParser.help) {
				printHelp();
				return;
			}
			
			//combine all ood files
			System.out.println("Starting FileManager");			
			FileManager manager = new FileManager(CmdParser.oodleFiles, "tempOodleFile.ood");
			manager.mergeFiles();
			System.out.println("Merge Complete");
			
			//after files are combined run them through the custom lexer
			System.out.println("Starting Oodle Lexer");
			System.out.println("");
			OodleLexer lexer = new OodleLexer(manager, manager.getTempFileName(), CmdParser.print);
			token = null;
			while (!(token instanceof EOF))
			{
				token = lexer.next();
			}
			
			
    	}
    }
}

