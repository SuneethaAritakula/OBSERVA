package com.OBSERVAMonitor;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OBSERVADashboardTest extends BaseTest{
	@Test (groups = "Smoke Test")
	
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
	
@Test (groups = "Smoke Test")
    
    public void elinksLeftPanel() throws InterruptedException{
		
    DashboardPage DHP = PageFactory.initElements(driver, DashboardPage.class);
    
    Thread.sleep(1000);	
	DHP.lnkINPUT();
	String inputexpectedURL = "https://10.0.0.74/input";
	String inputactualURL = driver.getCurrentUrl();
	Assert.assertEquals(inputactualURL, inputexpectedURL);
	logger.info(inputactualURL);
	DHP.lnkCONTINUITY();
	Thread.sleep(1000);
	String continuityexpectedURL = "https://10.0.0.74/continuity";
	String continuityactualURL = driver.getCurrentUrl();
	Assert.assertEquals(continuityactualURL, continuityexpectedURL);
	logger.info(continuityactualURL);
	DHP.lnkCONTENT();
	String contentexpectedURL = "https://10.0.0.74/content";
	String contentactualURL = driver.getCurrentUrl();
	Assert.assertEquals(contentexpectedURL, contentactualURL);
	logger.info(contentactualURL);
	DHP.lnkSILENCE();
	String silenceexpectedURL = "https://10.0.0.74/silence";
	String silenceactualURL = driver.getCurrentUrl();
	Assert.assertEquals(silenceexpectedURL, silenceactualURL);
	logger.info(silenceactualURL);
	DHP.lnkEDIOUTPUT();
	String EDIoutputeexpectedURL = "https://10.0.0.74/output";
	String EDIoutputactualURL = driver.getCurrentUrl();
	Assert.assertEquals(EDIoutputeexpectedURL, EDIoutputactualURL);
	logger.info(EDIoutputactualURL);
	DHP.lnkRECONFIGURATION();
	String ReconfigoutputeexpectedURL = "https://10.0.0.74/reconfig";
	String ReconfigactualURL = driver.getCurrentUrl();
	Assert.assertEquals(ReconfigoutputeexpectedURL, ReconfigactualURL);
	logger.info(ReconfigactualURL);
	
	}
}
