package com.OBSERVAMonitor;

import java.io.IOException;
import java.util.List;

import javax.swing.Action;

import org.apache.poi.Version;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DashboardPage extends BaseTest{
	

			
	@FindBy (xpath = "//*[@id='minimizeSidebar']")
	WebElement BulletList;
	
	public void BulletList()
	
	{
		BulletList.click();
		//Actions act = new Actions(driver);
		//act.click();
	
	}
	

	@FindBy(xpath = "//*[text()='Dashboard']")
    WebElement lnkDashBoardPage;
	
	@FindBy(xpath = "//a[@class='navbar-brand']['Dashboard']")
	WebElement hdrDashboardPage;
	
	public void lnkDashboardPage()
	{
		 lnkDashBoardPage.click();
		 String actualhdrDashboardPage = hdrDashboardPage.getText();
		 String expectedhdrDashboardPage = "DASHBOARD";
		 Assert.assertEquals(actualhdrDashboardPage, expectedhdrDashboardPage);
		 logger.info(actualhdrDashboardPage);
	}
	
	
	@FindBy(xpath = "//*[text()='Input']")  
	WebElement lnkINPUT;
	
	@FindBy(xpath= "//a[@class='navbar-brand']['Inputs being monitored']")
	WebElement hdrInputPage;
	
	
	public void lnkINPUT()
	
	{
	 lnkINPUT.click();
	 String actualhdrInputPage = hdrInputPage.getText();
	 String expectedhdrInputPage = "INPUTS BEING MONITORED";
	 Assert.assertEquals(actualhdrInputPage, expectedhdrInputPage);
	 logger.info(actualhdrInputPage);

	}
	
	@FindBy(xpath = "//*[text()='Continuity']")
	WebElement lnkCONTINUITY;
	
	
	@FindBy(xpath= "//a[@class='navbar-brand']['ETI Source Continuity Status']")
	WebElement hdrContinuityPage;
    
			
	public void lnkCONTINUITY ()
	
	{
	lnkCONTINUITY.click();	
	String actualhdrContinuityPage = hdrContinuityPage.getText();
	String expectedhdrContinuityPage = "ETI SOURCE CONTINUITY STATUS";
	Assert.assertEquals(actualhdrContinuityPage, expectedhdrContinuityPage);
	logger.info(actualhdrContinuityPage);
	    
	}
	
	@FindBy(xpath = "//*[text()='Content']")
	WebElement lnkCONTENT;
	
	@FindBy(xpath = "//a[@class='navbar-brand']['Ensemble Content Monitoring']")
	WebElement hdrContentPage;
	
	
	public void lnkCONTENT()
	
	{
		lnkCONTENT.click();
		String actualhdrContentPage = hdrInputPage.getText();
		String expectedhdrContentPage = "ENSEMBLE CONTENT MONITORING";
		Assert.assertEquals(actualhdrContentPage, expectedhdrContentPage);
		logger.info(actualhdrContentPage);
	}
	
   @FindBy(xpath= "//*[text()='Silence']")
   WebElement lnkSILENCE;
   
   @FindBy(xpath = "//a[@class='navbar-brand']['Audio And PAD Silence Monitoring']")
   WebElement hdrSilencePage;
   

   public void lnkSILENCE()
   
   {
	   lnkSILENCE.click();
	   String actualhdrSilencePage = hdrSilencePage.getText();
	   String expectedhdrSilencePage = "AUDIO AND PAD SILENCE MONITORING";
	   Assert.assertEquals(actualhdrSilencePage,expectedhdrSilencePage);
	   logger.info(actualhdrSilencePage);
   }
   
   @FindBy (xpath = "//*[text()='EDI Output']")
   WebElement lnkEDIOUTPUT;
   
   @FindBy(xpath = "//a[@class='navbar-brand']['Outputs being monitored']")
   WebElement hdrEDIOutputPage;
   

   public void lnkEDIOUTPUT()
   
   {

	   lnkEDIOUTPUT.click();
	   String actualhdrOutputPage = hdrEDIOutputPage.getText();
	   String expectedhdrOutputPage = "OUTPUTS BEING MONITORED";
	   Assert.assertEquals(actualhdrOutputPage,expectedhdrOutputPage);
	   logger.info(actualhdrOutputPage);
   }
   
   @FindBy(xpath = "//*[text()='Reconfiguration']")
   WebElement lnkRECONFIGURATION;
   
   @FindBy(xpath = "//a[contains(text(), 'Reconfiguration History')]")
   WebElement hdrReconfigPage;
   
   public void lnkRECONFIGURATION()
   
   {
	   lnkRECONFIGURATION.click();
	   String actualhdrReconfigPage = hdrReconfigPage.getText();
	   String expectedhdrReconfigPage = "RECONFIGURATION HISTORY";
	   Assert.assertEquals(actualhdrReconfigPage,expectedhdrReconfigPage);
	   logger.info(expectedhdrReconfigPage);
   }
   
  @FindBy(xpath = "//*[@id='Version']")
   WebElement VERSION;
  
  public void VERSION(){
	  
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
   	  executor.executeScript("arguments[0].scrollIntoView(true);", VERSION);
   	  executor.executeScript("arguments[0].click();", VERSION);
   
	 String versionnumber = VERSION.getText();
	 Assert.assertEquals(versionnumber, "VERSION 1.4.1.63");
	 logger.info(versionnumber);
			   
   }
  
  @FindBy (xpath = "//*[@id='copyright']")
	WebElement Copyright;
	
	public void Copyright() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
	   	  executor.executeScript("arguments[0].scrollIntoView(true);", Copyright);
	String copyrightversion = Copyright.getText();
	Assert.assertEquals(copyrightversion, "© 2019 Factum Radioscape.");
	logger.info(copyrightversion);
  
	}
  
           
	@FindBy(xpath="//*[contains(text(),'About Us')]")
	WebElement ABOUTUS;
    public void ABOUTUS() {
		
    	 JavascriptExecutor executor = (JavascriptExecutor)driver;
   	  executor.executeScript("arguments[0].scrollIntoView(true);", ABOUTUS);
   	  executor.executeScript("arguments[0].click();", ABOUTUS);
//	ABOUTUS.click();
    }

	

		
	}
	



	
	
	





		
		
	
		
	
		
	

	