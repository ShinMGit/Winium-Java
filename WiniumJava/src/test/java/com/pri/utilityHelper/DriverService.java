package com.pri.utilityHelper;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class DriverService {

	public static WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(DriverService.class);
	
	public WebDriver InitializeDriver(String browser) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resource/drivers/chromedriver");
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get(Constants.getAppurl());
			//driver.manage().window().maximize();
			log.info("===== Application is launched successfully with Chrome=====");
		}else if (browser.equalsIgnoreCase("InternetExplorer")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/test/resource/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.getAppurl());
			//driver.manage().window().maximize();
			log.info("===== Application is launched successfully with IE=====");
		}else if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.getAppurl());
			//driver.manage().window().maximize();
			log.info("===== Application is launched successfully with Safari=====");
		}
		return driver;
	}
	
}
