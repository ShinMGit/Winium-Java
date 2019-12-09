package com.pri.utilityHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadFromNotepad {
	
	/*
	 * This program is to read value from a NotePad and store in a string
	 */
	
	private static final String FilePath = "/Users/shinmaibam/Documents/Automation/TestRun/";

	@Test
	public void myTest1() throws IOException {
		String TestCaseNo = "TC01";
		String finaltcNum = TestCaseNo+".txt";
		String FinalFilePath = FilePath+finaltcNum;
		
		System.out.println("Final File Path is ========" + FinalFilePath);
		
		readFromFile(FinalFilePath);
	}

	@Test
	public void myTest2() throws IOException {
		String TestCaseNo = "TC02";
		String finaltcNum = TestCaseNo+".txt";
		String FinalFilePath = FilePath+finaltcNum;
		
		System.out.println("Final File Path is ========" + FinalFilePath);
		
		readFromFile(FinalFilePath);
	}
	
	public void readFromFile(String path) throws IOException {
		String str = null;
		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		
		while((str = br.readLine()) != null) {
			String readVal =  str;
			System.out.println("Value from Notepad ======" + readVal);
		}
		br.close();
		fr.close();
	}
	
	
}
