package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject 
{
public WebDriver driver;
	
	private By email1=By.xpath("//input[@name='email']");
	
	private By password=By.xpath("//input[@name='password']");
	
	private By submit = By.xpath("//input[@type='submit']");


public LoginPageObject(WebDriver driver2) 
{
	this.driver=driver2;
}

public WebElement enteremail1() 
{
	return driver.findElement(email1);
	
}
public WebElement enterpassword() 
{
	return driver.findElement(password);
	
}
public WebElement clickOnLogin() 
{
	return driver.findElement(submit);
	

}

}

