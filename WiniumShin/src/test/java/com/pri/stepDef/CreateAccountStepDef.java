package com.pri.stepDef;

import org.junit.runner.RunWith;

import com.pri.page.CreateAccountPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
public class CreateAccountStepDef {
	
	CreateAccountPage createAccountpage = new CreateAccountPage();
	
	@Given ("^test case number (.+)$")
	public void testCaseNo(String tcnum) {
		createAccountpage.testCaseNumber(tcnum);
	}
	
	@When ("^user click on create google account$")
	public void UserClickOnCreateGoogleAccount() {
		createAccountpage.clickCreateAccountButton();
		createAccountpage.verifyHeader();
	}
	
	@Then ("^user enter (.+) (.+) (.+) (.+)$")
	public void UserEnterNamePwdUserDetails(String fName, String lName, String uName, String pwd) {
		createAccountpage.enterFirstName(fName);
		createAccountpage.enterLastName(lName);
		createAccountpage.enterUserName(uName);
		createAccountpage.enterPassword(pwd);
		createAccountpage.enterConfirmPassword(pwd);
		createAccountpage.clickNextButton();
	}

}
