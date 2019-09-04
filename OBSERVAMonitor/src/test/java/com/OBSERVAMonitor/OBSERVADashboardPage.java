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
	
	@Test (groups = "Smoke Test", priority = 0)
			
	public void DashboardPage() throws InterruptedException{
	
	DashboardPage DHP = PageFactory.initElements(driver, DashboardPage.class);
	
 
    
	DHP.BulletList();
	Actions act = new Actions(driver);
	act.click();
	Thread.sleep(1000);
	
	String expected_Title = "OBSERVA Monitor | Dashboard";
	System.out.println("The expected Title is: "+expected_Title);
	String actual_Title = driver.getTitle();
	System.out.println("The actual Title is: "+actual_Title);
    Assert.assertEquals(actual_Title, expected_Title);
    

	
	
	DHP.INPUT();
	
	String expectedURL = "https://10.0.0.89/input";
	String actualURL = driver.getCurrentUrl();
	Assert.assertEquals(actualURL, expectedURL);
	
	DHP.CONTINUITY();
	
	String continuityexpectedURL = "https://10.0.0.89/continuity";
	String continuityactualURL = driver.getCurrentUrl();
	Assert.assertEquals(continuityactualURL, continuityexpectedURL);
	
	
	DHP.CONTENT();
	String contentexpectedURL = "https://10.0.0.89/content";
	String contentactualURL = driver.getCurrentUrl();
	Assert.assertEquals(contentexpectedURL, contentactualURL);
	
	DHP.SILENCE();
	String silenceexpectedURL = "https://10.0.0.89/silence";
	String silenceactualURL = driver.getCurrentUrl();
	Assert.assertEquals(silenceexpectedURL, silenceactualURL);
	
	
	
	DHP.EDIOUTPUT();
	String EDIoutputeexpectedURL = "https://10.0.0.89/output";
	String EDIoutputactualURL = driver.getCurrentUrl();
	Assert.assertEquals(EDIoutputeexpectedURL, EDIoutputactualURL);
	
	

	DHP.RECONFIGURATION();
	String ReconfigoutputeexpectedURL = "https://10.0.0.89/reconfig";
	String ReconfigactualURL = driver.getCurrentUrl();
	Assert.assertEquals(ReconfigoutputeexpectedURL, ReconfigactualURL);
	
	}
	
	@Test (groups = "Regression Test", priority = 1)
	
	public void DashboardPageFooter() throws InterruptedException{
	
	DashboardPage DHPF = PageFactory.initElements(driver, DashboardPage.class);
	
	
	DHPF.VERSION();
	//String VERSION = "1.4.1.40";
	//Assert.assertEquals(VERSION, "1.4.1.40");
	
			
	
	DHPF.ABOUTUS();
	Thread.sleep(2000);

	String AboutusexpectedURL = "https://www.factumradioscape.com/";
	String AboutusactualURL = driver.getCurrentUrl();
	Assert.assertEquals(AboutusactualURL, AboutusexpectedURL);
	driver.navigate().back();
	
	DHPF.Copyright();
	
	}}
	
	
		
	

	
	
			
			
	
	

	
	
	
	
	
	
	


	