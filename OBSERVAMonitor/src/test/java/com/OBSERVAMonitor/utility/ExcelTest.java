
package com.OBSERVAMonitor.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelTest {

	ExcelReader excelReader = null;
	
	@BeforeMethod
	public void initialize() throws InvalidFormatException{
		excelReader = new ExcelReader("/testData.xlsx");
		excelReader.prepareRowMap("Test Name");
	}
	
	@Test
	public void readExcel() {
		int rows = excelReader.getRowCount("createUser");
		List<String> columnData = excelReader.getColumnData("createCustomer", 0);
		HashMap<String, String> rowData = excelReader.getRowData("createCustomer", 1);
		System.out.println("Rows : " + rows);
		columnData.forEach(name -> System.out.println(name));
		rowData.forEach((k,v)->System.out.println(k + " : " + v));
	}
	
	@Test
	public void getRowFromMap() {
		Map<String, String> rowFromMap = excelReader.getRowFromMap("Add User");
		rowFromMap.forEach((k,v)->System.out.println(k + " : " + v));
	}
	
	@AfterMethod
	public void tearDown(){
		excelReader.closeWorkBook();
	}
}
