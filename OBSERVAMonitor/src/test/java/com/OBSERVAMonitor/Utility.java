package com.OBSERVAMonitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.config.Property;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String environmentconfigfilepath = "EnvironmentConfig/Input.properties";

	public String getValueForKeyString(String key) throws FileNotFoundException, IOException {
	Properties configurationProperties = new Properties();
	configurationProperties.load(new FileInputStream(new File(environmentconfigfilepath)));
	return configurationProperties.getProperty(key);
	
	
	
}
	
	//public void SilencePageAlarms() {
		
	
	//}

	public static void 
		
	captureScreenshot(WebDriver driver,String screenshotName)
	{
	 
	try 
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
	
	System.out.println("Screenshot taken");
	} 
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} }

	}

//call the the above method in this format - Utility.captureScreenshot(driver,"name of screenshot");*/