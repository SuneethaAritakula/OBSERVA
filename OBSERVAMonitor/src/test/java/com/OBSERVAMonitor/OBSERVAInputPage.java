package com.OBSERVAMonitor;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class OBSERVAInputPage extends BaseTest {
	
/*	@Test(groups = "Regression Test")

	public void lnkInput() {

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		IP.INPUT();
	}

	@Test (groups = "Regression Test")

	public void btnToAddInput() throws InterruptedException{

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Thread.sleep(1000);
		IP.btnToAddInput();


	}

	@Test (groups = "Regression Test")

	public void SelectInputsFromDropDown() throws InterruptedException {

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Thread.sleep(1000);
		IP.SelectInputsFromDropDown();

	}
    
	@Test (groups = "Regression Test")
	
	public void SelectInputs() throws InterruptedException{

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Thread.sleep(1000);
		IP.SelectInputs();
	}*/
    
    /*Select Input = new Select(driver.findElement(By.xpath("//*[@id=\'select_SourceType\']")));
		Input.selectByIndex(0);

		for (int i = 0; i<=5; i++)

		{

			CommonMethods.readandwritedata(driver, "");


		}
		//Input.selectByVisibleText("FEP");
		//Thread.sleep(500);

		FileInputStream file = new FileInputStream("");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("");*/
		

	
	@Test
	public void EDI1() {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);

		IP.INPUT();
		IP.btnToAddInput();
		Map<String, String> testData = excelReader.getRowFromMap("EDI1");
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}
	
	 @Test
	public void EDI2() {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);

		IP.INPUT();
		IP.btnToAddInput();
		Map<String, String> testData = excelReader.getRowFromMap("EDI2");
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}

	@Test
	public void EDI3() {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		IP.INPUT();
		IP.btnToAddInput();

		Map<String, String> testData = excelReader.getRowFromMap("EDI3");

		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}


   @Test

	public void EDI4() {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);

		Map<String, String> testData = excelReader.getRowFromMap("EDI4");
		IP.INPUT();
		IP.btnToAddInput();
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}

    @Test

	public void EDI5() {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);

		Map<String, String> testData = excelReader.getRowFromMap("EDI5");
		IP.INPUT();
		IP.btnToAddInput();
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}

	@Test

	public void EDI6() {

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Map<String, String> testData = excelReader.getRowFromMap("EDI6");
		IP.INPUT();
		IP.btnToAddInput();
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}
	
	@Test

	public void EDI7() {

		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Map<String, String> testData = excelReader.getRowFromMap("EDI7");
		IP.INPUT();
		IP.btnToAddInput();
		IP.EDIInputs(driver, testData.get("DisplayName"), testData.get("Address"), testData.get("Port"),
				testData.get("SourceType"));

	}
	
	

	
	@Test
	public void RFInput1() throws InterruptedException {
		InputPage IP = PageFactory.initElements(driver, InputPage.class);
		Map<String, String> testData = excelReader.getRowFromMap("RFInput1");
		if (testData != null) {
			IP.INPUT();
			IP.RFInputs(driver, testData.get("DisplayName"), testData.get("Frequency"), testData.get("SourceType"));
		} else {
			System.out.println("Please mark testcase as Yes in testData excelsheeet");
		}

	}

@Test
public void RFInput2() throws InterruptedException {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	Map<String,String> testData = excelReader.getRowFromMap("RFInput2");
	IP.INPUT();
	IP.RFInputs(driver,testData.get("DisplayName"),testData.get("Frequency"),testData.get("SourceType"));
	
}

@Test
public void FEP1() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP1");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));
}

@Test
public void FEP2() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP2");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));

}

@Test
public void FEP3() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP3");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));

}

@Test
public void FEP4() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP4");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));

}

@Test
public void FEP5() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP5");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));
}

@Test
public void FEP6() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP6");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));

}

@Test
public void FEP7() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("FEP7");
IP.INPUT();
IP.FEPInputs(driver,testData.get("DisplayName"),testData.get("Address"),testData.get("Port"),testData.get("SourceType"));

}


@Test
public void ETINI1() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("ETINI1");
IP.INPUT();
IP.ETINIInputs(driver,testData.get("DisplayName"),testData.get("FilePath"),testData.get("SourceType"));

}

@Test
public void ETINI2() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("ETINI2");
IP.INPUT();
IP.ETINIInputs(driver,testData.get("DisplayName"),testData.get("FilePath"),testData.get("SourceType"));

}


@Test
public void ETINI3() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("ETINI3");
IP.INPUT();
IP.ETINIInputs(driver,testData.get("DisplayName"),testData.get("FilePath"),testData.get("SourceType"));

}

@Test
public void RadioscapeETICCard0() throws InterruptedException {
InputPage IP = PageFactory.initElements(driver, InputPage.class);
Map<String, String> testData = excelReader.getRowFromMap("RadioscapeETICCard0");
IP.INPUT();
IP.ETIC(driver,testData.get("DisplayName"),testData.get("InputStream"),testData.get("SourceType"));
}

//-----------------------------------------------------------------------------------------------------------------------//
	
	//@Test
	 public void txtError() throws InterruptedException{
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
	 //IP.InputExistsError();
	 IP.txtError();
	 
	}
	
	@Test(priority = 11)
	 
	 public void Continuitypage() throws InterruptedException{
		
			
		 InputPage IP = PageFactory.initElements(driver, InputPage.class);
		 Thread.sleep(1000);
			
		 IP.Continuitypage();
		 
		 }
	
	@Test(priority = 12)
	 
	 public void ContentPage() throws InterruptedException{
		
			
		 InputPage IP = PageFactory.initElements(driver, InputPage.class);
		 Thread.sleep(1000);
		 IP.ContentPage();
		 
		 }
	
	@Test(priority = 13)
		
	 public void SilencePage() throws InterruptedException{
		
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
		IP.SilencePage();
	 }
		
	@Test(priority = 14)
	
	 public void ReconfigPage() throws InterruptedException{
		
			
	 InputPage IP = PageFactory.initElements(driver, InputPage.class);
	 Thread.sleep(1000);
		IP.ReconfigPage();
	}
		
//	@Test(priority = 14)
	public void btnEditInput() throws InterruptedException {
		
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	Thread.sleep(1000);
	IP.btnEditInput();
	
	}
	
//	@Test(priority = 15)
	public void lblRenameInput() throws InterruptedException {
	InputPage IP = PageFactory.initElements(driver, InputPage.class);
	Thread.sleep(1000);
	IP.lblRenameInput();
	
	driver.navigate().back();
	driver.navigate().refresh();
	}}
	
	
		 
		

		
		
		
		
		
		
		


