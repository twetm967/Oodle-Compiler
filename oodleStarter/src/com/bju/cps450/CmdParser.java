package com.bju.cps450;
import java.util.ArrayList;
import java.util.List;;

public class CmdParser {
	public static boolean print = false;
	public static boolean help = false;
	public static String[] possibleFiles;
	public static List<String> files = new ArrayList<String>();
	
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
				default:
					files.add(arg);
			}
		}
	}
}
