package com.pri.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pri.ObjRepo.CreateAccountObj;
import com.pri.utilityHelper.Constants;
import com.pri.utilityHelper.DriverService;
import com.pri.utilityHelper.GUIHelper;
import com.pri.utilityHelper.LoggerHelper;
import com.pri.utilityHelper.WaitHelper;

public class CreateAccountPage {

	private WebDriver driver;
	CreateAccountObj createAccountObj;
	WaitHelper wait;
	GUIHelper guiHelper;
	
	Logger log = LoggerHelper.getLogger(CreateAccountPage.class);
	
	public static String testCaseNum = null;
	
	//Constructor
	public CreateAccountPage() {
		this.driver=DriverService.driver;
		createAccountObj = new CreateAccountObj(driver);
		wait = new WaitHelper(driver);
		guiHelper = new GUIHelper (driver);
	}
	
	
	
	////////////////////////////////////PAGE ACTION CLASS//////////////////////////////////////
	
	public void testCaseNumber(String tcnum) {
		testCaseNum=tcnum;
		log.info("Test Case numnber is =========== " + testCaseNum);
	}
	
	
	/*
	 * @FunctionName: clickCreateAccountButton
	 * @Description: This function clicks on Create Account button
	 * @Param:None
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	
	public void clickCreateAccountButton() {
		log.info("=====Driver=====" + driver);
		wait.waitUntilElementVisible(createAccountObj.getCreateAccount());
		wait.waitUntilElementIsClickable(createAccountObj.getCreateAccount());
		createAccountObj.getCreateAccount().click();
	}
	
	/*
	 * @FunctionName: verifyHeader
	 * @Description: This function verifies the header of the title page
	 * @Param:None
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void verifyHeader() {
		String headerTxt = null;
		wait.waitUntilElementVisible(createAccountObj.getHeadingText());
		headerTxt = createAccountObj.getHeadingText().getText();
		Assert.assertEquals(headerTxt, Constants.getHeaderText());
		log.info("=====Header is displayed correctly=====");
	}
	
	/*
	 * @FunctionName: enterFirstName
	 * @Description: This function enters value in First Name field
	 * @Param:None
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void enterFirstName(String fName) {
		guiHelper.enterValueToTextBox(createAccountObj.getFistName(), fName);
	}
	
	/*
	 * @FunctionName: enterLastName
	 * @Description: This function enters value in Last Name field
	 * @Param: Last Name as String
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void enterLastName(String lName) {
		guiHelper.enterValueToTextBox(createAccountObj.getLastName(), lName);
	}
	
	/*
	 * @FunctionName: enterUserName
	 * @Description: This function enters value in User Name field
	 * @Param: User Name as String
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void enterUserName(String uName) {
		guiHelper.enterValueToTextBox(createAccountObj.getUserName(), uName);
	}
	
	/*
	 * @FunctionName: enterPassword
	 * @Description: This function enters text in Password field
	 * @Param: Password as String
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void enterPassword(String pwd) {
		guiHelper.enterValueToTextBox(createAccountObj.getPassword(), pwd);
	}
	
	/*
	 * @FunctionName: enterConfirmPassword
	 * @Description: This function enters text in Confirmed Password field
	 * @Param: Password as String
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void enterConfirmPassword(String pwd) {
		guiHelper.enterValueToTextBox(createAccountObj.getConfirmPassword(), pwd);
	}
	
	/*
	 * @FunctionName: clickNextButton
	 * @Description: This function clicks on Next button
	 * @Param:None
	 * @Return: None
	 * @Date Created: 21-Apr-19
	 * @Author: pritam.maibam@gmail.com
	 */
	public void clickNextButton() {
		guiHelper.clickUIElement(createAccountObj.getNextButton());
	}
	
	
}
