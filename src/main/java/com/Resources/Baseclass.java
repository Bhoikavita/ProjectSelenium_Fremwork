package com.Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass 
{
	public WebDriver driver;
	public Properties prop;
	
	public void intializeDriver() throws IOException,InterruptedException 
	{
		//to read data from property fies
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Resources\\data.properties");
		
		
		//insert the grobles to acces the property
		 // to accessthe prperties files
		//Properties prop = new Properties();
		prop = new Properties();
		prop.load(fis);
		
		
		
		String broswerName= prop.getProperty("browser");
		if(broswerName.equalsIgnoreCase("chrome")) 
		{
			 driver=new ChromeDriver();
			 
		}
		else if(broswerName.equalsIgnoreCase("firefox")) 
		{
			 driver=new FirefoxDriver();
		}
		
		else if(broswerName.equalsIgnoreCase("Edge")) 
		{
			 driver=new EdgeDriver();
		}
	
}
	
	@BeforeClass
	public void launchBroswer() throws IOException,InterruptedException{

		intializeDriver();
	
	driver.get(prop.getProperty("url"));
	//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	
	
}
	 public String generateRandomEmail()
	{
		return System.currentTimeMillis()+"@gmail.com";
}
	
	
}