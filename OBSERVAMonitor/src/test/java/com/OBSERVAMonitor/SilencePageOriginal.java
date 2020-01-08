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


@Test
public class SilencePageOriginal 
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
	
	// This method is used for capturing all input titles and colors under silence page - works well
	   
	   
	   
		public void CapturingAudioPASDATAAlarmsColor(WebDriver driver,int index) throws InterruptedException 
		   {
			System.out.println("CaptureAllSilenceAlarmsColor Method ::");
			int rowValue=index-1;

			     String Alarmcolor = null;
			     List<WebElement> Title = driver.findElements(By.xpath("//*[@class= 'card-title']"));
			     System.out.println("Total Inputs(alarms) on Silence page:"+Title.size());
			     int Titlesize = Title.size();
//		     for(int i = 0;i<Titlesize;i++)	
//		          {
				 
				       String TitleName =  Title.get(rowValue).getText();
			     //  System.out.println(TitleName); 
				       if (rowValue<Titlesize-1) 
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
			
			
					
//			SilencePage s =new SilencePage();
			String AlarmComponentsColor = captureSilenceAlarmComponents(driver, rowValue);
			if (Alarmcolor.equalsIgnoreCase(AlarmComponentsColor))
					
					{
				       System.out.println(TitleName+  " Alarm status("+Alarmcolor+") and overall alarm (Audio+PAD+Data)status("+AlarmComponentsColor+ ")is the same - Pass" );
					}
			
			else {
				       System.out.println(TitleName+  " Alarm status("+Alarmcolor+") and overall alarm (Audio+PAD+Data)status("+AlarmComponentsColor+ ")is the same - Fail" );
				        
				
			     }
//		    }		
		 }
					
	   
	
			     
    //This method is used for capturing Audio, pad and data colors for each alarm under silence page - works well
		
	public String captureSilenceAlarmComponents(WebDriver driver, int index) throws InterruptedException
	
	   {
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
		  // System.out.println("PAD Alarm "+(index+1)+" is: "+PADAlarm);
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
		   //System.out.println("DATA Alarm "+(index+1)+" is: "+DATAAlarm);
		   
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
		  // System.out.println(allAlarmComponentsColor);
		   
		   if(allAlarmComponentsColor.contains((Red)))
				 
			{
				//System.out.println("alarm is Red");
			   alarmOverallComponentsColor = "Red";
					
				
			}else if((allAlarmComponentsColor.contains(Orange))) {
					
					//System.out.println("alarm is Orange");
				alarmOverallComponentsColor = "Orange";
				
			
				}else if((allAlarmComponentsColor.contains(Green))) {
					
					//System.out.println("alarm is Green");
					alarmOverallComponentsColor = "Green";
				}
					
					else if ((allAlarmComponentsColor.contains(Grey))) {
					
					//System.out.println("alarm is Grey");
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
				   System.out.println("Alarm color :: "+value);
				   if(value.equalsIgnoreCase(Red) ) {
					   colorValue="Red";
					   System.out.println("Alarm color:: Red");
				   } else if(value.equalsIgnoreCase(Orange))
				   {
					   colorValue="Orange";
					   System.out.println("Alarm color:: ORANGE");
				   }else if(value.equalsIgnoreCase(Green)) {
					   colorValue="Green";
					   System.out.println("Alarm color:: GREEN");
				   }else if(value.equalsIgnoreCase(Grey)){
					   colorValue="Grey";
					   System.out.println("Alarm color:: GREY");
//				   }
				   }
				 
				return colorValue ;
				
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

	
	
	
	//01/10/19 - captures attribute class and Audio subcomponent alarm colors of the first input only - stale element exception 
	public void AudioSubComponentAlarms(WebDriver driver, int index) throws InterruptedException
	{
     int i=1;
     int inputNumber = 0;
	
	List<WebElement> AudioSubComponents = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+inputNumber+"')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
	int Titlesize = AudioSubComponents.size();
	System.out.println(Titlesize);
	
	//Thread.sleep(2000);
		  
	
	for (WebElement AudioSubComponent:AudioSubComponents)
	  {
		 
		{
			System.out.println(AudioSubComponent.getAttribute("class"));
			
	  						
	if ((AudioSubComponent.getAttribute("class").contains("danger")))
				
	   {
			System.out.println("Audio Alarm " +(i+1)+"  "+ "is in Red");
					
	   }
	else if((AudioSubComponent.getAttribute("class").contains("warning")))
				
	  {
			System.out.println("Audio Alarm " +(i+1)+"  "+ "is in Orange");
				
	  } 
	else if((AudioSubComponent.getAttribute("class").contains("success")))
				
	   {
		    System.out.println("Audio Alarm "+(i+1)+"  "+ "is in Green");
				
	   }
	
    else if((AudioSubComponent.getAttribute("class").contains("default")))
					
       {
			System.out.println("Audio Alarm "+(i+1)+"  "+ "is in Grey");
	   }
	 i++;
		}}}

    
	
	//01/10/19 - captures attribute class and PAD subcomponent alarm colors of the first input only - stale element exception when run with Audio & data subcomponent alarm colors
	public void PADSubComponentAlarms(WebDriver driver, int index) throws InterruptedException
		
	{
	    
		int i=0;
		int inputNumber = 0;
	List<WebElement> PADSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+inputNumber+"')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
	//div[starts-with(@id,'pad-row-0')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')] - individual PAD and MOT under PAD returns 20 values
	//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4'][1]//*[contains(@class ,'fa fa-circle fa-fw icon')] - first block returns 2 values
	
	
	int Titlesize = PADSubComponents.size();
	
	System.out.println(Titlesize);
	
	for (WebElement PADSubComponent:PADSubComponents)
	  {
		
		{
				System.out.println(PADSubComponent.getAttribute("class"));
													
	if ((PADSubComponent.getAttribute("class").contains("danger")))
				
	    {
				System.out.println("PAD Alarm" +(i+1)+"  "+ "is in Red");
				
		}
	
	else if((PADSubComponent.getAttribute("class").contains("warning")))
				
		{
				System.out.println("PAD Alarm"+(i+1)+"  "+ "is in Orange");
						
		} 
	else if((PADSubComponent.getAttribute("class").contains("success")))
		{
					
				System.out.println("PAD Alarm"+(i+1)+"  "+ "is in Green");
		}
					
	else if((PADSubComponent.getAttribute("class").contains("default")))
		{
						
			   System.out.println("PAD Alarm "+(i+1)+"  "+ "is in Grey");
			   
		}
	i++;
		}}}
	
	
	public void DATASubComponentAlarms(WebDriver driver, int index) throws InterruptedException
	
	{
		int i=0; 
		int inputNumber = 0;
	List<WebElement> DATASubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'data-row-"+inputNumber+"')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
	//div[starts-with(@id,'pad-row-0')]//*[@class='card card-stats']//*[contains(@class ,'fa fa-circle fa-fw icon')] - individual PAD and MOT under PAD returns 20 values
	//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4'][1]//*[contains(@class ,'fa fa-circle fa-fw icon')] - first block returns 2 values
	
	
	int Titlesize = DATASubComponents.size();
	
	System.out.println(Titlesize);
	
	for (WebElement DATASubComponent:DATASubComponents)
	  {
		 
		{
				System.out.println(DATASubComponent.getAttribute("class"));
													
	if ((DATASubComponent.getAttribute("class").contains("danger")))
				
	    {
				System.out.println("DATA Alarm" +(index)+1+ "color:: Red");
				
		}
	
	else if((DATASubComponent.getAttribute("class").contains("warning")))
				
		{
				System.out.println("DATA Alarm" +(index)+1+ "color:: Orange");
						
		} 
	else if((DATASubComponent.getAttribute("class").contains("success")))
		{
					
				System.out.println("DATA Alarm"+(index)+1+ "color:: Green");
		}
					
	else if((DATASubComponent.getAttribute("class").contains("default")))
		{
						
			   System.out.println("DATA Alarm"+(index)+1+ "color:: Grey");
						
		}
	i++;
	}}}

	
	//List<WebElement> DATASubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'data-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4'][1]//*[contains(@class ,'fa fa-circle fa-fw icon')]"));
	//String z = "DATASubComponents";
	//System.out.println(DATASubComponents.size());*/
	

	
	
	
	//Throws Stale Element Exception
   	
public void AudioSubComponentsLeftandRightStatsAlarmsAndText(WebDriver driver, int index) throws InterruptedException
	{
	
	    
    List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-0')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
	int Titlesize = AudioSubComponentStatsText.size();
	System.out.println("Total Audio Sub components size (total number of inputs) :"+Titlesize);
	
	for(int i = 0;i<Titlesize;i++)	
    {
		
		String audiotext1 = "//*[@id='audio-row-0']/div[1][";
		String audiotext2 = "]/div/div/div";
	 
	       String AudioText =  AudioSubComponentStatsText.get(i).getText();
	       System.out.print("Audio sub component "+(i+1)+"  statistics below:");
	       System.out.println(AudioText);
	
    }}
	
	public void PADSubComponentsLeftandRightStatsAlarmsAndText(WebDriver driver, int index) {
		
	
		
		
		//int PADTextsSize = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-1')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]")).size();
		
	List<WebElement> PADSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
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
		
	List<WebElement> DATASubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'data-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
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
       
      // System.out.println(Audio1Stats);
	    
//	       System.out.print("Audio sub component "+(i+1)+"  statistics below: "+"  ");
	       System.out.println(" "+ Audio1Stats);
       
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
	System.out.println("padSubComponentsColorsandStats Method ::");
//	Thread.sleep(1000);

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
  


//15/10/2019  - clicking on overall silence buttons and changing settings - works well

public void OverallAudioSilenceSettings(WebDriver driver, int index) throws InterruptedException{
	System.out.println("OverallAudioSilenceSettings Method ::");
	
	    	  String  audioxpath1="//*[@id='silence-row']/div[";
	    	  String audioxpath2="]/div/div[1]/div/div[2]/button";
	    	  String audioSettingButton=audioxpath1+index+audioxpath2;
	    	  WebElement audiobutton=driver.findElement(By.xpath(audioSettingButton));
	    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	    	  executor.executeScript("arguments[0].scrollIntoView(true);", audiobutton);
	    	  executor.executeScript("arguments[0].click();", audiobutton);
	    	  //document.getElementById('silence-row')
	    	  driver.findElement(By.xpath("//*[@id='audiothreshold']")).clear();
	    	  	driver.findElement(By.xpath("//*[@id='audiothreshold']")).sendKeys("-1");
	    	  	Thread.sleep(500);
	    	  	driver.findElement(By.xpath("//*[@id='audiotimeout']")).clear();
	    	  	driver.findElement(By.xpath("//*[@id='audiotimeout']")).sendKeys("1");
	    	  	Thread.sleep(500);
	    	  	driver.findElement(By.xpath("//button[@id='btn_save']")).click();
	    	  	Thread.sleep(5000);
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
	    	  //document.getElementById('silence-row')
	    	  driver.findElement(By.xpath("//*[@id='audiothreshold']")).clear();
	    	  	driver.findElement(By.xpath("//*[@id='audiothreshold']")).sendKeys(audioVolume);
	    	  	Thread.sleep(500);
	    	  	driver.findElement(By.xpath("//*[@id='audiotimeout']")).clear();
	    	  	driver.findElement(By.xpath("//*[@id='audiotimeout']")).sendKeys(audioTimeout);
	    	  	Thread.sleep(500);
	    	  	driver.findElement(By.xpath("//button[@id='btn_save']")).click();
	    	  	Thread.sleep(5000);
}



public void OverallPADSilenceSettings(WebDriver driver, int index) throws InterruptedException{
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
	  	driver.findElement(By.xpath("//*[@id='padtimeout']")).sendKeys("1");
	  	Thread.sleep(500);
	  	driver.findElement(By.xpath("//*[@id='dlstimeout']")).clear();
	  	driver.findElement(By.xpath("//*[@id='dlstimeout']")).sendKeys("1");
	  	Thread.sleep(500);
	  	driver.findElement(By.xpath("//*[@id='mottimeout']")).clear();
	  	driver.findElement(By.xpath("//*[@id='mottimeout']")).sendKeys("1");
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


		
public void silencePageInputsAndAlarms(WebDriver driver) throws InterruptedException {

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
   	AudioSubComponentsColorsandStats(driver,i);
   	OverallPADSilenceSettings(driver,i,PadTimeOut,DlsTimeOut,MotTimeOut);
   	padSubComponentsColorsandStats(driver,i);
//   	padSubComponentsColorsandStats2(driver,i);
   	OverallDATASilenceSettings(driver,i,motStallTimeOUT);
   	dataSubComponentsColorsandStats(driver,i);
   	CapturingAudioPASDATAAlarmsColor(driver,i);
   	
   	
   
  

	 }
	}
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
   	OverallPADSilenceSettings(driver,i);
  	padSubComponentsColorsandStats(driver,i);
   //	padSubComponentsColorsandStats2(driver,i);
//   	CaptureAllSilenceAlarmsColor(driver);

	 }
	}

//works well.Only captures audio sub component alarm numbers and colours of one input at a time. No title captured but works well insilencePageInputsAndAlarms 

public void AudioComponentsColorsV(WebDriver driver, int index) 
{

System.out.println();
  boolean bFlag  = false;
  int rowvalue=index-1;
  
List<WebElement> AudioSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));

int Titlesize1 = AudioSubComponents.size();

System.out.println("Sub Audio Components "+"(total L and R alarms for the input):" +Titlesize1);


List<WebElement> AudioSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'audio-row-"+rowvalue+"')]//*[@class='col-md-2']//*[contains(@class ,'card card-stats')]"));
int Titlesize = AudioSubComponentStatsText.size();
System.out.println("Audio Sub components for the input : "+Titlesize);


 
for(int i = index;i<=Titlesize;i++)	
 {
   
  int retryCount=0;
  while(retryCount<2)
	{
      try {


       
    	  String  audioxpath1="//*[@id='audio-collapse-"+rowvalue+"']/div/div/div[";
    	  String audioxpath2="]/div/div/div/div/div[1]/div[1]/i";
    	  String audiostatus=driver.findElement(By.xpath(audioxpath1+i+audioxpath2)).getAttribute("class");
       
       
     
 	if (audiostatus.contains("danger"))
 				
 	    {
 		System.out.println(audiostatus+" is in Red ");
			bFlag = false;
			break ;
 				
 		}
 	
 	else if(audiostatus.contains("warning"))
 				
 		{
 		System.out.println(audiostatus+" is in Orange ");
			bFlag = false;
			break ;
 						
 		} 
 	else if(audiostatus.contains("success"))
 		{
 					
 		System.out.println(audiostatus+" is in Green ");
			bFlag = false;
			break ;
 		}
 					
 	else if(audiostatus.contains("default"))
 		{
 						
 		System.out.println(audiostatus+" is in Grey ");
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
//			Thread.sleep(1000);
        }
      catch(Exception exp) {
			exp.getStackTrace();
        }
	}
 }
}
  


public void padSubComponentsColorsandStats2(WebDriver driver, int index) 
{


boolean bFlag  = false;
int rowvalue=index-1;

List<WebElement>PADSubComponents =driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]"));


//div[starts-with(@id,'pad-row-0')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'fa fa-circle fa-fw icon')]
int Titlesize1 = PADSubComponents.size();

System.out.println("Sub PAD Components "+"(total L and R alarms for the input):" +Titlesize1);


List<WebElement> PADSubComponentStatsText = driver.findElements(By.xpath("//div[starts-with(@id,'pad-row-"+rowvalue+"')]//*[@class='col-lg-2 col-md-4 col-sm-4']//*[contains(@class ,'card card-stats')]"));
int Titlesize = PADSubComponentStatsText.size();
System.out.println("PAD Sub components for the input : "+Titlesize);

for(int i = index;i<=Titlesize;i++)	
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
//		Thread.sleep(1000);
    }
  catch(Exception exp) {
		exp.getStackTrace();
    }
}}}

//05/11/2019 - To pass Audio Threshold settings to individual audio services and capture individual Audio Service Labels

public void individualSilenceSettings(WebDriver driver, int index) throws InterruptedException {
	
	int rowvalue=0;
	
	
	List<WebElement>individualAudioSilenceSettings = driver.findElements(By.xpath("//*[@id='audio-collapse-0']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));
	int Titlesize = individualAudioSilenceSettings.size();
	System.out.println("individualSilenceSettings : "+Titlesize);
	
	for(int i = index;i<=Titlesize;i++)	
	 {
	   
//	  int retryCount=0;
//	  while(retryCount<2)
//		{
//	      try {
		
		//"//*[@id='pad-collapse-"+rowvalue+"']/div/div/div["
	    	
	    	  String a = "//*[@id='audio-collapse-"+rowvalue+"";
	    	  String b = "']/div/div/div[";
	    	  String c = "]/div/div[2]/div/button";
	    	  
	    	  String a1 = "//*[@id='audio-collapse-"+rowvalue+"";
	    	  String b1 = "']/div/div/div[";
	    	  String c1 = "]/div/div[2]/div";
	    	  
	    	  String individualAudioSilenceSettingsButton1 = a1+b1+i+c1;
		    String value=	 driver.findElement(By.xpath(individualAudioSilenceSettingsButton1)).getText();
		    System.out.println("Audio Service Lables :: "+value);
	    	 
	    	 String individualAudioSilenceSettingsButton = a+b+i+c;
	    	 driver.findElement(By.xpath(individualAudioSilenceSettingsButton)).click();
	    	// driver.findElement(By.xpath(a+b+i+c)).click();
	    	 
	    	 driver.findElement(By.xpath("//*[@id='audiothreshold']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='audiothreshold']")).sendKeys("-1");
	    	 driver.findElement(By.xpath("//*[@id='audiotimeout']")).clear();
	    	 driver.findElement(By.xpath("//*[@id='audiotimeout']")).sendKeys("1");
	    	 driver.findElement(By.xpath("//*[@id='btn_save']")).click();
	    	 Thread.sleep(100);
	    	 //driver.navigate().refresh();
	    	 
	      }}
	    	  
	
//15/11/2019 - To pass Audio Threshold settings to individual audio services and capture individual PAD Service Labels
	      
	public void individualPADSilenceSettings(WebDriver driver,int index) throws InterruptedException {
		
		int rowvalue=0;
		
		
		List<WebElement>individualPADSilenceSettings = driver.findElements(By.xpath("//*[@id='pad-collapse-0']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));
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
			    String value=	 driver.findElement(By.xpath(individualpadSilenceSettingsButton1)).getText();
			    System.out.println("PAD Service Lables :: "+value);
		    	
		    	  
		    	  
		    	  String individualPADSilenceSettingsButton = d+e+i+f;
		    	//  driver.findElement(By.xpath(individualPADSilenceSettingsButton)).click();
		    	  //Thread.sleep(100);
		    	  WebElement PADSettings1 = driver.findElement(By.xpath(individualPADSilenceSettingsButton));
		    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
		    	  executor.executeScript("arguments[0].scrollIntoView(true);",PADSettings1);
		    	  executor.executeScript("arguments[0].click();",PADSettings1);
		    	  
		    	 
		    	 driver.findElement(By.xpath("//*[@id='padtimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='padtimeout']")).sendKeys("-1");
		    	 driver.findElement(By.xpath("//*[@id='dlstimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='dlstimeout']")).sendKeys("1");
		    	 driver.findElement(By.xpath("//*[@id='mottimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='mottimeout']")).sendKeys("1");
		    	 driver.findElement(By.xpath("//*[@id='btn_save']")).click();

		    	 Thread.sleep(1000);
		    	 
		 }}
		
	//	30/11/19 - trying to send data from external source
	
	public void individualPADSilenceSettingsS(WebDriver driver,int index, String padtimeout,String dlstimeout, String mottimeout) throws InterruptedException {
		
		int rowvalue=0;
		
		
		List<WebElement>individualPADSilenceSettings = driver.findElements(By.xpath("//*[@id='pad-collapse-0']//*[@class='btn btn-sm btn-default btn-fab btn-icon btn-round btn-configedit']"));
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
			    String value=	 driver.findElement(By.xpath(individualpadSilenceSettingsButton1)).getText();
			    System.out.println("PAD Service Lables :: "+value);
		    	
		    	  
		    	  
		    	  String individualPADSilenceSettingsButton = d+e+i+f;
		    	//  driver.findElement(By.xpath(individualPADSilenceSettingsButton)).click();
		    	  //Thread.sleep(100);
		    	  WebElement PADSettings1 = driver.findElement(By.xpath(individualPADSilenceSettingsButton));
		    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
		    	  executor.executeScript("arguments[0].scrollIntoView(true);",PADSettings1);
		    	  executor.executeScript("arguments[0].click();",PADSettings1);
		    	  
		    	 
		    	 driver.findElement(By.xpath("//*[@id='padtimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='padtimeout']")).sendKeys(padtimeout);
		    	 driver.findElement(By.xpath("//*[@id='dlstimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='dlstimeout']")).sendKeys(dlstimeout);
		    	 driver.findElement(By.xpath("//*[@id='mottimeout']")).clear();
		    	 driver.findElement(By.xpath("//*[@id='mottimeout']")).sendKeys(mottimeout);
		    	 driver.findElement(By.xpath("//*[@id='btn_save']")).click();

		    	 Thread.sleep(1000);
		    	 


}}}


	
	       
	    	  
	




	     


	      
       
          
         



		
	
	



