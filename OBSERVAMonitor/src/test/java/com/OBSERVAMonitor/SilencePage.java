package com.OBSERVAMonitor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OBSERVAMonitor.utility.Utility;


@Test
public class SilencePage 
{

	private static final WebDriver driver = null;
	private static final int i = 0;


	String Red = "rgba(255, 54, 54, 1)";
	String Orange = "rgba(255, 178, 54, 1)";
	String Green = "rgba(24, 206, 15, 1)";
	String Black = "rgba(44, 44, 44, 1)";


	@FindBy(xpath = " //*[text()='Silence']")
	WebElement lnkSilence;


	// This method is used to click Silent tab on left panel
	public void SilencePageLeftTab() 
	{

		lnkSilence.click();

	}
	
	public String inputTitleDisplay(WebDriver driver,int rowValue)
	{
		String titleName;
		String  cardTitlexpath1="//*[@id='silence-row']/div[";
		String cardTitlexpath2="]/div/div[1]/div/div[1]/h4";
//		String xpathCardTitle=cardTitlexpath1+rowValue+cardTitlexpath2;
		WebElement  title=driver.findElement(By.xpath(cardTitlexpath1+rowValue+cardTitlexpath2));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", title);
		titleName=title.getText();
		System.out.println("Input Title :: " +titleName);
		return titleName;
	}

	// This method is used for capturing all input titles and colors under silence page - works well



	public void CapturingAudioPADDATAAlarmsColor(WebDriver driver,int index) throws InterruptedException 
	{
		try {		
		System.out.println("CaptureAllSilenceAlarmsColor Method ::");
		int rowValue=index-1;
		String TitleName = inputTitleDisplay(driver,index);

		String Alarmcolor = null;
		List<WebElement> Title = driver.findElements(By.xpath("//*[@class= 'card-title']"));
		System.out.println("Total Inputs(alarms) on Silence page:"+Title.size());
//		int Titlesize = Title.size();
//		String TitleName =  Title.get(rowValue).getText();
//    System.out.println(TitleName); 
		if (rowValue<Title.size()-1) 
		{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Title.get(rowValue));
		}

		String strHeart = driver.findElement(By.id("overall-state-"+rowValue)).getAttribute("class");

		if (strHeart.contains("danger")) 
		{
			System.out.println(TitleName + " Overall alarm status - Red");
			Alarmcolor = "Red";

		}else if(strHeart.contains("warning")) {

			System.out.println(TitleName+ " Overall alarm status - Orange");
			Alarmcolor = "Orange";

		}

		else if(strHeart.contains("success")) 
		{

			System.out.println(TitleName +" Overall alarm status - Green");
			Alarmcolor = "Green";

		}
		else if (strHeart.contains("default")) 
		{

			System.out.println(TitleName + " Overall alarm status - Black");
			Alarmcolor = "Grey";
		}



		//calling common method

		String AlarmComponentsColor = captureSilenceAlarmComponents(driver, rowValue);
		if (Alarmcolor.equalsIgnoreCase(AlarmComponentsColor))

		{
			System.out.println(TitleName+  " Alarm status("+Alarmcolor+") and overall alarm (Audio+PAD+Data)status("+AlarmComponentsColor+ ")is the same - Pass" );
		}

		else {
			System.out.println(TitleName+  " Alarm status("+Alarmcolor+") and overall alarm (Audio+PAD+Data)status("+AlarmComponentsColor+ ")is the same - Fail" );


		}
			    }	catch(Exception ex) {
			    	Utility.takeScreenshot(driver, "CapturingAudioPADDATAAlarmsColor");
			    }
	}




	//This method is used for capturing Audio, pad and data colors for each alarm under silence page - works well

	public String captureSilenceAlarmComponents(WebDriver driver, int index) throws InterruptedException

	{
		
	//	inputTitleDisplay(driver, index);
		String alarmOverallComponentsColor = null;	
		String Red = "rgba(255, 54, 54, 1)";
		String Orange = "rgba(255, 178, 54, 1)";
		String Green = "rgba(24, 206, 15, 1)";
		String Grey = "rgba(136, 136, 136, 1)";

		String AudioAlarm = driver.findElements(By.xpath("//*[starts-with(@id,'audio-overall-')]")).get(index).getCssValue("color").trim();
		if(AudioAlarm.equalsIgnoreCase(Red) ) {
			System.out.println("Audio Alarm "+(index+1)+" is: Red");
		} else if(AudioAlarm.equalsIgnoreCase(Orange))
		{
			System.out.println("Audio Alarm "+(index+1)+" is: Orange");
		}else if(AudioAlarm.equalsIgnoreCase(Green)) {
			System.out.println("Audio Alarm "+(index+1)+" is: Green");
		}else if(AudioAlarm.equalsIgnoreCase(Grey)){
			System.out.println("Audio Alarm "+(index+1)+" is: Grey");

			Thread.sleep(500);
			//		   }
		}


		String PADAlarm = driver.findElements(By.xpath("//*[starts-with(@id,'pad-overall-')]")).get(index).getCssValue("color").trim();
		
		if(PADAlarm.equalsIgnoreCase(Red) ) {
			System.out.println("PAD Alarm "+(index+1)+" is: Red");
		} else if(PADAlarm.equalsIgnoreCase(Orange))
		{
			System.out.println("PAD Alarm "+(index+1)+" is: Orange");
		}else if(PADAlarm.equalsIgnoreCase(Green)) {
			System.out.println("PAD Alarm "+(index+1)+" is: Green");
		}
		else if(PADAlarm.equalsIgnoreCase(Grey)){
			System.out.println("PAD Alarm "+(index+1)+" is: Grey");

			Thread.sleep(500);
		}

		String DATAAlarm = driver.findElements(By.xpath("//*[starts-with(@id,'data-overall-')]")).get(index).getCssValue("color").trim();

		if(DATAAlarm.equalsIgnoreCase(Red) ) {
			System.out.println("DATA Alarm "+(index+1)+" :: Red");
		} else if(DATAAlarm.equalsIgnoreCase(Orange))
		{
			System.out.println("DATA Alarm "+(index+1)+" :: Orange");
		}else if(DATAAlarm.equalsIgnoreCase(Green)) {
			System.out.println("DATA Alarm "+(index+1)+" :: Green");
		}
		else if(DATAAlarm.equalsIgnoreCase(Grey)){
			System.out.println("DATA Alarm "+(index+1)+" :: Grey");

			Thread.sleep(500);
		}

		String allAlarmComponentsColor = AudioAlarm +PADAlarm + DATAAlarm ; 

		if(allAlarmComponentsColor.contains((Red)))

		{
			alarmOverallComponentsColor = "Red";


		}else if((allAlarmComponentsColor.contains(Orange))) {

			alarmOverallComponentsColor = "Orange";


		}else if((allAlarmComponentsColor.contains(Green))) {

			alarmOverallComponentsColor = "Green";
		}

		else if ((allAlarmComponentsColor.contains(Grey))) {

			alarmOverallComponentsColor = "Grey";

		}

		return alarmOverallComponentsColor ;

	}




	//This method is used for capturing Audio, pad and data colors for each alarm under silence page - works well

	public String audioSilenceAlarmComponent(WebDriver driver, int index)

	{
		String colorValue = driver.findElements(By.xpath("//*[starts-with(@id,'audio-overall-')]")).get(index).getCssValue("color").trim();
		String audiocolorValue=  returnColorValue(driver,colorValue);
		return audiocolorValue;
	}

	public String padSilenceAlarmComponent(WebDriver driver, int index)

	{
		String colorValue = driver.findElements(By.xpath("//*[starts-with(@id,'pad-overall-')]")).get(index).getCssValue("color").trim();
		String padcolorValue= returnColorValue(driver,colorValue);
		return padcolorValue;
	}

	public String dataSilenceAlarmComponent(WebDriver driver, int index) throws InterruptedException

	{
		Thread.sleep(5000);
		String colorValue = driver.findElements(By.xpath("//*[starts-with(@id,'data-overall-')]")).get(index).getCssValue("color").trim();
		String datacolorValue =   returnColorValue(driver,colorValue);
		return datacolorValue;
	}

	public String returnColorValue(WebDriver driver, String value)

	{
		String colorValue = null;	
		String Red = "rgba(255, 54, 54, 1)";
		String Orange = "rgba(255, 178, 54, 1)";
		String Green = "rgba(24, 206, 15, 1)";
		String Grey = "rgba(136, 136, 136, 1)";
		//System.out.println("Alarm color :: "+value);
		if(value.equalsIgnoreCase(Red) ) {
			colorValue="Red";
			//System.out.println("Alarm color:: Red");
		} else if(value.equalsIgnoreCase(Orange))
		{
			colorValue="Orange";
			//System.out.println("Alarm color:: ORANGE");
		}else if(value.equalsIgnoreCase(Green)) {
			colorValue="Green";
			//System.out.println("Alarm color:: GREEN");
		}else if(value.equalsIgnoreCase(Grey)){
			colorValue="Grey";
			//System.out.println("Alarm color:: GREY");
			
		}

		return colorValue ;

	}
	
	public void silencePageInputsAndAlarms(WebDriver driver,String AudioVolume,String AudioTimeOut,String PadTimeOut,
			String DlsTimeOut,String MotTimeOut,String motStallTimeOUT) throws InterruptedException {

		List<WebElement> InputTitles = driver.findElements(By.xpath("//*[@id='silence-row']/div"));
		int Titlesize = InputTitles.size();
		System.out.println("InputTitles  : " + Titlesize);

		for (int i = 1; i <= Titlesize; i++) {
			String  cardTitlexpath1="//*[@id='silence-row']/div[";
			String cardTitlexpath2="]/div/div[1]/div/div[1]/h4";
			String xpathCardTitle=cardTitlexpath1+i+cardTitlexpath2;
			WebElement  title=driver.findElement(By.xpath(xpathCardTitle));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", title);
			System.out.println("Input Title :: " +title.getText());
			OverallAudioSilenceSettings(driver,i,AudioVolume,AudioTimeOut);
			AudioSubComponentAlarms(driver,i); 
			OverallPADSilenceSettings(driver,i,PadTimeOut,DlsTimeOut,MotTimeOut);
			PADSubComponentAlarms(driver,i); 
			OverallDATASilenceSettings(driver,i,motStallTimeOUT);
			DATASubComponentAlarms(driver,i); 
			CapturingAudioPADDATAAlarmsColor(driver,i);

		}
	}

	//15/10/2019  - clicking on overall silence buttons and changing settings - works well

		public void OverallAudioSilenceSettings(WebDriver driver, int index,String audioVolume,String audioTimeout) throws InterruptedException{
			System.out.println("OverallAudioSilenceSettings Method with four parameters ::");

			String  audioxpath1="//*[@id='silence-row']/div[";
			String audioxpath2="]/div/div[1]/div/div[2]/button";
			String audioSettingButton=audioxpath1+index+audioxpath2;
			WebElement audiobutton=driver.findElement(By.xpath(audioSettingButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", audiobutton);
			executor.executeScript("arguments[0].click();", audiobutton);
			driver.findElement(By.xpath("//*[@id='audiothreshold']")).clear();
			driver.findElement(By.xpath("//*[@id='audiothreshold']")).sendKeys(audioVolume);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='audiotimeout']")).clear();
			driver.findElement(By.xpath("//*[@id='audiotimeout']")).sendKeys(audioTimeout);
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[@id='btn_save']")).click();
			Thread.sleep(5000);
		}
		
		public void OverallPADSilenceSettings(WebDriver driver, int index,String padtimeout,String dlstimeout,String mottimeout ) throws InterruptedException{
			System.out.println("OverallPADSilenceSettings Method ::");

			String  audioxpath1="//*[@id='silence-row']/div[";
			String audioxpath2="]/div/div/div/div/button";
			String audioSettingButton=audioxpath1+index+audioxpath2;
			WebElement audiobutton=driver.findElement(By.xpath(audioSettingButton));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", audiobutton);
			executor.executeScript("arguments[0].click();", audiobutton);
			//document.getElementById('silence-row')
			driver.findElement(By.xpath("//*[@id='padtimeout']")).clear();
			driver.findElement(By.xpath("//*[@id='padtimeout']")).sendKeys(padtimeout);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='dlstimeout']")).clear();
			driver.findElement(By.xpath("//*[@id='dlstimeout']")).sendKeys(dlstimeout);
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id='mottimeout']")).clear();
			driver.findElement(By.xpath("//*[@id='mottimeout']")).sendKeys(mottimeout);
			driver.findElement(By.xpath("//button[@id='btn_save']")).click();
			Thread.sleep(5000);  
		}
		

		public void OverallDATASilenceSettings(WebDriver driver, int index,String motStallTimeout) throws InterruptedException{
			System.out.println("OverallDATASilenceSettings Method ::");
			int rowValue=index-1;
			//	Thread.sleep(5000);
			String datacolorStatus=  dataSilenceAlarmComponent(driver,rowValue);
			if(!datacolorStatus.equals("Grey")) {
				WebElement databuttonOverall=driver.findElement(By.xpath("//*[@href='#data-collapse-"+rowValue+"']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", databuttonOverall);
				executor.executeScript("arguments[0].click();", databuttonOverall);

				String  dataxpath1="//*[@id='data-collapse-";
				String dataxpath2="']/div/div/div/div/div/div/div[2]/div[1]/button";
				String dataSettingButton=dataxpath1+rowValue+dataxpath2;
				WebElement databuttonIndividual=driver.findElement(By.xpath(dataSettingButton));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].scrollIntoView(true);", databuttonIndividual);
				executor1.executeScript("arguments[0].click();", databuttonIndividual);
				//document.getElementById('silence-row')
				driver.findElement(By.xpath("//*[@id='datatimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='datatimeout']")).sendKeys(motStallTimeout);
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[@id='btn_save1']")).click();
			}
			else {
				System.out.println("unable to run because of ::"+datacolorStatus);
			}
		}
		
		public void OverallDATASilenceSettings(WebDriver driver, int index) throws InterruptedException{
			
			
			System.out.println("OverallDATASilenceSettings Method ::");
			int rowValue=index-1;

			String datacolorStatus=  dataSilenceAlarmComponent(driver,rowValue);
			if(!datacolorStatus.equals("Grey")) {
				WebElement databuttonOverall=driver.findElement(By.xpath("//*[@href='#data-collapse-"+rowValue+"']"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", databuttonOverall);
				executor.executeScript("arguments[0].click();", databuttonOverall);

				String  dataxpath1="//*[@id='data-collapse-";
				String dataxpath2="']/div/div/div/div/div/div/div[2]/div[1]/button";
				String dataSettingButton=dataxpath1+rowValue+dataxpath2;
				WebElement databuttonIndividual=driver.findElement(By.xpath(dataSettingButton));
				JavascriptExecutor executor1 = (JavascriptExecutor)driver;
				executor1.executeScript("arguments[0].scrollIntoView(true);", databuttonIndividual);
				executor1.executeScript("arguments[0].click();", databuttonIndividual);
				//document.getElementById('silence-row')
				driver.findElement(By.xpath("//*[@id='datatimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='datatimeout']")).sendKeys("1");
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[@id='btn_save1']")).click();
			}
			else {
				System.out.println("unable to run because of ::"+datacolorStatus);
			}
		}
		
		

		
	//	}



	//01/10/19 - captures attribute class and Audio subcomponent alarm colors of the first input only - stale element exception 
	public void AudioSubComponentAlarms(WebDriver driver, int index) throws InterruptedException
	{
		int rowValue=index-1;
		inputTitleDisplay(driver,index);
		List<WebElement> AudioSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowValue+"')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
		int Titlesize = AudioSubComponents.size();
		System.out.println(Titlesize);
		for (int k=1;k<=Titlesize;k++)
		{
			String AudioSubComponent = null;
			int retryCount=0;
			while(retryCount<2)
			{
				try {
					AudioSubComponent= driver.findElement(By.xpath("(//*[@id='audio-collapse-"+rowValue+"']/div/div/div/div/div/div/div/div/div/i)["+k+"]")).getAttribute("class");
				}catch(StaleElementReferenceException exp) {
					retryCount++;
				}
			}
			System.out.println("Audio component class contains :: "+AudioSubComponent);
			if (AudioSubComponent.contains("danger"))

			{
				System.out.println("Audio Alarm" +k+"  "+ "is in Red");

			}

			else if(AudioSubComponent.contains("warning"))

			{
				System.out.println("Audio Alarm"+k+"  "+ "is in Orange");

			} 
			else if(AudioSubComponent.contains("success"))
			{

				System.out.println("Audio Alarm"+k+"  "+ "is in Green");
			}

			else if(AudioSubComponent.contains("default"))
			{

				System.out.println("Audio Alarm "+k+"  "+ "is in Grey");

			}


		}

	}


	//01/10/19 - captures attribute class and PAD subcomponent alarm colors of the first input only - stale element exception when run with Audio & data subcomponent alarm colors
	public void PADSubComponentAlarms(WebDriver driver, int index) throws InterruptedException

	{


		int rowValue=index-1;
		inputTitleDisplay(driver,index);
		List<WebElement> PADSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowValue+"')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
		int Titlesize = PADSubComponents.size();
		System.out.println(Titlesize);
		for (int k=1;k<=Titlesize;k++)
		{
			String PADSubComponent = null;
			int retryCount=0;
			while(retryCount<2)
			{
				try {
					PADSubComponent= driver.findElement(By.xpath("(//*[@id='pad-collapse-"+rowValue+"']/div/div/div/div/div/div/div/div/div/i)["+k+"]")).getAttribute("class");
				}catch(StaleElementReferenceException exp) {
					retryCount++;
				}
			}
			System.out.println("padcomponent calss contains :: "+PADSubComponent);
			if (PADSubComponent.contains("danger"))

			{
				System.out.println("PAD Alarm" +k+"  "+ "is in Red");

			}

			else if(PADSubComponent.contains("warning"))

			{
				System.out.println("PAD Alarm"+k+"  "+ "is in Orange");

			} 
			else if(PADSubComponent.contains("success"))
			{

				System.out.println("PAD Alarm"+k+"  "+ "is in Green");
			}

			else if(PADSubComponent.contains("default"))
			{

				System.out.println("PAD Alarm "+k+"  "+ "is in Grey");

			}


		}

	}
			  
		
	
	public void DATASubComponentAlarms(WebDriver driver, int index) throws InterruptedException

	{
		
			int rowValue=index-1;
			inputTitleDisplay(driver,index);
			
			List<WebElement> DATASubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'data-row-"+rowValue+"')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
			int Titlesize = DATASubComponents.size();
			System.out.println(Titlesize);
			for (int k=1;k<=Titlesize;k++)
			{
				String DATASubComponent = null;
				int retryCount=0;
				while(retryCount<2)
				{
					try {
						DATASubComponent= driver.findElement(By.xpath("(//*[@id='data-collapse-"+rowValue+"']/div/div/div/div/div/div/div/div/div/i)["+k+"]")).getAttribute("class");
					}catch(StaleElementReferenceException exp) {
						retryCount++;
					}
				}
				System.out.println("datacomponent contains :: "+DATASubComponent);
				if (DATASubComponent.contains("danger"))

				{
					System.out.println("Data Alarm" +k+"  "+ "is in Red");

				}

				else if(DATASubComponent.contains("warning"))

				{
					System.out.println("Data Alarm"+k+"  "+ "is in Orange");

				} 
				else if(DATASubComponent.contains("success"))
				{

					System.out.println("Data Alarm"+k+"  "+ "is in Green");
				}

				else if(DATASubComponent.contains("default"))
				{

					System.out.println("Data Alarm "+k+"  "+ "is in Grey");

				}


			}

		}
	
	//05/11/2019 - To pass Audio Threshold settings to individual audio services and capture individual Audio Service Labels

		public void individualAudioSilenceSettings(WebDriver driver, int index,String AudioVolume,String AudioTimeOut) throws InterruptedException {
	        inputTitleDisplay(driver, index);
			Thread.sleep(2000);
			boolean bFlag  = false;
			int rowvalue=index-1;
			String audiocolorStatus=  audioSilenceAlarmComponent(driver,rowvalue);
			if(!audiocolorStatus.equals("Grey")) {

			List<WebElement>individualAudioSilenceSettings = driver.findElements(By.xpath("//*[@id='audio-collapse-"+rowvalue+"']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));
			int Titlesize = individualAudioSilenceSettings.size();
			System.out.println("individualAudioSilenceSettings : "+Titlesize);

			for(int i=1;i<=Titlesize;i++)	
			{

					

				//"//*[@id='pad-collapse-"+rowvalue+"']/div/div/div["

				String a = "//*[@id='audio-collapse-"+rowvalue+"";
				String b = "']/div/div/div[";
				String c = "]/div/div[2]/div/button";

				String a1 = "//*[@id='audio-collapse-"+rowvalue+"";
				String b1 = "']/div/div/div[";
				String c1 = "]/div/div[2]/div";

				String individualAudioSilenceSettingsButton1 = a1+b1+i+c1;
				 Thread.sleep(2000);
				 String value = null;
				  int retryCount=0;
				  while(retryCount<2)
				  {
					  try {
						  value=driver.findElement(By.xpath(individualAudioSilenceSettingsButton1)).getAttribute("textContent");
					  }catch(StaleElementReferenceException exp) {
						  retryCount++;
						  //		Thread.sleep(1000);
					  }
				  }
				System.out.println("Audio Service Lables :: "+value);

				String individualAudioSilenceSettingsButton = a+b+i+c;
				//	driver.findElement(By.xpath(individualAudioSilenceSettingsButton)).click();
				// driver.findElement(By.xpath(a+b+i+c)).click();
				
				WebElement AudioSettings1 = driver.findElement(By.xpath(individualAudioSilenceSettingsButton));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].scrollIntoView(true);",AudioSettings1);
				executor.executeScript("arguments[0].click();",AudioSettings1);

				driver.findElement(By.xpath("//*[@id='audiothreshold']")).clear();
				driver.findElement(By.xpath("//*[@id='audiothreshold']")).sendKeys(AudioVolume);
				driver.findElement(By.xpath("//*[@id='audiotimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='audiotimeout']")).sendKeys(AudioTimeOut);
				driver.findElement(By.xpath("//*[@id='btn_save']")).click();
				Thread.sleep(1000);
				//driver.navigate().refresh();

			
					  }
			}
			}
		

		//15/11/2019 - To pass Audio Threshold settings to individual audio services and capture individual PAD Service Labels

		public void individualPADSilenceSettings(WebDriver driver,int index,String PadTimeOut,String DlsTimeOut,String MotTimeOut) throws InterruptedException {
	  
			inputTitleDisplay(driver, index);
			Thread.sleep(2000);
			boolean bFlag  = false;
			int rowvalue=index-1;
			String padcolorStatus=  padSilenceAlarmComponent(driver,rowvalue);
			if(!padcolorStatus.equals("Grey")) {

			List<WebElement>individualPADSilenceSettings = driver.findElements(By.xpath("//*[@id='pad-collapse-"+rowvalue+"']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));
//			List<WebElement>PADSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
			int Titlesize = individualPADSilenceSettings.size();
			System.out.println("individualPADSilenceSettings : "+Titlesize);

			//int index1 = 1;
			for(int i = 1;i<=Titlesize;i++)	
			{



				String d = "//*[@id='pad-collapse-"+rowvalue+"";
				String e = "']/div/div/div[";
				String f = "]/div/div[2]/div/button";


				String d1 = "//*[@id='pad-collapse-"+rowvalue+"";
				String e1 = "']/div/div/div[";
				String f1 = "]/div/div[2]/div";

				String individualpadSilenceSettingsButton1 = d1+e1+i+f1;
				 Thread.sleep(1000);
				  
				  String value = null;
				  int retryCount=0;
				  while(retryCount<2)
				  {
					  try {
						  value=driver.findElement(By.xpath(individualpadSilenceSettingsButton1)).getAttribute("textContent");
					  }catch(StaleElementReferenceException exp) {
						  retryCount++;
						  //		Thread.sleep(1000);
					  }
				  }
				
				 
		//		String padvalue=driver.findElement(By.xpath(individualpadSilenceSettingsButton1)).getAttribute("textContent");
				System.out.println("PAD Service Lables :: "+value);



				String individualPADSilenceSettingsButton = d+e+i+f;
				//  driver.findElement(By.xpath(individualPADSilenceSettingsButton)).click();
				//Thread.sleep(100);
				WebElement PADSettings1 = driver.findElement(By.xpath(individualPADSilenceSettingsButton));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].scrollIntoView(true);",PADSettings1);
				executor.executeScript("arguments[0].click();",PADSettings1);
				
				
				driver.findElement(By.xpath("//*[@id='padtimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='padtimeout']")).sendKeys(PadTimeOut);
				driver.findElement(By.xpath("//*[@id='dlstimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='dlstimeout']")).sendKeys(DlsTimeOut);
				driver.findElement(By.xpath("//*[@id='mottimeout']")).clear();
				driver.findElement(By.xpath("//*[@id='mottimeout']")).sendKeys(MotTimeOut);
				driver.findElement(By.xpath("//*[@id='btn_save']")).click();

				Thread.sleep(1000);

			}}}
		public void individualDATASilenceSettings(WebDriver driver, int index,String MOTStallTimeOUT) throws InterruptedException{
			inputTitleDisplay(driver, index);
			boolean bFlag = false;
			int rowValue=index-1;

			String datacolorStatus=  dataSilenceAlarmComponent(driver,rowValue);
			if(!datacolorStatus.equals("Grey")) {

				List<WebElement>individualDATASilenceSettings = driver.findElements(By.xpath("//*[@id='data-collapse-"+rowValue+"']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));


				int Titlesize = individualDATASilenceSettings.size();
				System.out.println("individualDATASilenceSettings : "+Titlesize);
				for(int i = 1;i<=Titlesize;i++)	
				{
					String p = "//*[@id='data-collapse-"+rowValue+"";
					String q = "']/div/div/div[1]/div/div/div/div[2]/div/button";

					String p1 = "//*[@id='data-collapse-"+rowValue+"";
					String q1 = "']/div/div/div[";
					String r1 = "]/div/div/div/div[2]";
					
					String individualDATASilenceSettingsButton1 = p1+q1+i+r1;
					Thread.sleep(1000);
					String value = null;
					int retryCount=0;
					while(retryCount<2)
					{
						try {
							value=driver.findElement(By.xpath(individualDATASilenceSettingsButton1)).getAttribute("textContent");
						}catch(StaleElementReferenceException exp) {
							retryCount++;

						}

					}
					String datavalue = driver.findElement(By.xpath(individualDATASilenceSettingsButton1)).getAttribute("textContent");
					System.out.println("DATA Service Lables :: "+value);
					String individualDATASilenceSettingsButton = p+q;
					WebElement DATASettings1 = driver.findElement(By.xpath(individualDATASilenceSettingsButton));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].scrollIntoView(true);",DATASettings1);
					executor.executeScript("arguments[0].click();",DATASettings1);
					driver.findElement(By.xpath("//*[@id='datatimeout']")).clear();
					driver.findElement(By.xpath("//*[@id='datatimeout']")).sendKeys(MOTStallTimeOUT);
					Thread.sleep(500);
					driver.findElement(By.xpath("//button[@id='btn_save1']")).click();
				}
			}
		}
	


	//List<WebElement> DATASubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'data-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4'][1]//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
	//String z = "DATASubComponents";
	//System.out.println(DATASubComponents.size());*/





	//Throws Stale Element Exception

	public void AudioSubComponentsLeftandRightStatsAlarmsAndText(WebDriver driver, int index) throws InterruptedException
	{
        int rowValue=index-1;
        inputTitleDisplay(driver,index);

		List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowValue+"')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
		int Titlesize = AudioSubComponentStatsText.size();
		System.out.println("Total Audio Sub components size (total number of inputs) :"+Titlesize);

		for(int j = 0;j<Titlesize;j++)	
		{

//			String audiotext1 = "//*[@id='audio-row-0']/div[1][";
//			String audiotext2 = "]/div/div/div";

			String AudioText =  AudioSubComponentStatsText.get(j).getText();
			System.out.print("Audio sub component "+(j+1)+"  statistics below:");
			System.out.println(AudioText);

		}}

	public void PADSubComponentsLeftandRightStatsAlarmsAndText(WebDriver driver, int index) {

		 int rowValue=index-1;
	        inputTitleDisplay(driver,index);


		//int PADTextsSize = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-1')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]")).size();

		List<WebElement> PADSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowValue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
		int Titlesize1 = PADSubComponentStatsText.size();
		System.out.println("Total PAD Sub components size (total number of inputs) : "+Titlesize1);

		//	JavascriptExecutor executor = (JavascriptExecutor)driver;
		// 	  executor.executeScript("arguments[0].scrollIntoView(true);", PADSubComponentStatsText);
		// 	  executor.executeScript("arguments[0].getText();", PADSubComponentStatsText);


		// ExpectedConditions.presenceOfElementLocated(By.xpath("//div[starts-with(@id,'pad-row-1')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
		// 	 WebDriverWait wait = new WebDriverWait(driver,100);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[starts-with(@id,'pad-row-1')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]")));
		for(int j = 0;j<Titlesize1;j++)	
		{

			//		String PADTexts = "padtext1+i+padtext2";
			//		String padtext1 = "//*[@id='pad-row-0']/div[1][";
			//		String padtext2 = "]/div/div/div";


			String PADText =  PADSubComponentStatsText.get(j).getText();
			System.out.println("PAD sub component "+(j+1)+"  service name ::");
			System.out.println(PADText);

		}
	}
	public void DataSubComponentsLeftandRightStatsAlarmsAndText(WebDriver driver, int index) throws InterruptedException {
		
		int rowValue=index-1;
        inputTitleDisplay(driver,index);

		List<WebElement> DATASubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'data-row-"+rowValue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
		int DataComponentSize = DATASubComponentStatsText.size();
		System.out.println("Total DATA Sub components size (total number of inputs) : "+DataComponentSize);

		for(int k = 0;k<DataComponentSize;k++)	
		{
			//	  String DataText1 = "//*[@id='data-row-0']/div[1][";
			//	  String DataText2 = "]/div/div/div";

			//		JavascriptExecutor executor = (JavascriptExecutor)driver;
			//	 	  executor.executeScript("arguments[0].scrollIntoView(true);", DATASubComponentStatsText);
			//	 	  executor.executeScript("arguments[0,250].getText();", DATASubComponentStatsText);


			String DATAText =  DATASubComponentStatsText.get(k).getText();
			System.out.println("DATA sub component "+(k+1)+"  service name ::");
			System.out.println(DATAText);



		}}




	//The below method can capture services text of audio subcomponents of one input only. However, throws stale element exception

	public void AudioSubComponentsColorsandStatsS(WebDriver driver, int index) throws InterruptedException
	{


		boolean bFlag  = false;
		int rowvalue=index-1;

		List<WebElement> AudioSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));

		int Titlesize1 = AudioSubComponents.size();

		System.out.println("Sub Audio Components "+"(total L and R alarms for the input):" +Titlesize1);

		// This list is all the Audio components for all inputs available
		List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
		int Titlesize = AudioSubComponentStatsText.size();
		System.out.println("Audio Sub components for the input : "+Titlesize);

		for(int i = 0;i<Titlesize;i++)	
		{

			//	  int retryCount=0;
			//	  while(retryCount<2)
			//		{
			//	      try {
			String Audio1Stats =  AudioSubComponentStatsText.get(i+1).getText();

			 System.out.println(Audio1Stats);

				       System.out.print("Audio sub component "+(i+1)+"  statistics below: "+"  ");
			//System.out.println(" Stats"+ Audio1Stats);

			////*[@id='audio-row-0']/div/div[1]/div/div
			String  audioxpath1="//*[@id='audio-row-"+rowvalue+"']/div/div[";
			String audioxpath2="]/div/div";

			String Audio = driver.findElement(By.xpath(audioxpath1+i+audioxpath2)).getAttribute("class");
			if (Audio.contains("danger"))

			{
				System.out.println(Audio+" is in Red ");
				bFlag = false;
				break ;

			}

			else if(Audio.contains("warning"))

			{
				System.out.println(Audio+" is in Orange ");
				bFlag = false;
				break ;

			} 
			else if(Audio.contains("success"))
			{

				System.out.println(Audio+" is in Green ");
				bFlag = false;
				break ;
			}

			else if(Audio.contains("default"))
			{

				System.out.println(Audio+" is in Grey ");
				bFlag = false;
				break ;

			}




			if (bFlag == true)

			{
				System.out.println("All audio subcomponents are in Green");


			}

		}}
		


	


	

	/* this is refrence method we can delete anytime */

	/*public void silencePageInputsAndAlarms(WebDriver driver) throws InterruptedException {

	List<WebElement> InputTitles = driver.findElements(By.xpath("//*[@id='silence-row']/div"));
	int Titlesize = InputTitles.size();
	System.out.println("InputTitles  : " + Titlesize);

	for (int i = 1; i <= Titlesize; i++) {
		 String  cardTitlexpath1="//*[@id='silence-row']/div[";
   	      String cardTitlexpath2="]/div/div[1]/div/div[1]/h4";
   	      String xpathCardTitle=cardTitlexpath1+i+cardTitlexpath2;
   	      WebElement  title=driver.findElement(By.xpath(xpathCardTitle));
   	   JavascriptExecutor executor = (JavascriptExecutor)driver;
   	executor.executeScript("arguments[0].scrollIntoView(true);", title);
   	System.out.println("Input Title :: " +title.getText());
   	OverallAudioSilenceSettings(driver,i);
   	AudioComponentsColorsV(driver,i);
   	OverallPADSilenceSettings(driver,i);
   	padSubComponentsColorsandStats(driver,i);
//   	padSubComponentsColorsandStats2(driver,i);
   	OverallDATASilenceSettings(driver,i);
   	dataSubComponentsColorsandStats(driver,i);
   	CapturingAudioPASDATAAlarmsColor(driver,i);
	 }
	}*/


	
	
	
	// We are not using below method anywhere we can delete
	
	public void silencePadSettingsPageCardTitle(WebDriver driver) throws InterruptedException {

		List<WebElement> inputTitles = driver.findElements(By.xpath("//*[@id='silence-row']/div"));
		int Titlesize = inputTitles.size();
		System.out.println("inputTitles  : " + Titlesize);

		for (int i = 1; i <= Titlesize; i++) {
			String  cardTitlexpath1="//*[@id='silence-row']/div[";
			String cardTitlexpath2="]/div/div[1]/div/div[1]/h4";
			String xpathCardTitle=cardTitlexpath1+i+cardTitlexpath2;
			WebElement  title=driver.findElement(By.xpath(xpathCardTitle));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", title);
			System.out.println("Input title is :: "+title.getText());
            PADSubComponentAlarms(driver,i);//captures titles and pad subcomponents of all the inputs available


		}}}
//	}

	




	
	


		
			
/* deleted methods
 * 
 * SP.silencePageInputsAndAlarms(driver);
 * 
 */




























