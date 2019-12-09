package com.pri.utilityHelper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GUIHelper {
	
	private static WebDriver driver;
	static Logger log = LoggerHelper.getLogger(GUIHelper.class);
	WaitHelper wait;
	
	private static String parentWindow;
	static ArrayList<String> glbChildWindowIDs = new ArrayList<String>();
	
	public GUIHelper(WebDriver driver) {
		this.driver = driver;
		wait = new WaitHelper(driver);
	}
	
	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.perform();
	}
	
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	
	public void openNewTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}
	
	public void pressENTERkey() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clickUIElement(WebElement element){
		wait.waitUntilElementVisible(element);
		wait.waitUntilElementIsClickable(element);
		element.click();
	}
	
	public void enterValueToTextBox(WebElement element, String text) {
		//wait = new WaitHelper(driver);
		wait.waitUntilElementVisible(element);
		element.clear();
		element.sendKeys(text);	
	}
	
	public void selectDropdownByVisibleText(WebElement element, String value) {
		wait.waitUntilElementVisible(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public void selectDropdownByIndex(WebElement element, int indx) {
		wait.waitUntilElementVisible(element);
		Select select = new Select(element);
		select.selectByIndex(indx);
	}
	
	public void selectDropdownByValue(WebElement element, String value) {
		wait.waitUntilElementVisible(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static String getParentWinHandle() {
		parentWindow = driver.getWindowHandle();
		log.info("=====Parent Window handle is =====" + parentWindow);
		return parentWindow;
	}
	
	public static void getChildWindowHandles() {
		String childWindow = null;
		int count = 0;
		
		Set<String> windowSwitch = driver.getWindowHandles();
		log.info("=====Size of window handles =====" + windowSwitch.size());
		
		Iterator<String> itr = windowSwitch.iterator();
		
		while (itr.hasNext()) {
			childWindow = String.valueOf(itr.next());
			if(count >= 1) {
				glbChildWindowIDs.add(childWindow);
			}
			count ++;
		}
		for (int i = 0; i < glbChildWindowIDs.size(); i++) {
			log.info("=====Child Window ID ["+i+"] = " + glbChildWindowIDs.get(i));
		}
		log.info("===== Child windows count is =====" + glbChildWindowIDs.size());
	}
	
	public void switchToChildWindow(int indx) {
		driver.switchTo().window(glbChildWindowIDs.get(indx));
	}
	
	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
		log.info("=====Switch Back to Parent Window=====");
	}
}	
