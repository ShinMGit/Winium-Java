package com.pri.utilityHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

public class WriteToNotepad {

	/*
	 * This program is to write test into NotePad by creating file name using Test Case Number
	 */
	
	private static final String FilePath = "/Users/shinmaibam/Documents/Automation/TestRun/";
	
	@Test
	public void myTest1() throws IOException {
		String TestCaseNo = "TC01";
		String finaltcNum = TestCaseNo+".txt";
		String FinalFilePath = FilePath+finaltcNum;
		
		System.out.println("Final File Path is ========" + FinalFilePath);
		
		String ToWriteInFile = "Order: 12345";
		
		writeTofile(FinalFilePath, ToWriteInFile);
	}

	@Test
	public void myTest2() throws IOException {
		String TestCaseNo = "TC02";
		String finaltcNum = TestCaseNo+".txt";
		String FinalFilePath = FilePath+finaltcNum;
		
		System.out.println("Final File Path is ========" + FinalFilePath);
		String ToWriteInFile = "Order: 999990";
		
		writeTofile(FinalFilePath, ToWriteInFile);
	}
	
	public void writeTofile(String path, String text) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(text);
		writer.close();
	}
	
	
}
