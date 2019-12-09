package com.pri.utilityHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	private WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		System.out.println("=====Wait Helper Constructor ======");
	}
	
	public void waitUntilElementVisible(WebElement element) {
		System.out.println("=====WebDriver for Wait Element Visible ======" + driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementIsClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.getMaxExplicitwaittime());
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementToBeSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.getMaxExplicitwaittime());
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void waitUntilElementTextToBePresent(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.getMaxExplicitwaittime());
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	
	
}
