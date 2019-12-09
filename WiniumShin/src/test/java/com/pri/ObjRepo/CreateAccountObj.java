package com.pri.ObjRepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pri.utilityHelper.LoggerHelper;

public class CreateAccountObj {

	private WebDriver driver;
	
	Logger log = LoggerHelper.getLogger(CreateAccountObj.class);
	
	public CreateAccountObj(WebDriver driver) {
		this.driver=driver;
		log.info("=====Create Account Obj Constructor ======");
	}
	
	public WebElement getCreateAccount(){
		return driver.findElement(By.linkText("Create a Google Account"));
	}
	
	public WebElement getHeadingText() {
		return driver.findElement(By.id("headingText"));
	}
	
	public WebElement getFistName() {
		return driver.findElement(By.name("firstName"));
	}
	
	public WebElement getLastName() {
		return driver.findElement(By.name("lastName"));
	}
	
	public WebElement getUserName() {
		return driver.findElement(By.name("Username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("Passwd"));
	}
	
	public WebElement getConfirmPassword() {
		return driver.findElement(By.name("ConfirmPasswd"));
	}
	
	public WebElement getNextButton() {
		return driver.findElement(By.xpath("//span[contains (.,'Next')]"));
	}
}
