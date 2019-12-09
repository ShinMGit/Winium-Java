package com.pri.utilityHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import org.testng.Assert;


public class FileHelper {
	
	Logger log = LoggerHelper.getLogger(FileHelper.class);
	
	/*
	 * @FunctionName: readInfoPropertiesFile
	 * @Description: This function read value from info.properties file and return
	 * @Param: attribute name in info.properties file
	 * @Return: value of the attribute
	 * @Author: Pritam.Maiabm
	 * @Created Date: Apr-20-2019
	 */
	public String readInfoPropertiesFile(String attribute) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile =  new FileInputStream(System.getProperty("user.dir") + "\\info.properties");
		obj.load(objfile);
		log.info("=====attribute name is=====" + attribute);
		String value = obj.getProperty(attribute);
		log.info("=====attribute value is=====" + value);
		return value;
	}
	
	/*
	 * @FunctionName: readPasswordAndDecrypt
	 * @Description: This function read encrypted password from info.properties file and decoded it
	 * @Param: encoded password name in info.properties file
	 * @Return: decoded password
	 * @Author: Pritam.Maiabm
	 * @Created Date: Apr-20-2019
	 */
	public String readPasswordAndDecrypt(String attribute) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile =  new FileInputStream(System.getProperty("user.dir") + "\\info.properties");
		obj.load(objfile);
		log.info("=====attribute name is=====" + attribute);
		byte[] decodedPwdBytes =  Base64.decodeBase64(obj.getProperty(attribute).getBytes());
		String decodedPwd = new String(decodedPwdBytes);
		return decodedPwd;
	}
	
	/*
	 * @FunctionName: writeToNotepad
	 * @Description: This function read encrypted password from info.properties file and decoded it
	 * @Param: encoded password name in info.properties file
	 * @Return: decoded password
	 * @Author: Pritam.Maiabm
	 * @Created Date: Apr-20-2019
	 */
	public void writeToNotepad(String text) throws IOException {
		/*String p = "TC01";
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/shinmaibam/Documents/Automation/TestRun/"+p+""));*/
		BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.getNotepadWriteLocation()));
		writer.write(text);
		writer.close();
	}
	
	/*
	 * @FunctionName: readNotepad
	 * @Description: This function read text from Notepad and search for a given String
	 * @Param: encoded password name in info.properties file
	 * @Return: decoded password
	 * @Author: Pritam.Maiabm
	 * @Created Date: Apr-20-2019
	 */
	public void readNotepad(String searchtxt) throws IOException {
		String str;
		int linecount = 0;
		int count = 0;
		int indexfound = 0;
		
		FileReader fr = new FileReader(Constants.getNotepadWriteLocation());
		BufferedReader br = new BufferedReader(fr);
		
		while((str = br.readLine()) != null) {
			linecount ++;
			indexfound = str.indexOf(searchtxt);
			if(indexfound > -1) {
				count ++;
				log.info("=====Found search String =====" + count + "=====times=====");
				boolean isStringPresent = str.contains(searchtxt);
				Assert.assertTrue(isStringPresent, "=====Given String is not present=====");
				log.info("=====Location: Search String is found at position: " + indexfound + "===== on line=====" + linecount);
			}
		}
		br.close();
		fr.close();
		
	}
	
	
}
