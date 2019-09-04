package com.OBSERVAMonitor;

import java.io.IOException;
import java.util.List;

import javax.swing.Action;

import org.apache.poi.Version;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DashboardPage extends BaseTest{
	


	
			
	@FindBy (xpath = "//*[@id=\"minimizeSidebar\"]/i[2]")
	WebElement BulletList;
	
	//@Test(priority=0, groups="Smoke Test")
	
	public void BulletList()
	
	{
		BulletList.click();
		}
	

		
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[2]/a/p")
	WebElement INPUT;
	
	//@Test(priority=1, groups="Smoke Test")
	public void INPUT()
	
	{
	 INPUT.click();

	}
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[3]/a/p")
	WebElement CONTINUITY;
	
	//@Test(priority=2,groups="Smoke Test")
	
	public void CONTINUITY ()
	
	{
	CONTINUITY.click();	
	    
	}
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[4]/a/p")
	WebElement CONTENT;
	
	//@Test(priority=3,groups="Smoke Test")
	public void CONTENT()
	
	{
		CONTENT.click();
	}
	
   @FindBy(xpath= "/html/body/div/div[1]/div[2]/ul/li[5]/a/p")
   WebElement SILENCE;
   
   //@Test(priority=4, groups="Smoke Test")
   public void SILENCE()
   
   {
	   SILENCE.click();
   }
   
   @FindBy (xpath = "/html/body/div/div[1]/div[2]/ul/li[6]/a/p")
   WebElement EDIOUTPUT;
   
  // @Test(priority=5,groups="Smoke Test")
   public void EDIOUTPUT()
   
   {

	   EDIOUTPUT.click();
   }
   
   @FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[7]/a/p")
   WebElement RECONFIGURATION;
   
   //@Test(priority=6, groups="Smoke Test")
   public void RECONFIGURATION()
   
   {
	   RECONFIGURATION.click();
   }
   
  @FindBy(xpath = "//*[@id=\'Version\']")
   WebElement VERSION;
  
 // @Test(priority=7,groups="Smoke Test")
  
  public void VERSION(){
   
	 String versionnumber = VERSION.getText();
	 Assert.assertEquals(versionnumber, "VERSION 1.4.1.40");
			   
   }
     
      
	@FindBy(xpath="/html/body/div/div[2]/footer/div/nav/ul/li/a")
	WebElement ABOUTUS;
    public void ABOUTUS() {
		
	
	ABOUTUS.click();
    }

	
	@FindBy (xpath = "//*[@id='copyright']")
	WebElement Copyright;
	
	public void Copyright() {
		//return Copyright.getText();
		
	String copyrightversion = Copyright.getText();
	Assert.assertEquals(copyrightversion, "© 2019 Factum Radioscape.");
		
	}}
	


	
/*@FindBy (xpath = "//*[@id=\"minimizeSidebar\"]/i[2]")
WebElement BulletList;

@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[2]/a/p")
WebElement INPUT;

@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[3]/a/p")
WebElement CONTINUITY;


@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[4]/a/p")
WebElement CONTENT;

@FindBy(xpath= "/html/body/div/div[1]/div[2]/ul/li[5]/a/p")
WebElement SILENCE;

@FindBy (xpath = "/html/body/div/div[1]/div[2]/ul/li[6]/a/p")
WebElement EDIOUTPUT;

@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[7]/a/p")
WebElement RECONFIGURATION;

@FindBy(xpath = "//*[@id=\'Version\']")
WebElement VERSION;

@FindBy(xpath="/html/body/div/div[2]/footer/div/nav/ul/li/a")
WebElement ABOUTUS;

@FindBy (xpath = "//*[@id='copyright']")
WebElement Copyright;

public void suneetha(WebElement,WebElement,WebElement,WebElement,WebElement,WebElement,WebElement,WebElement) {
	
	BulletList.click();
	INPUT.click();
	CONTINUITY.click();
	CONTENT.click();
	SILENCE.click();
	EDIOUTPUT.click();
	RECONFIGURATION.click();
	VERSION.click();
	ABOUTUS.click();
	Copyright.click();
	
}*/

	
	
	
	
			


   
	
	
	
	
	
	
		
	
	
	
	





		
		
	
		
	
		
	

	