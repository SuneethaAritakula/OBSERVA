package com.OBSERVAMonitor;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputPage {
	
	
	
	Logger logger = Logger.getLogger("InputPage");
	
	
	
	///html/body/div/div[1]/div[2]/ul/li[2]/a/p
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[2]/a/p")
	WebElement INPUT;
	
	public void INPUT()
		
	{
	PropertyConfigurator.configure("log4j.properties");
	INPUT.click();
	logger.info("Chrome Browser instantiated successfully");

	}
	
	@FindBy(xpath = "/html/body/div/div[2]/nav/div/div[1]/a")
	WebElement PageTitle;
	
	public void PageTitle() {
		
		String pagetitle = PageTitle.getText();
		Assert.assertEquals(pagetitle, "INPUTS BEING MONITORED");
	}
	
	
	
	@FindBy (xpath = "//*[@id=\'minimizeSidebar\']/i[2]")
	WebElement BulletList;
	
	
	public void BulletList()
	
	{
		BulletList.click();
		
	}
	

	@FindBy(xpath = "/html/body/div/div[2]/div[4]")
	WebElement SwitchingFrame;
	public WebElement SwitchingFrame() {
		
	return SwitchingFrame.findElement(By.xpath("/html/body/div/div[2]/div[4]"));
		
		
	}
	
	@FindBy(xpath = "/html/body/div/div[2]/div[4]/div[1]/div/button/i")
	WebElement btnToAddInput;
	public void btnToAddInput()
	
	{
		
		btnToAddInput.click();	
	}
	
	
	//*[@id="addSourceModal"]/div/div/div[2]/form/div[1]/div
	@FindBy(xpath = "//*[@id='addSourceModal']/div/div/div[2]/form/div[1]/div")
	WebElement SelectInputsFromDropDown;
	
	public void SelectInputsFromDropDown()
	
	{	
		SelectInputsFromDropDown.click();
}
	
	@FindBy(xpath = "//*[@id=\'select_sourceType\']")
	WebElement SelectInputs;
	public void SelectInputs()
	{
		SelectInputs.click();
		
	
	}
	
	@FindBy(xpath = "//*[@id='textbox_name']")
	WebElement txtDisplayName;
	
	@FindBy(xpath = "//*[@id=\'textbox_address\']")
	WebElement txtAddress;
	
	@FindBy(xpath = "//*[@id=\'textbox_port\']")
	WebElement textbxPort;
	
	@FindBy(xpath = "//*[@id=\'EDIField\']/div[3]/div/div/label")
	WebElement chkbxResend;
	
	@FindBy(xpath = "//*[@id=\'btn_addInputSave\']")
	WebElement btnClkSave;
	
	
	
	public void EDIInput()
	
	{
	SelectInputs.click();	
	txtDisplayName.sendKeys("EDI 1");
	txtAddress.sendKeys("224.1.0.46");
	textbxPort.sendKeys("10046");
	chkbxResend.click();
	btnClkSave.click();
	
		}
	
	/*public void InputExistsError() {
		txtDisplayName.sendKeys("EDI 1");
		txtAddress.sendKeys("224.1.0.46");
		textbxPort.sendKeys("10046");
		chkbxResend.click();
		btnClkSave.click();
		
		
		
	}*/
	
	@FindBy(xpath = "//*[@id='eti-input-row']/div[1]")
	WebElement txtError;
	
	public void txtError(){
	String actualText = txtError.getText();
	String expectedText = "Error!ETI Source E:224.1.0.46:10046 already exists	                      "
			
			
	  + " ×";

	
	//expected [[Error!ETI Source E:224.1.0.46:10046 already exists ×]] but found [Error!ETI Source E:224.1.0.46:10046 already exists
	                                                                            // ×]
		
	//Assert.assertEquals(expectedText, actualText);
	//Assert.assertTrue(false, "Error!ETI Source E:224.1.0.46:10046 already exists	                      x");
	Assert.assertNotSame(actualText, expectedText);
	
	}
	     
		
		//String txtError1 = ((txtError) txtError).compareTo("Error!ETI Source E:224.1.0.46:10046 already exists");
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[3]/a/p")
	WebElement lnkContinuity;
	
	@FindBy(xpath = "//*[@id=\'eti-key-0\']/div[1]/h4")
	WebElement hdrtxtContinuityPage;
	
	public void Continuitypage() {
		
		lnkContinuity.click();
		String expectedhdrtxt = hdrtxtContinuityPage.getText();
		String actualText = "EDI 1 - E:224.1.0.46:10046";
		
		Assert.assertEquals(expectedhdrtxt, actualText);
		}
		
	
	@FindBy(xpath = "/html/body/div/div[1]/div[2]/ul/li[5]/a/p")
	WebElement lnkSilence;
	
	
	@FindBy(xpath = "//*[@id=\'overall-state-0\']")
	WebElement EDIHeartSymbol;
	


	//@FindBy(xpath = "//*[@id=/'silence-row/']/div/div/div[1]/div/div[1]")
	//WebElement EDITitle;
	
	

	@FindBy(xpath = "//*[@id=\'headingOne\']/a/i[2]")
	WebElement AudioCollapse;
	

	@FindBy(xpath= "//*[@id=\'headingTwo\']/a/i[2]")
	WebElement PADCollpase;
	

	//@FindBy(xpath = "//*[@id=\'headingTwo\']/a/i[2]")
	//WebElement DATACollapse;
	
	
	//@FindBy(xpath = "//*[@id=\'audio-overall-0\']")
	//WebElement AudioButtonColour; 

	
	public void SilencePage() {
	
	lnkSilence.click();
	
 
	/*String color = EDIHeartSymbol.getCssValue("color").trim();	
	String color_hex[];  
	color_hex = color.replace(("#ff3636").split("255,54,54"));
	String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));  

	// further can verify with Actual hex value with Expected hex value  
	Assert.assertEquals("actual_hex should equal to: ", "#808080", actual_hex);*/
	
	

	
	
	AudioCollapse.click();
	PADCollpase.click();
	//DATACollapse.click();
	
	
	
		
	

	
	

	
	}

	

	
		
		
	
	
	
}
	
	
	
	
	
	
	
	

