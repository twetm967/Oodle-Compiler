package com.bju.cps450;

public class OriginalOodFile {
	private int _start;
	private int _end;
	private String _fileName;
	private int _offset;
	
	//constructors
	public OriginalOodFile(){}
	public OriginalOodFile(String fileName, int start, int end, int offset)
	{
		_start = start;
		_fileName = fileName;
		_end = end;
		_offset = offset;
	}
	
	//getters
	public String getFileName() {return _fileName;}
	public int getStart() {return _start;}
	public int getEnd() {return _end;}
	public int getOffset() {return _offset;}
	
	//setters
	public void setFileName(String fileName) {_fileName = fileName;}
	public void setStart(int start) { _start = start;}
	public void setEnd(int end) { _end = end;}
	public void setOffset(int offset) {_offset = offset;}

}
