/* Oodle.java
 * Author: Ethan McGee
 * Date: 2014-01-23
 * 
 * Purpose: Main class for Oodle compiler project
 */

package com.bju.cps450;

import com.bju.cps450.application.Application;
import com.bju.cps450.lexer.LexerException;
import com.bju.cps450.node.Start;
import com.bju.cps450.node.Token;
import com.bju.cps450.parser.Parser;
import com.bju.cps450.parser.ParserException;

import java.io.*;

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
	 * Purpose: main execution function for compiler
	 */
    public static void main(String[] args) throws IOException, LexerException {
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
			
			/*combine all ood files*/
			System.out.println("Starting FileManager");			
			FileManager manager = new FileManager(CmdParser.oodleFiles, "tempOodleFile.ood");
			manager.mergeFiles();
			System.out.println("Merge Complete");
			
			//after files are combined run them through the custom lexer
			System.out.println("Starting Oodle Lexer");
			System.out.println("");
			OodleLexer lexer = new OodleLexer(manager, manager.getTempFileName(), CmdParser.print);

			Parser oodleParser = new Parser(lexer);
			try {
				Start node = oodleParser.parse();
				node.apply(new OodleSymbolTableBuilder());
				SemanticChecker checker = new SemanticChecker();
				node.apply(checker);
				if(checker.getSuccess())
				{
					OodleCodeGenerator codeGen = new OodleCodeGenerator();
					node.apply(codeGen);
					String[] array = CmdParser.oodleFiles.toArray(new String[CmdParser.oodleFiles.size()]);
					String filename = array[0].split("/")[array[0].split("/").length - 1].split("\\.")[0];
					String assembly = Application.getNodeProperties(node).getCode().toAssembly();
					if(CmdParser.printAssembly)
					{
						File file = new File(filename + ".s");
						BufferedWriter writer = new BufferedWriter(new FileWriter(file));
						writer.write(assembly, 0, assembly.length());
						writer.close();
					}
					else {
						File file = new File(filename + ".s");
						BufferedWriter writer = new BufferedWriter(new FileWriter(file));
						writer.write(assembly, 0, assembly.length());
						writer.close();
						ProcessBuilder pb = new ProcessBuilder("gcc", "-m32", "-g", "-o", filename, filename + ".s", "stdlib.o");
						Process p = pb.start();
						int exitCode = -1;
						try {
							exitCode = p.waitFor();
						} catch (InterruptedException e) {
							System.out.println(e.getMessage());
							exitCode = 1;
						}
						if (exitCode == 0) {
							file.delete();
						} else {
							System.out.println("compilation failed:");
							BufferedReader reader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
							String line;
							while ((line = reader.readLine()) != null) {
								System.out.println(line);
							}
						}
					}
				}
			} catch (ParserException e) {
				System.out.println(e.getMessage() + " got: " + e.getToken().getText());
			}


		}
    }
}

