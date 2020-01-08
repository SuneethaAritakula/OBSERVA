package com.OBSERVAMonitor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.OBSERVAMonitor.utility.ExcelReader;
import com.OBSERVAMonitor.utility.Utility;

public class BaseTest{
	
static Logger logger = Logger.getLogger("BaseTest");
static WebDriver driver=null;
static Utility utility= new Utility();
ExcelReader excelReader = null;



@BeforeMethod

public static void instantiateBrowser() throws Exception {
	
	PropertyConfigurator.configure("log4j.properties");
	
	if(utility.getValueForKeyString("browser").equalsIgnoreCase("firefox")) {
		
		//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\factum\\Desktop\\OBSERVAMonitor\\OBSERVAMonitor\\driver files\\chromedriver.exe");
		//System.setProperty is not required for firefox driver
		driver = new FirefoxDriver();
		logger.info("firefox browser launched successfully");
	}
	else if(utility.getValueForKeyString("browser").equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\factum\\Desktop\\OBSERVAMonitor\\OBSERVAMonitor\\driver files\\chromedriver.exe");
		driver = new ChromeDriver();
		logger.info("chrome browser launched successfully");
		
	}
		else if((utility.getValueForKeyString("browser").equalsIgnoreCase("IE")))
		{
			System.setProperty("webdriver.ie.driver",  "C:\\Users\\factum\\Desktop\\OBSERVAMonitor\\OBSERVAMonitor\\driver files\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logger.info("IE browser launched successfully");
			
		}
	loadurl();	
}

//@Test	
public static void loadurl() throws Exception {
	//String x =System.getPropertie("env");
	driver.get(utility.getValueForKeyString("url"));
	logger.info("OBSERVA Monitor launched successfully");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	logger.info("Implicit wait applied on the driver for 10 seconds");
	Utility.takeScreenshot(driver, "loadingurl");

}

//@Test
public static void waitForElement(WebElement element){
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(element));
	}


@BeforeMethod
public void initialize() throws InvalidFormatException{
	excelReader = new ExcelReader("/testData.xlsx");
	excelReader.prepareRowMap("Test Name");
//	excelReader.prepareRowMap("Silence Settings", "Test Name");
//	excelReader.prepareRowMap("RF Off-Air", "Test Name");
	
	
}


/*
 * public static void capturescreenshot() {
 * 
 * Utility.captureScreenshot(driver,"name of screenshot"); }
 * 
 * /*@BeforeSuite
 * 
 * public void setup() {
 * 
 * PropertyConfigurator.configure("log4j.properties");
 * 
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "C:\\Users\\factum\\Desktop\\OBSERVAMonitor\\OBSERVAMonitor\\driver files\\chromedriver.exe"
 * );
 * 
 * driver= new ChromeDriver();
 * logger.info("Chrome Browser instantiated successfully");
 * 
 * 
 * driver.get(url); logger.info("OBSERVA Monitor launched successfully");
 * 
 * 
 * driver.manage().window().maximize();
 * 
 * 
 * driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
 * logger.info("Implicit wait applied on the driver for 10 seconds"); }}
 * 
 * 
 * //driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
 * TimeUnit.SECONDS);
 * 
 * /*By loadingImage = By.id("loading image ID"); WebDriverWait wait = new
 * WebDriverWait(driver, 100);
 * 
 * wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));*/
 


// @AfterMethod
 
 public void tearDown() {
 
 driver.quit(); }}


/*Notes
Shortcut for Commenting a single line:

Ctrl + /

Shortcut for Commenting multiple lines:

Ctrl + Shift + /
*/

 
		

