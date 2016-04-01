package com.bju.cps450;
import java.util.ArrayList;
import java.util.List;;

public class CmdParser {
	public static boolean print = false;
	public static boolean help = false;
	public static boolean printAssembly = false;
	public static List<String> files = new ArrayList<String>();
	public static List<String> oodleFiles = new ArrayList<String>();
	
	public static void ParseCmd(String[] CmdArgs)
	{
		for(String arg : CmdArgs)
		{
			switch(arg)
			{
				case ("--help"):
				case("-?"):
					help = true;
					break;
				case("-ds"):
					print = true;
					break;
				case("-S"):
				case("-s"):
					printAssembly = true;
				default:
					files.add(arg);
			}
		}
		for (String file : files)
		{
			if (file.endsWith(".ood"))
			{
				oodleFiles.add(file);
			}
		}
	}
}
