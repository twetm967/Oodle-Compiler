package com.bju.cps450;

import java.util.ArrayList;
import java.util.List;
import com.bju.cps450.OriginalOodFile.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class FileManager {
	private List<String> _oodFiles = new ArrayList<String>();
	private String _tempFileName;
	public static File tempFile;
	private List<OriginalOodFile> originalFileMaps = new ArrayList<OriginalOodFile>();
	private int _lineCounter;
	
	//getters/setters
	public String getTempFileName() { return _tempFileName;}
	public List<OriginalOodFile> getFileMaps() {return originalFileMaps;}
	
	
	public FileManager(List<String> oodFiles, String tempFileName)
	{
		 _oodFiles = oodFiles;
		 _tempFileName = tempFileName;
	}
	public void mergeFiles()
	{
		_lineCounter = 1;
		try
		{
			tempFile = null;
			tempFile = new File(_tempFileName);
			System.out.println("Creating temp file");
	    	if(tempFile.exists())
	        {
	    		tempFile.delete(); 
	        }
	    	FileWriter fw = new FileWriter(tempFile);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Number of Files to combine: " + _oodFiles.size());
	    	for(String file : _oodFiles)
	    	{
	    		OriginalOodFile nFile = new OriginalOodFile();
	    		nFile.setStart(_lineCounter);
	    		nFile.setFileName(file);
	    		nFile.setOffset(_lineCounter -1);
	    		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	    		    for(String line; (line = br.readLine()) != null; ++_lineCounter) {
	    		    	//System.out.println("writing data to tempfile");
	    		        bw.write(line + '\n');
	    		    }
	    		}
	    	
				catch(IOException ioe){
					System.out.println("IO Exception" + ioe);
				}
	    		nFile.setEnd(_lineCounter);
	    		originalFileMaps.add(nFile);
	    	}
	    	bw.close();
    	
		}
		catch(IOException ioe){
			System.out.println("IO Exception" + ioe);
		}
	}
	public String getFileInformation(int line)
	{
		String tokenInfo = "";
		int i = 0;
		for(; i < originalFileMaps.size(); ++i)
		{
			OriginalOodFile file = originalFileMaps.get(i);
			if(line >= file.getStart() && line <= file.getEnd())
			{
				tokenInfo += file.getFileName() + ":" + (line-file.getOffset()) + ",";
			}
		}
		
		
		return tokenInfo;
	}
}