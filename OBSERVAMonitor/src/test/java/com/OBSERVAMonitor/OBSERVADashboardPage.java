package com.OBSERVAMonitor;

import java.io.IOException;
import java.util.List;

import javax.sound.sampled.Line;

import org.apache.poi.Version;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OBSERVADashboardPage extends BaseTest{
	
   @Test (groups = "Smoke Test", priority =1)
			
	public void dashboardPage() throws InterruptedException{
		
	DashboardPage DHP = PageFactory.initElements(driver, DashboardPage.class);
		
 	DHP.BulletList();
	/*Actions act = new Actions(driver);
	act.click();*/
	Thread.sleep(1000);
	
	String expected_Title = "OBSERVA Monitor | Dashboard";
	String actual_Title = driver.getTitle();
    Assert.assertEquals(actual_Title, expected_Title);
    logger.info(actual_Title);
	}
	
	@Test (groups = "Regression Test, Smoke Test", priority =2)
    
    public void elinksLeftPanel() throws InterruptedException{
		
    DashboardPage DHP = PageFactory.initElements(driver, DashboardPage.class);
    
    Thread.sleep(1000);	
	DHP.lnkINPUT();
	String inputexpectedURL = "https://10.0.0.74/input";
	String inputactualURL = driver.getCurrentUrl();
	Assert.assertEquals(inputactualURL, inputexpectedURL);
	logger.info(inputactualURL);
	Thread.sleep(1000);	
	DHP.lnkCONTINUITY();
	Thread.sleep(1000);
	String continuityexpectedURL = "https://10.0.0.74/continuity";
	String continuityactualURL = driver.getCurrentUrl();
	Assert.assertEquals(continuityactualURL, continuityexpectedURL);
	logger.info(continuityactualURL);
	Thread.sleep(1000);
	DHP.lnkCONTENT();
	String contentexpectedURL = "https://10.0.0.74/content";
	String contentactualURL = driver.getCurrentUrl();
	Assert.assertEquals(contentexpectedURL, contentactualURL);
	logger.info(contentactualURL);
	Thread.sleep(1000);
	DHP.lnkSILENCE();
	String silenceexpectedURL = "https://10.0.0.74/silence";
	String silenceactualURL = driver.getCurrentUrl();
	Assert.assertEquals(silenceexpectedURL, silenceactualURL);
	logger.info(silenceactualURL);
	Thread.sleep(1000);
	DHP.lnkEDIOUTPUT();
	String EDIoutputeexpectedURL = "https://10.0.0.74/output";
	String EDIoutputactualURL = driver.getCurrentUrl();
	Assert.assertEquals(EDIoutputeexpectedURL, EDIoutputactualURL);
	logger.info(EDIoutputactualURL);
	Thread.sleep(1000);
	DHP.lnkRECONFIGURATION();
	String ReconfigoutputeexpectedURL = "https://10.0.0.74/reconfig";
	String ReconfigactualURL = driver.getCurrentUrl();
	Assert.assertEquals(ReconfigoutputeexpectedURL, ReconfigactualURL);
	logger.info(ReconfigactualURL);
	Thread.sleep(1000);
	
	}
	
	@Test (groups = "Smoke Test, Integration", priority =3)
	
	public void footerApplication() throws InterruptedException{
		
	DashboardPage DHP = PageFactory.initElements(driver, DashboardPage.class);
	Thread.sleep(1000);
	DHP.VERSION();
	//String VERSION = "1.4.1.40";
	//Assert.assertEquals(VERSION, "1.4.1.40");
	Thread.sleep(1000);
	
	DHP.Copyright();
	Thread.sleep(1000);
	DHP.ABOUTUS();
	String AboutusexpectedURL = "https://www.factumradioscape.com/";
	String AboutusactualURL = driver.getCurrentUrl();
	Assert.assertEquals(AboutusactualURL, AboutusexpectedURL);
	Thread.sleep(1000);
	driver.navigate().back();
	
	
	}}
	
	
		
	

	
	
			
			
	
	

	
	
	
	
	
	
	


	