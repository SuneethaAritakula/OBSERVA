package com.OBSERVAMonitor;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OBSERVAContinuityPage extends BaseTest{
	@Test
	public void ContinuityPage() throws InterruptedException {
	
	ContinuityPage CP = PageFactory.initElements(driver, ContinuityPage.class);
	CP.ContinuityPage();
	Thread.sleep(5000);
	//CP.CaptureAllContinuityAlarmsColor(driver);
	Thread.sleep(5000);
	CP.tblFirstInput();
}}

//div[@class='col-3'][1]//*[@class='btn btn-default btn-fab btn-icon btn-round btn-configedit-overall pull-right']//i[@class='fas fa-cog']//div[contains(., 'All')][2]

//section[@id='mysection']/descendant::a[2]