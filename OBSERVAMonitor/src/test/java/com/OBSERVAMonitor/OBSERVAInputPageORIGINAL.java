package com.OBSERVAMonitor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OBSERVAInputPageORIGINAL extends BaseTest {
	
	
	
	@Test (groups = "Regression Test", priority= 2)
		
    public void btnToAddInput() throws InterruptedException{
		
    InputPage IP = PageFactory.initElements(driver, InputPage.class);
    Thread.sleep(1000);
    IP.btnToAddInput();
	
	
    }
	
//	@Test (groups = "Regression Test", priority=3)
	
    /*public void SelectInputsFromDropDown() throws InterruptedException{
		
    InputPage IP = PageFactory.initElements(driver, InputPage.class);
    Thread.sleep(1000);
	IP.SelectInputsFromDropDown();
	
	
    }*/
    
//	@Test (groups = "Regression Test", priority=8)
	
    public void SelectInputs() throws InterruptedException{
		
    InputPage IP = PageFactory.initElements(driver, InputPage.class);
    Thread.sleep(1000);
	IP.SelectInputs();
    }
    
		/*Select Input = new Select(driver.findElement(By.xpath("//*[@id=\'select_sourceType\']")));
		Input.selectByIndex(0);
		
		for (int i = 0; i<=5; i++)
			
		{
			
			CommonMethods.readandwritedata(driver, "");
			
			
		}
		//Input.selectByVisibleText("FEP");
		//Thread.sleep(500);
		
		FileInputStream file = new FileInputStream("");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("");*/
		
//	//@Test (groups = "Smoke Test",priority = 9)
//	 public void EDIInput() throws InterruptedException{
//		
//	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
//	 Thread.sleep(1000);
//	 IP.EDIInput();
//	}
	
	//@Test(priority = 4)
	
/*	public void EDI1() {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	
	IP.INPUT();
	IP.btnToAddInput();
	Map<String, String> testData = excelReader.getRowFromMap("EDI1");
	IP.EDIInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"));
	

}
//@Test(priority = 4)
	
	public void EDI2() {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	
	IP.INPUT();
	IP.btnToAddInput();
	Map<String, String> testData = excelReader.getRowFromMap("EDI2");
	IP.EDIInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"));
	

	
}
@Test(priority = 4)

public void EDI3() {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
IP.INPUT();

Map<String, String> testData = excelReader.getRowFromMap("EDI3");

IP.EDIInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"));



}
//@Test(priority = 4)

public void EDI4() {
InputPage IP = PageFactory.initElements(driver, InputPage.class);

Map<String, String> testData = excelReader.getRowFromMap("EDI4");
IP.INPUT();
IP.EDIInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"));

//driver.navigate().refresh();

}
	
@Test(priority = 5)

	public void RFInputWith12B() throws InterruptedException {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	
//	Map<String, String> testData = excelReader.getRowFromMap("RF Off-A");
	Map<String, String> testData = excelReader.getRowFromMap("RFInputWith12B");
	if(testData!=null)
	{
	IP.INPUT();
	//IP.PageTitle();
//	IP.SelectInputsFromDropDown();
	IP.btnToAddInput();
	IP.RFInput1(driver,testData.get("DisplayName"),testData.get("Frequency"),testData.get("SourceType"));
	}
	else {
		System.out.println("Please mark testcase as Yes in testData excelsheeet");
	}
	
}

@Test(priority = 5)

public void FEP1() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);

//Map<String, String> testData = excelReader.getRowFromMap("RF Off-A");
Map<String, String> testData = excelReader.getRowFromMap("RFInputWith12B");

IP.INPUT();
//IP.PageTitle();
//IP.SelectInputsFromDropDown();
IP.btnToAddInput();
IP.FEP1(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"));

}
*/



	
	@Test (groups = "Smoke Test",priority = 10)
	 public void txtError() throws InterruptedException{
		
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
	  
	 //IP.InputExistsError();
	 IP.txtError();
	 
	}
	
	//@Test(priority = 11)
	 
	 public void Continuitypage() throws InterruptedException{
		
			
		 InputPage IP = PageFactory.initElements(driver, InputPage.class);
		 Thread.sleep(1000);
			
		 IP.Continuitypage();
		 
		 }
	
//	@Test(priority = 12)
	 
	 public void ContentPage() throws InterruptedException{
		
			
		 InputPage IP = PageFactory.initElements(driver, InputPage.class);
		 Thread.sleep(1000);
		 IP.ContentPage();
		 
		 }
	
//	@Test(priority = 13)
		
	 public void SilencePage() throws InterruptedException{
		
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
		IP.SilencePage();
	 }
		
//	@Test(priority = 14)
	
	 public void ReconfigPage() throws InterruptedException{
		
			
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
		IP.ReconfigPage();
	}
		
//	@Test(priority = 14)
	public void btnEditInput() throws InterruptedException {
		
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	Thread.sleep(1000);
	IP.btnEditInput();
	
	}
	
//	@Test(priority = 15)
	public void lblRenameInput() throws InterruptedException {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	Thread.sleep(1000);
	IP.lblRenameInput();
	
	driver.navigate().back();
	driver.navigate().refresh();
	}}
	
	
		 
		

		
		
		
		
		
		
		


