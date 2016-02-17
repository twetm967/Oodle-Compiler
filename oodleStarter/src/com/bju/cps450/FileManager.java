package com.bju.cps450;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	private List<String> _oodFiles = new ArrayList<String>();
	private String _tempFileName;
	public static File tempFile;
	private List<OriginalOodFile> originalFileMaps = new ArrayList<OriginalOodFile>();
	private int _lineCounter;
	private OriginalOodFile lastUsed;
	
	//getters/setters
	public String getTempFileName() { return _tempFileName;}
	public List<OriginalOodFile> getFileMaps() {return originalFileMaps;}
	
	
	public FileManager(List<String> oodFiles, String tempFileName)
	{
		 _oodFiles = oodFiles;
		 _tempFileName = tempFileName;
	}

	//merges oodle files together for lexical analysis
	public void mergeFiles()
	{
		_lineCounter = 1;
		try
		{
			tempFile = null;
			//creates a temp file to store the compined files
			tempFile = new File(_tempFileName);
			System.out.println("Creating temp file");
	    	if(tempFile.exists())
	        {
	    		tempFile.delete(); 
	        }
			//actually creates the file
	    	FileWriter fw = new FileWriter(tempFile);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Number of Files to combine: " + _oodFiles.size());
			//loops through files to combine into the tempfile
	    	for(String file : _oodFiles)
	    	{
	    		OriginalOodFile nFile = new OriginalOodFile();
	    		nFile.setStart(_lineCounter); //keeps track of original file start line number
	    		nFile.setFileName(file);
	    		nFile.setOffset(_lineCounter -1); //original fil offset
	    		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	    		    for(String line; (line = br.readLine()) != null; ++_lineCounter) {
	    		        bw.write(line + '\n');
	    		    }
	    		}
	    	
				catch(IOException ioe){
					System.out.println("IO Exception" + ioe);
				}
	    		nFile.setEnd(_lineCounter);// original file end line number
	    		originalFileMaps.add(nFile);
	    	}
	    	bw.close();
    	
		}
		catch(IOException ioe){
			System.out.println("IO Exception" + ioe);
		}
	}

	//gets file information and line numbers for lexical output
	public String getFileInformation(int line)
	{
		String tokenInfo = "";
		int i = 0;
		if(lastUsed != null)
		{
			if (line >= lastUsed.getStart() && line <= lastUsed.getEnd()) {
				tokenInfo += lastUsed.getFileName() + ":" + (line - lastUsed.getOffset()) + ",";
			}
		}
		else {

			for (; i < originalFileMaps.size(); ++i) {
				OriginalOodFile file = originalFileMaps.get(i);
				if (line >= file.getStart() && line <= file.getEnd()) {
					tokenInfo += file.getFileName() + ":" + (line - file.getOffset()) + ",";
					lastUsed = file;
				}
			}
		}
		
		return tokenInfo;
	}
}