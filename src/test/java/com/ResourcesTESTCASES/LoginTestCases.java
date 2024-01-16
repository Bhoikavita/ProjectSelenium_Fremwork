package com.ResourcesTESTCASES;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Resources.Baseclass;
import com.Resources.Constants;

import PageObjectModel.HomePageObject;
import PageObjectModel.LoginPageObject;


public class LoginTestCases extends Baseclass 
{
	@Test
		public void verifyRegisteration() throws IOException, InterruptedException 
		{
			//intializeDreiver();
			
			//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");//because it comming from base class
			
			
			Thread.sleep(3000);
			

			HomePageObject hpo = new HomePageObject(driver);
			hpo.clickOnMyAccount().click();
			hpo.clickOnLogin().click();

			
			LoginPageObject  lop=new LoginPageObject(driver);
			
			lop.enteremail1().sendKeys(RegisterAccountTestCases.randomEmail);
			//lop.enteremail1().sendKeys("test1@gmail.com");
			lop.enterpassword().sendKeys(Constants.password);
			lop.clickOnLogin().click();
			
			
			
}
}