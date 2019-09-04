package com.OBSERVAMonitor;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OBSERVAInputPage extends BaseTest {
	
	
	@Test (groups = "Regression Test")

	
	public void InputPage() throws InterruptedException, IOException
	{
		
		InputPage IP = PageFactory.initElements(driver, InputPage.class);
	

		IP.INPUT();
		
	
		
				
		IP.PageTitle();
		
		
		IP.BulletList();
		/*Actions act = new Actions(driver);
		act.click();
		Thread.sleep(1000);*/
		//Thread.sleep(1000);
		
		IP.SwitchingFrame().click();
		Thread.sleep(1000);
		
	
					
		
		IP.btnToAddInput();
		Thread.sleep(1000);
		
		
		IP.SelectInputsFromDropDown();
		
		//*[@id="select_sourceType"]
		
		IP.SelectInputs();

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
		
		IP.EDIInput();
		
	    //IP.InputExistsError(); 
		
		IP.txtError();
		
		//String expectedText = "Error!ETI Source E:224.1.0.46:10046 already exists";
		//String txtError ();
		//Assert.assertEquals(expectedText, txtError);
		
				
		IP.Continuitypage();
		
		IP.SilencePage();
		
		
		
	
	    
		
	

}}
