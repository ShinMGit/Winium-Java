package com.pri.utilityHelper;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	Logger log = LoggerHelper.getLogger(DriverFactory.class);
	
	private WebDriver driver;
	
	/*public WebDriver initializeDriver() {
		log.info("=========="+ System.getProperty("os.name")+"===========");
		
		if(System.getProperty("os.name").contains("7")) {
			DesktopOptions options = new DesktopOptions();
			options.setApplicationPath("C:/path to the application");
			driver = new WiniumDriver (new URL("http://localhost:9999"), options);
			Thread.sleep(30000);
			log.info("=======Winium Driver is invoked========");	
		}else {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app","C:\\Users\\Public\\Desktop\\ABC.lnk");
			try {
				driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723"), capabilities);  //Might failed here
				log.info("=======WinAppDriver invoke successfully in 1st attempt ========");
			}catch (Exception e) {
				log.info("========1st attempt to initialize WAD failed=========");
			}
			Thread.sleep(30000);
			
			//To create a root level driver
			DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
			desktopCapabilities.setCapability("app", "Root");
			WindowsDriver dtSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), desktopCapabilities);
			
			WebElement appWinElem= dtSession.findElement(By.name("Name of the application"));
			
			String appTopLevelWinHandle = appWinElem.getAttribute("NativeWindowHandle");
			int appTopLevelWinHandleInt = Integer.parseInt(appTopLevelWinHandle);
			String appTopLevelWinHandleHex = Integer.toHexString(appTopLevelWinHandleInt);
			
			DesiredCapabilities appCapabilities = new DesiredCapabilities();
			appCapabilities.setCapability("appTopLevelWindow", appTopLevelWinHandleHex);
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), appCapabilities);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.info("==========WinAppDriver is invoked successfully and launch the desired application==========");
			Assert.assertNotNull(driver, "=====Driver is Null======");	
		}
		
		return driver;
	}*/
	
	
	
	
}
