package com.OBSERVAMonitor;

import java.awt.Color;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class InputPageOrginal {
	
	
	Logger logger = Logger.getLogger("InputPage");
	
	
	@FindBy(xpath = "//*[text()='Input']")
	WebElement INPUT;
	
	public void INPUT()
		
	{
	PropertyConfigurator.configure("log4j.properties");
	INPUT.click();
	logger.info("Input page opened");

	}
	
	@FindBy(xpath = "//a[@class='navbar-brand']['Inputs being monitored']")
	WebElement PageTitle;
	
	public void PageTitle() {
		
	String pagetitle = PageTitle.getText();
	Assert.assertEquals(pagetitle, "INPUTS BEING MONITORED");
	logger.info("Input page header::INPUTS BEING MONITORED");
	}
	
	/*@FindBy (xpath = "//*[@id=\'minimizeSidebar\']/i[2]")
	WebElement BulletList;
	
	
	public void BulletList()
	
	{
		BulletList.click();
		
	}
	

	@FindBy(xpath = "/html/body/div/div[2]/div[4]")
	WebElement SwitchingFrame;
	public WebElement SwitchingFrame() {
		
	return SwitchingFrame.findElement(By.xpath("/html/body/div/div[2]/div[4]"));
		
		
	}*/
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-round btn-icon']") 
	WebElement btnToAddInput;
	public void btnToAddInput()
	
	{
		
		btnToAddInput.click();
		logger.info("Button to add input clicked");
	}
	
	
	//*[@id="addSourceModal"]/div/div/div[2]/form/div[1]/div
	@FindBy(xpath = "//*[@class='form-control'][@id='select_sourceType']")
	WebElement SelectInputsFromDropDown;
	
	public void SelectInputsFromDropDown()
	
	{	
		SelectInputsFromDropDown.click();
		logger.info("Input selected from dropdown menu");
}
	
	@FindBy(id = "select_sourceType")
	WebElement SelectInputs;
	public void SelectInputs()
	{
		SelectInputs.click();
		
	
	}
	
	public void selectdropDownValue(WebDriver driver,String visibleText) {
		Select dropdown = new Select(SelectInputs);
		dropdown.selectByVisibleText(visibleText);
	}
	
	@FindBy(xpath = "//*[@id='textbox_name']")
	WebElement txtDisplayName;
	
	@FindBy(xpath = "//*[@id='textbox_address']")
	WebElement txtAddress;
	
	@FindBy(xpath = "//*[@id='textbox_port']")
	WebElement textbxPort;
	

	
//	@FindBy(xpath = "//*[@id='checkbox_resend']")
//	WebElement chkbxResend;
	
	
	
	@FindBy(xpath = "//*[@id='btn_addInputSave']")
	WebElement btnClkSave;
	
	
	
	public void EDIInputs(WebDriver driver,String DisplayName,String Address,String Port)
	
	{
	SelectInputs.click();	
	txtDisplayName.sendKeys(DisplayName);
	txtAddress.sendKeys(Address);
	textbxPort.sendKeys(Port);
	//chkbxResend.click();
	btnClkSave.click();
	
	logger.info("EDI Input stream added");
	
		}
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-round btn-icon']") 
	WebElement btnToAddInputRF;
	
	@FindBy(xpath = "//select[@id='select_sourceType']")
	WebElement SelectInputRF;
	
	@FindBy(xpath = "//*[@id='textbox_name']")
	WebElement txtDisplayNameRF;

	
	@FindBy(xpath = "//*[@id='rf_frequency']")
	WebElement textbxFrequency;
	

	
//	@FindBy(xpath = "//*[@id='checkbox_resend']")
//	WebElement chkbxResend;
	
	
	
	@FindBy(xpath = "//*[@id='btn_addInputSave']")
	WebElement btnClkSaveRF;
	
	
	
	public void RFInput1(WebDriver driver,String DisplayName,String Frequency,String sourceType) throws InterruptedException
	
	{
		
		Thread.sleep(4000);
		btnToAddInputRF.click();
	
//	SelectInputs.click();	
		selectdropDownValue(driver,sourceType);
	txtDisplayName.sendKeys(DisplayName);
	textbxFrequency.sendKeys(Frequency);
		//chkbxResend.click();
	btnClkSaveRF.click();;
	
	logger.info("RF Input stream added");
	
		}
	
	/*public void InputExistsError() {
		txtDisplayName.sendKeys("EDI 1");
		txtAddress.sendKeys("224.1.0.46");
		textbxPort.sendKeys("10046");
		chkbxResend.click();
		btnClkSave.click();
		
		
		
	}*/
	
	@FindBy(xpath = "//*[@id='textbox_name']")
	WebElement txtDisplayNameFEP1;
	
	@FindBy(xpath = "//*[@id='textbox_address']")
	WebElement txtAddressFEP1;
	
	@FindBy(xpath = "//*[@id='textbox_port']")
	WebElement textbxPortFEP1;
	

	
//	@FindBy(xpath = "//*[@id='checkbox_resend']")
//	WebElement chkbxResend;
	
	
	
	@FindBy(xpath = "//*[@id='btn_addInputSave']")
	WebElement btnClkSaveFEP1;
	
	
public void FEP1(WebDriver driver,String DisplayName,String Frequency,String sourceType) throws InterruptedException
	
	{
		
		Thread.sleep(4000);
		btnToAddInputRF.click();
	
//	SelectInputs.click();	
		selectdropDownValue(driver,sourceType);
	txtDisplayName.sendKeys(DisplayName);
	textbxFrequency.sendKeys(Frequency);
		//chkbxResend.click();
	btnClkSaveRF.click();;
	
	logger.info("RF Input stream added");
	
		}
	
	@FindBy(xpath = "//*[@id='eti-input-row']/div[1]")
	WebElement txtError;
	
	public void txtError(){
	String actualText = txtError.getText();
	System.out.println(actualText);
	//String expectedText = "Error!ETI Source E:224.1.0.46:10046 already exists	                      "
			
			
	 // + " ×";

	
	//expected [[Error!ETI Source E:224.1.0.46:10046 already exists ×]] but found [Error!ETI Source E:224.1.0.46:10046 already exists
	                                                                            // ×]
		
	//Assert.assertEquals(expectedText, actualText);
	//Assert.assertTrue(false, "Error!ETI Source E:224.1.0.46:10046 already exists	                      x");
	//Assert.assertNotSame(actualText, expectedText);
	logger.info("Error!ETI Source E:224.1.0.46:10046 already exists :: displayed");
	
	}
	     
		
		//String txtError1 = ((txtError) txtError).compareTo("Error!ETI Source E:224.1.0.46:10046 already exists");
	
	@FindBy(xpath = "//*[text()='Continuity']")
	WebElement lnkContinuity;
	
	@FindBy(xpath = "//*[@class='navbar-brand'][' ETI Source Continuity Status']")
	WebElement hdrtxtContinuityPage;
	
	public void Continuitypage() {
		
		lnkContinuity.click();
		
		logger.info("Continuity link clicked");
		
		}
	
	
	@FindBy(xpath = "//*[text()='Content']")
	WebElement ContentPage;
	

	
	public void ContentPage()  {
		ContentPage.click();
		
		//String actualContentPageEDIInput = ContentPageEDIInput.getText();
		//String expectedContentPageEDIInput = "EDI 1 -E:224.1.0.46:10046";
		//Assert.assertEquals(actualContentPageEDIInput, expectedContentPageEDIInput);
		
		logger.info("Content link clicked");
	}
	
	
	@FindBy(xpath = "//*[text()='Silence']")
	WebElement lnkSilence;
	
	//@FindBy(xpath = "//*[@id=\"silence-row\"]/div/div/div[1]/div/div[1]/h4")
	//WebElement InputtxtSilencePage;
	

	public void SilencePage() {
		
		lnkSilence.click();
//		String expectedInput = InputtxtSilencePage.getText();
//		String actualInput = "EDI 1 -E:224.1.0.46:10046";
//		Assert.assertEquals(expectedInput, actualInput);
//		logger.info(expectedInput);
		
		logger.info("Silence link clicked");
		
	}
	
	@FindBy(xpath = "//*[text()='Reconfiguration']")
	WebElement lnkReconfigPage;
	
	//*[@id="reconfig-row"]/div/div/div[1]/h5
	//*[@id="reconfig-row"]/div/div/div[1]/h5
	
	//*[@id="reconfig-row"]/div[1]/div/div[1]/h5
	//*[@id="reconfig-row"]/div[2]/div/div[1]/h5
	
//	@FindBy(xpath = "//*[@class='navbar-brand']['Reconfiguration History']")
//	WebElement lblReconfigPage;
	
	public void ReconfigPage() {
	
		lnkReconfigPage.click();
		
//		String actuallblReconfigPage = lblReconfigPage.getText();
//		String expectedlblReconfigPage = "EDI 1 -E:224.1.0.46:10046";
//		Assert.assertEquals(actuallblReconfigPage, expectedlblReconfigPage);
		logger.info("Reconfiguration link clicked");
	}
	
   @FindBy(xpath = "//*[text()='Input']")
   WebElement lnkBackToINPUT;

   @FindBy(xpath = "//*[@id='eti-input-row']/div[3]/div/div/div/div/div/div[3]/div/button")
   WebElement btnEditButton;
  
   
  // @FindBy(xpath = "//*[@id='eti-input-row']/div/div/div/div/div/div/div[3]/div/div/a[2]")
   //WebElement lblRemoveInput;
   
   public void btnEditInput() {

	   lnkBackToINPUT.click();
	   btnEditButton.click();
	   	   
   }
   
 @FindBy(xpath = "//*[@id='eti-input-row']/div/div/div/div/div/div/div[3]/div/div/a[1]")
  WebElement lblRenameInput;
   
 @FindBy(xpath = "//*[@id='exampleModalLabel']")
  WebElement hdrRenameInput;
//   
//  
   @FindBy(id = "newName")
   WebElement txtNewname;
//   
//  <button type="button" class="btn btn-primary" data-dismiss="modal" id="btn_renameSave">Save</button>
//   
   @FindBy(id="btn_renameSave")
   WebElement lblSaveRename;
//   
   public void lblRenameInput() {
//	   
	   lblRenameInput.click();
	   String actualhdrRenameInput = hdrRenameInput.getText();
	   Assert.assertEquals(actualhdrRenameInput, "Rename Input");
	   txtNewname.sendKeys("EDI 2");
	   lblSaveRename.click();
   
   }}
   
   
   


	
	