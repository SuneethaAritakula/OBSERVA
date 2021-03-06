package com.OBSERVAMonitor.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*public class CommonMethods{
	
	//should I create a separate class rather than common methods? Should I also create a data folder for data to be read from and written to?
		
	
	public static void readandwritedata(WebDriver driver, String string) throws IOException {
		
	FileInputStream file = new FileInputStream("");
	XSSFWorkbook workBook = new XSSFWorkbook();
	XSSFSheet sheet = workBook.getSheet("");
	
			
	
	FileOutputStream file1 = new FileOutputStream("");
	workBook.write(file1);
	
	}}
	
	
 //will these go in utility folder??
	
	/*public class BasePage {

	    private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;

	    protected WebDriver driver;
	    private WebDriverWait wait;

	    public BasePage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	    }

	    protected void waitForElementToAppear(By locator) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    protected void waitForElementToDisappear(By locator) {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }

	    protected void waitForTextToDisappear(By locator, String text) {
	        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
        }}}
        
        
    */

/*public class Utils {
	public static WebDriver driver = null;
public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
	String sBrowserName;
	try{
	sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
	if(sBrowserName.equals("Mozilla")){
		driver = new FirefoxDriver();
		Log.info("New driver instantiated");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Log.info("Implicit wait applied on the driver for 10 seconds");
	    driver.get(Constant.URL);
	    Log.info("Web application launched successfully");
		}
	}catch (Exception e){
		Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
	}
	return driver;
}

public static String getTestCaseName(String sTestCase)throws Exception{
	String value = sTestCase;
	try{
		int posi = value.indexOf("@");
		value = value.substring(0, posi);
		posi = value.lastIndexOf(".");	
		value = value.substring(posi + 1);
		return value;
			}catch (Exception e){
		Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
		throw (e);
				}
		}

 public static void mouseHoverAction(WebElement mainElement, String subElement){
	
	 Actions action = new Actions(driver);
     action.moveToElement(mainElement).perform();
     if(subElement.equals("Accessories")){
    	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
    	 Log.info("Accessories link is found under Product Category");
     }
     if(subElement.equals("iMacs")){
    	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
    	 Log.info("iMacs link is found under Product Category");
     }
     if(subElement.equals("iPads")){
    	 action.moveToElement(driver.findElement(By.linkText("iPads")));
    	 Log.info("iPads link is found under Product Category");
     }
     if(subElement.equals("iPhones")){
    	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
    	 Log.info("iPhones link is found under Product Category");
     }
     action.click();
     action.perform();
     Log.info("Click action is performed on the selected Product Type");
 }
 public static void waitForElement(WebElement element){
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
     wait.until(ExpectedConditions.elementToBeClickable(element));
 	}
	
 public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));	
		} catch (Exception e){
			Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
			throw new Exception();
		}
	}
 
 
}*/

	
	
	
	

