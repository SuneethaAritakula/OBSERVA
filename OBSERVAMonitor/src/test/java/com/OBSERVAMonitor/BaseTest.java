package com.OBSERVAMonitor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class BaseTest{
	

	
Logger logger = Logger.getLogger("BaseTest");
public static WebDriver driver;
public String url = "https://10.0.0.89/";


	

	@BeforeMethod
	
	public void setup() {
		
		PropertyConfigurator.configure("log4j.properties");
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\factum\\Desktop\\OBSERVAMonitor\\OBSERVAMonitor\\driver files\\chromedriver.exe");
	    
		driver= new ChromeDriver();
	    logger.info("Chrome Browser instantiated successfully");
	    

	    
	    
		driver.get(url);
		logger.info("OBSERVA Monitor launched successfully");

		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		logger.info("Implicit wait applied on the driver for 10 seconds");
	}}
		
	

		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		/*By loadingImage = By.id("loading image ID");
		WebDriverWait wait = new WebDriverWait(driver, 100);

	wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));*/
		
		
		
		

		
	
		
		
		
	/*@AfterSuite
		public void tearDown() {
			
		driver.quit();
		}}

		
//Should I create a separate java class called utility to save and recall this method later?
 * 
 * 
public static void captureScreenshot(WebDriver driver,String screenshotName)
{
 
try 
{
TakesScreenshot ts=(TakesScreenshot)driver;
 
File source=ts.getScreenshotAs(OutputType.FILE);
 
FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
//should I create a new folder for the captured screen shots to be saved?
 
System.out.println("Screenshot taken");
} 
catch (Exception e)
{
 
System.out.println("Exception while taking screenshot "+e.getMessage());
} }

}

//	call the the above method in this format - Utility.captureScreenshot(driver,"name of screenshot");*/



