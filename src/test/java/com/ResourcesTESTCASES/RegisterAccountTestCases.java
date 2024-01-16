package com.ResourcesTESTCASES;

import com.Resources.Baseclass;
import com.Resources.Constants;
import com.Resources.commanMethod;


import PageObjectModel.HomePageObject;
import PageObjectModel.RegestrationPageObject;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterAccountTestCases extends Baseclass 
{
	public static String randomEmail ="";
	@Test
	public void verifyRegisterationWithBlankData() throws IOException, InterruptedException 
	{
		// include explicitwait
		//Thread.sleep(3000);
		//randomEmail=generateRandomEmail();
		
		
		HomePageObject hpo = new HomePageObject(driver);
		
		commanMethod.putExplicitWait(driver, 10, hpo.clickOnMyAccount());
		//.putExplicitWait(driver, 10, hpo.clickOnMyAccount());
		
		hpo.clickOnMyAccount().click();
		hpo.clickOnregister().click();
		
		RegestrationPageObject rop = new RegestrationPageObject (driver);
		
		rop.enterfirstName().clear();
		rop.enterfirstName().sendKeys("");
		
		rop.enterlasttName().clear();
		rop.enterlasttName().sendKeys("");
		
		rop.enteremail1().clear();
		rop.enteremail1().sendKeys("");
		
		rop.EnterTelephone().sendKeys("");
		
		rop.EnterPassword().sendKeys("");
		
		rop.EnterPasswordConfirm().sendKeys("");
		
		rop.ClickOnSubscribe().click();
		
		rop.AcceptPrivacyPolicy().click();
		
		rop.ClickOnContinueButton().click();

		
		/*commanmethod insert
		SoftAssert sa = new SoftAssert();
		
		String firstNameErrorMsg = Constants.firstNameErrorMsg;
		
		String lastNameErrorMsg = Constants.lastNameErrorMsg;
		
		sa.assertEquals(rop.CaptureFirstNameErrorMsg().getText(), firstNameErrorMsg);
		
		sa.assertEquals(rop.CaptureLastNameErrorMsg().getText(), lastNameErrorMsg);
	
		sa.assertAll();*/
		
		commanMethod.handleAssertion(rop.CaptureFirstNameErrorMsg().getText(), Constants.firstNameErrorMsg);
		commanMethod.handleAssertion(rop.CaptureLastNameErrorMsg().getText(),Constants.lastNameErrorMsg);
		
	}
	
	/*insert bases class
	public String generateRandomEmail()
	{
		return System.currentTimeMillis()+"@gmail.com";
		
	}*/
	
	
	@Test(dependsOnMethods = "verifyRegisterationWithBlankData")
	public void verifyRegisterationWithData() throws IOException, InterruptedException {

		//Thread.sleep(3000);
		
		randomEmail=generateRandomEmail();
		RegestrationPageObject  rop = new RegestrationPageObject (driver);
		
		commanMethod.putExplicitWait(driver, 10, rop.enterfirstName());
		
		
		rop.enterfirstName().clear();
		//rop.enterfirstName().sendKeys("test");
		rop.enterfirstName().sendKeys(Constants.firstName);
		
		//rop.enterlasttName().sendKeys("cases");
		rop.enterlasttName().sendKeys(Constants.lastName);
		
		//rop.enteremail1().sendKeys("kavi5@gmail.com");
		//rop.enteremail1().sendKeys(generateRandomEmail());
		rop.enteremail1().sendKeys(randomEmail);
		
		//rop.EnterTelephone().sendKeys("123456789");
		rop.EnterTelephone().sendKeys(Constants.telephone);
		
		//rop.EnterPassword().sendKeys("kavi");
		rop.EnterPassword().sendKeys(Constants.password);
		
		//rop.EnterPasswordConfirm().sendKeys("kavi");
		rop.EnterPasswordConfirm().sendKeys(Constants.passwordconfirm);
		
		rop.ClickOnSubscribe().click();
		
		//rop1.AcceptPrivacyPolicy().click();
		rop.ClickOnContinueButton().click();
		
		
		
	/*commanmethod to insert	
	 SoftAssert sa = new SoftAssert();
		//String successURL="https://naveenautomationlabs.com/opencart/index.php?route=account/success";
		String successURL=Constants.successURL;
		
		sa.assertEquals(driver.getCurrentUrl(),successURL);
		sa.assertAll();*/
		
		commanMethod.handleAssertion(driver.getCurrentUrl(),Constants.successURL);	
}


	}
	
