/*import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

/*

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

package com.OBSERVAMonitor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DuplicateMethods {
//15/10/19 - trying to capture Individual Audio subcomponents with text and alarms for the first input only - works well

	//20/11/2019 - trying to capture Individual Audio subcomponent alarms of 1 input only

	public void AudioSubComponentsColorsandStats(WebDriver driver, int index) throws InterruptedException 
	{

		System.out.println("AudioSubComponentsColorsandStats Method ::");
		//Thread.sleep(1000);
		boolean bFlag  = false;
		int rowvalue= index-1;

		String audiocolorStatus=  audioSilenceAlarmComponent(driver,rowvalue);

		if(!audiocolorStatus.equals("Grey")) {
			List<WebElement> AudioSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));

			int Titlesize1 = AudioSubComponents.size();

			System.out.println("Sub Audio Components "+"(total L and R alarms for the input):" +Titlesize1);


			List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
			int Titlesize = AudioSubComponentStatsText.size();
			System.out.println("Audio Sub components for the input : "+Titlesize);

			for(int i = 1;i<=Titlesize;i++)	
			{

				int retryCount=0;
				while(retryCount<2)
				{
					try {


						String  audioxpath1="//*[@id='audio-collapse-"+rowvalue+"']/div/div/div[";
						String audioxpath2="]/div/div/div/div/div[1]/div[1]/i";
						//String audioxpath=audioxpath1+i+audioxpath2;
						String audiostatus=driver.findElement(By.xpath(audioxpath1+i+audioxpath2)).getAttribute("class");



						if (audiostatus.contains("danger"))

						{
							System.out.println(audiostatus+"::Alarm color:: Red ");
							bFlag = false;
							break ;

						}

						else if(audiostatus.contains("warning"))

						{
							System.out.println(audiostatus+":: Alarm color:: Orange ");
							bFlag = false;
							break ;

						} 
						else if(audiostatus.contains("success"))
						{

							System.out.println(audiostatus+":: Alarm color:: Green ");
							bFlag = false;
							break ;
						}

						else if(audiostatus.contains("default"))
						{

							System.out.println(audiostatus+":: Alarm color:: Grey ");
							bFlag = false;
							break ;

						}




						if (bFlag == true)

						{
							System.out.println("All audio subcomponents are in Green");


						}

					}
					catch(StaleElementReferenceException exp) {
						retryCount++;
						Thread.sleep(100);
						//    	  exp.getStackTrace();
					}
					catch(Exception exp) {
						exp.getStackTrace();
					}
				}
			}
		}else {
			System.out.println("Audio Colour value is in "+audiocolorStatus);
		}
	}


	//The below method works well. Only captures audio sub component alarm colours of one input at a time.

	public void padSubComponentsColorsandStats(WebDriver driver,int index) throws InterruptedException 
	{
		
		inputTitleDisplay(driver, index);
		System.out.println("padSubComponentsColorsandStats Method ::");
			Thread.sleep(1000);

		boolean bFlag  = false;
		int rowvalue=index-1;
		String padcolorStatus=  padSilenceAlarmComponent(driver,rowvalue);
		if(!padcolorStatus.equals("Grey")) {

			List<WebElement>PADSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));


			//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]
			int Titlesize1 = PADSubComponents.size();

			System.out.println("Sub PAD Components "+"(total L and R alarms for the input):" +Titlesize1);


			List<WebElement> PADSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
			int Titlesize = PADSubComponentStatsText.size();
			System.out.println("PAD Sub components for the input : "+Titlesize);

			for(int i = 1;i<=Titlesize;i++)	
			{

				int retryCount=0;
				while(retryCount<2)
				{
					try {
						String  padxpath1="//*[@id='pad-collapse-"+rowvalue+"']/div/div/div[";
						String padxpath2="]/div/div/div/div/div[1]/div[1]/i";
						String padstatus=driver.findElement(By.xpath(padxpath1+i+padxpath2)).getAttribute("class");




						if (padstatus.contains("danger"))

						{
							System.out.println(padstatus+" is in Red ");
							bFlag = false;
							break ;

						}

						else if(padstatus.contains("warning"))

						{
							System.out.println(padstatus+" is in Orange ");
							bFlag = false;
							break ;

						} 
						else if(padstatus.contains("success"))
						{

							System.out.println(padstatus+" is in Green ");
							bFlag = false;
							break ;
						}

						else if(padstatus.contains("default"))
						{

							System.out.println(padstatus+" is in Grey ");
							bFlag = false;
							break ;

						}




						if (bFlag == true)

						{
							System.out.println("All PAD subcomponents are in Green");


						}

					}
					catch(StaleElementReferenceException exp) {
						retryCount++;
						Thread.sleep(100);
					}
					catch(Exception exp) {
						exp.getStackTrace();
					}
				}
			}
		}else {
			System.out.println("PAD Colour value is in "+padcolorStatus);
		}
	}

	public void dataSubComponentsColorsandStats(WebDriver driver, int index) throws InterruptedException 
	{

		System.out.println("dataSubComponentsColorsandStats Method ::");
		//	Thread.sleep(1000);
		boolean bFlag  = false;
		int rowvalue=index-1;
		String datacolorStatus=  dataSilenceAlarmComponent(driver,rowvalue);
		if(!datacolorStatus.equals("Grey")) {

			List<WebElement>dataSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'data-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));


			//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]
			int Titlesize1 = dataSubComponents.size();

			System.out.println("Sub DATA Components "+"(total L and R alarms for the input):" +Titlesize1);


			List<WebElement> DATASubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'data-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));

			int Titlesize = DATASubComponentStatsText.size();
			System.out.println("DATA Sub components for the input : "+Titlesize);

			for(int i = index;i<=Titlesize;i++)	
			{

				int retryCount=0;
				while(retryCount<2)
				{
					try {


						String  dataxpath1="//*[@id='data-collapse-"+rowvalue+"']/div/div/div[";
						String dataxpath2="]/div/div/div/div/div[1]/div[1]/i";
						String datastatus=driver.findElement(By.xpath(dataxpath1+i+dataxpath2)).getAttribute("class");




						if (datastatus.contains("danger"))

						{
							System.out.println(datastatus+" is in Red ");
							bFlag = false;
							break ;

						}

						else if(datastatus.contains("warning"))

						{
							System.out.println(datastatus+" is in Orange ");
							bFlag = false;
							break ;

						} 
						else if(datastatus.contains("success"))
						{

							System.out.println(datastatus+" is in Green ");
							bFlag = false;
							break ;
						}

						else if(datastatus.contains("default"))
						{

							System.out.println(datastatus+" is in Grey ");
							bFlag = false;
							break ;

						}




						if (bFlag == true)

						{
							System.out.println("All DATA subcomponents are in Green");


						}

					}
					catch(StaleElementReferenceException exp) {
						retryCount++;
						Thread.sleep(100);
					}
					catch(Exception exp) {
						exp.getStackTrace();
					}
				}
			}
		}else {
			System.out.println("DATA Colour value is in "+datacolorStatus);
		}
	}


	//Stale element exception	

	public void AudioSubComponentsColors(WebDriver driver, int index) throws InterruptedException
	{

		//String audioSubComponent = null;	
		//    String red = "danger";
		//    String orange = "warning";
		//    String green = "success";
		//    String grey = "default";

		boolean bFlag  = false;

		//driver.navigate().refresh();
		// Thread.sleep(20000);




		List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-0')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
		int Titlesize = AudioSubComponentStatsText.size();
		System.out.println("Total Audio Sub components size : "+Titlesize);

		List<WebElement> AudioSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-0')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));

		int Titlesize1 = AudioSubComponents.size();
		System.out.println("Size"+Titlesize1);
		Thread.sleep(10000);
		WebDriverWait w = new WebDriverWait(driver, 60);

		for(int i = 0;i<Titlesize1;i++)	
		{
			System.out.println("Inside loop");
			String Audio1Stats =  AudioSubComponentStatsText.get(i).getText();
			System.out.println("Audio sub component "+(i+1)+" text value is: "+"  "+ Audio1Stats);

			//	       List<WebElement> AudioSubComponents =AudioSubComponentStatsText.get(i).findElements(By.xpath("//div[starts-with(@id,'audio-row-0')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
			//List<WebElement> AudioSubComponents =AudioSubComponentStatsText.get(i).findElements(By.xpath("//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
			//int Titlesize1 = AudioSubComponents.size();
			//System.out.println("Sub Audio Component "+(i+1)+ "L and R color size : "+Titlesize1);

			//String x = "AudioSubComponents";
			//System.out.println(AudioSubComponents.size());

			//	for(int i = 0;i<Titlesize;i++)	
			//        {
			//	 
			//	       String audioSubComponents =  AudioSubComponents.get(i).getText();
			//	      System.out.println(audioSubComponents);
			//        }
			//	for (WebElement audioSubComponents:AudioSubComponents)
			//	{         
			w.until(ExpectedConditions.visibilityOf(AudioSubComponents.get(i)));
			String x =AudioSubComponents.get(i).getAttribute("class");
			System.out.println(x);
			if (x.contains("danger"))
			{
				//String y = "Red";
				//System.out.println("Audio Alarm "+(index)+1+" is: Red");

				//System.out.println(audioSubComponents.getText()+ " contains red");
				System.out.println("Over all Audio is"+" is in Red ");
				bFlag = false;
				break ;
			}
			else if(x.contains("warning"))

			{
				//String y = "Orange";
				//	System.out.println("Audio Alarm "+(index+1)+" is: Orange");
				//System.out.println(audioSubComponents.getText()+ " contains Orange");

				System.out.println("OverAll Audio"+" is in Orange ");
				bFlag = false;
				break;


			} else if(x.contains("success"))
			{
				//String y = "Green";
				//					System.out.println("Audio Alarm "+(index+1)+" is: Green");

				bFlag = true;
			}

			else if(x.contains("default"))
			{
				//String y = "Green";
				//System.out.println("Audio Alarm "+(index+1)+" is: Grey");
				//System.out.println(Audio1Stats+" is in Grey ");
				bFlag = true;

			}
		}
		//}
		if (bFlag == true)

		{
			System.out.println("All audio subcomponents are in Green");


		}
	}


}
*/