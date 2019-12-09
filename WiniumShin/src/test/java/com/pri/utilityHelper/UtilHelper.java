package com.pri.utilityHelper;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class UtilHelper {
	
	private WebDriver driver;
	
	static Logger log = LoggerHelper.getLogger(UtilHelper.class);

	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: readFileAsString
	 * @Description: This function reads contains of a file as String
	 * @Input Parameter: File Name as String
	 * @Return Value: File text stored in a String
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public static String readFileAsString(String fileName) throws IOException {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: getDataFromTestDataPropertyFile
	 * @Description: This function return the value for passing paramter from Test Data properties file 
	 * @Input Parameter: Variable name from info.properties file
	 * @Return Value: decoded string
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public static String getDataFromTestDataPropertyFile(String val) throws IOException {
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+ "\\TestData.properties");
		obj.load(objfile);
		String strVal = obj.getProperty(val.trim());
		return strVal;
	}
	
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: getyDescriptionPwd
	 * @Description: This function decode a given String (using Base64) from info.properties file 
	 * @Input Parameter: Variable name from info.properties file
	 * @Return Value: decoded string
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public static String getDescriptionPwd(String role) throws IOException {
		Properties obj = new Properties();
		System.out.println("userid"+ System.getProperty("user.dir"));
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+ "\\info.properties");
		obj.load(objfile);
		byte[] decodedPwdBytes = Base64.decodeBase64(obj.getProperty(role).getBytes());
		String decodedPwd = new String(decodedPwdBytes);
		return decodedPwd;
	}
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: switchToFrame
	 * @Description: This function switch the webdDriver control to give frame name 
	 * @Input Parameter: Frame Name
	 * @Return Value: None
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public void switchToFrame(String frameName) {
		this.driver.switchTo().frame(frameName);
	}
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: getHostName
	 * @Description: This function identify the host name of AUT and returns it
	 * @Input Parameter: None
	 * @Return Value: None
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public static String getHostName() {
		String hostName = "";
		try {
			java.net.InetAddress addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
		} catch (UnknownHostException e) {
			log.info("========Cannot get Host Name========");
		}
		return hostName;
	}
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: switchToFrame
	 * @Description: This function switch the webdDriver control to give frame name 
	 * @Input Parameter: Frame Name
	 * @Return Value: None
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	public static void deletePrinterFile(String filePath) throws IOException {
		if(Files.exists(Paths.get(filePath))) {
			Files.delete(Paths.get(filePath));
			log.info("=======File from give location is deleted successfully=======");
		}
	}
	
	
	
	

}
