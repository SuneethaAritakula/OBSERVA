package com.OBSERVAMonitor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OBSERVASilencePage extends BaseTest {
	
 //  @Test (groups = "Regression Test")	

	public void SilencePage() throws InterruptedException { 

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
		logger.info("SilencePage launched successfully");

		SP.SilencePageLeftTab();
		Thread.sleep(1000);
	}

	//	@Test (groups = "integration Test") // This method works well capturing the first input. 2nd input throws stale element exception.

	public void subComponentAlarms() throws InterruptedException {

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);

		int index = 1;

		SP.AudioSubComponentAlarms(driver, index); //This method captures left and right alarms for audio services for a given input. works well
		SP.PADSubComponentAlarms(driver, index); //This method captures left and right alarms for pad services for a given input. works well
		SP.DATASubComponentAlarms(driver, index);//This method captures data alarm. works well



	}

	//	@Test (groups = "Regression Test")

	public void OverallInputAlarms() throws InterruptedException {

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
		Thread.sleep(5000);
		SP.SilencePageLeftTab();
		Thread.sleep(2000);

		int index = 1;
		// SP.CapturingAudioPASDATAAlarmsColor(driver, index); // works well. Captures Audio, pad and data overall alarms with title
		SP.captureSilenceAlarmComponents(driver, 0); //works well. Captures overall alarms of Audio, pad and Data for 1st input only
		
	}

//	@Test (groups = "Regression Test")

	public void SubComponentAlarms() throws InterruptedException {

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
		Thread.sleep(1000);

		int index = 1;
		SP.SilencePageLeftTab();

		//SP.AudioSubComponentsLeftandRightStatsAlarmsAndText(driver, index);//works well
		//SP.PADSubComponentsLeftandRightStatsAlarmsAndText(driver, index); //works well.Captures service names of pad subcomponents for 1 input at a time.
		// SP.DataSubComponentsLeftandRightStatsAlarmsAndText(driver, index);// capturing number of inputs but not the service name

		//	SP.AudioSubComponentAlarms(driver, index); //works well. Captures L & R alarm colors
		//	SP.PADSubComponentAlarms(driver, index);//works well. Captures L & R alarm colors
		//	SP.DATASubComponentAlarms(driver, index);//works well


		//SP.AudioComponentsColorsV(driver, index);//works well.Only captures audio sub component alarm numbers and colours of one input at a time. No title captured but works well insilencePageInputsAndAlarms 
		// SP.AudioSubComponentsColorsandStatsS(driver, index);//Only captures alarm colours. Names of services is not captured. Throws stale element exception
		// SP.AudioSubComponentsColorsandStats(driver, index); //captures overall audio alarm and number of audio services and corresponding alarms. Title is not captured. Only if thye first input is grey or else throws NullPointer exception at if(!audiocolorStatus.equals("Grey"))
		// SP.padSubComponentsColorsandStats(driver,index); //with sleep - null pointer exception. without sleep overallpad alarm doesn't match with individual pad alarms
		// SP.dataSubComponentsColorsandStats(driver,index);//Only captures data sub component alarm colours of one input at a time only with thread.sleep which doesn't work well when run with overallSilenceSettings method
	
	}	




	@Test (groups = "Regression Test") //This method captures Inputs,alarms incl sub components for all the inputs available	

	public void OverallSilenceSettings() throws InterruptedException {
		Map<String, String> testData = excelReader.getRowFromMap("OverallSilenceSettings");
		String value = testData.get("InputRowValue");
		int inputRowValue=Integer.parseInt(value);

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
		Thread.sleep(1000);
		SP.SilencePageLeftTab();


//		SP.silencePageInputsAndAlarms(driver);
		System.out.println("-------------------------------------------------------------------");

		SP.silencePageInputsAndAlarms(driver,testData.get("AudioVolume"),testData.get("AudioTimeOut"),
				testData.get("PadTimeOut"),testData.get("DlsTimeOut"),testData.get("MotTimeOut"),testData.get("MOTStallTimeOUT"));

	//	SP.OverallAudioSilenceSettings(driver,inputRowValue,testData.get("AudioVolume"),testData.get("AudioTimeOut")); // This method is an example of test data being passed from an external source

	//	      SP.AudioSubComponentsColorsandStats(driver,inputRowValue);
		 
	//	     SP.OverallPADSilenceSettings(driver,inputRowValue,testData.get("PadTimeOut"),testData.get("DlsTimeOut"),testData.get("MotTimeOut"));
//		     SP.padSubComponentsColorsandStats(driver,inputRowValue);
////		    	padSubComponentsColorsandStats2(driver,i);
//	      SP.OverallDATASilenceSettings(driver,inputRowValue,testData.get("MOTStallTimeOUT"));
//		      SP.dataSubComponentsColorsandStats(driver,inputRowValue);
		      SP.CapturingAudioPADDATAAlarmsColor(driver,inputRowValue);
		
	
		 

	}


//	@Test (groups = "Regression Test")	
	public void individualSilenceSettings() throws InterruptedException { // works well. changes audio, pad and data silence threshold of each subcomponent and verifies the alarms with the heart symbol alarm
		int index = 1;

		SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
		Thread.sleep(1000);
		SP.SilencePageLeftTab();

	//	SP.individualSilenceSettings(driver, index);//passes Audio Threshold settings to individual audio services and capture individual Audio Service Labels
//		SP.individualPADSilenceSettings(driver, index);//passes PAD Threshold settings to individual audio services and capture individual Audio Service Labels
	//	SP.OverallDATASilenceSettings(driver, index);// passes DATA Threshold settings and capture service label. If DATA is grey for the first input, then throws NullPointer exception



	}
		
//	@Test

public void individualPADSilenceSettingsS() throws InterruptedException {
	
	Map<String, String> testData = excelReader.getRowFromMap("OverallSilenceSettings");
	String value = testData.get("InputRowValue");
	int inputRowValue=Integer.parseInt(value);
	
	SilencePage SP = PageFactory.initElements(driver, SilencePage.class);
	Thread.sleep(1000);
	SP.SilencePageLeftTab();
	
//	SP.individualPADSilenceSettingsS(driver,inputRowValue, testData.get("PadTimeOut"),testData.get("DlsTimeOut"),testData.get("MotTimeOut"));
	
	
}}


	
