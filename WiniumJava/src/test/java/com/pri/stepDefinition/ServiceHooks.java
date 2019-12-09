package com.pri.stepDefinition;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pri.utilityHelper.Constants;
import com.pri.utilityHelper.DriverService;
import com.pri.utilityHelper.LoggerHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);
	
	DriverService driverservice;
	
	public ServiceHooks() {
		driverservice = new DriverService();
	}
	
	
	/*
	 * @Author: Pritam.Maibam
	 * @Function Name: initializeDriver
	 * @Description: This function executes before every scenario. It will intialize driver and launch the application if not open already
	 * @Input Parameter: None
	 * @Return Value: None
	 * @Created Date: 11/20/2019
	 * @Modified By:
	 * @Modified Date:
	 * @Modified Comment:
	 */
	@Before
	public void initializeDriver(Scenario scenario) {
		boolean flag = checkForApplicationRunning();
		String scnName = scenario.getName();
		log.info("\n***************************************NEW SCENARIO:"+scnName+" **********************************************");
		log.info("===========Application Under Test is Running?============"+ flag);
		if(flag == false) {
			driverservice.InitializeDriver(Constants.getBrowser());
		}	
	}
	
	
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) driverservice.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			driverservice.driver.close();
			driverservice.driver.quit();
		} /*
			 * else { try { scenario.embed(((TakesScreenshot)
			 * driverservice.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			 * }catch(Exception e) { e.printStackTrace(); } }
			 */

	}
	
	
	public boolean checkForApplicationRunning() {
		boolean isFound = false;
		String line = null;
		try {
			Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\"+"tasklist.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line = input.readLine()) != null) {
				if(line.contains("application name")) {
					isFound = true;
				}
			}
			input.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isFound;
	}
	
	

}
