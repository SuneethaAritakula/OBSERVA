package com.OBSERVAMonitor.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public Workbook workbook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	private String path;
	private Map<String, Map<String, String>> rowsMap = null;

	private static Logger LOGGER = Logger.getLogger(ExcelReader.class.getName());

	public ExcelReader(String path) throws InvalidFormatException {
		LOGGER.debug(path);
		try {
			this.path = Paths.get("src","test","resources",path).toString();
			fis = new FileInputStream(this.path);
			
			if (this.path.endsWith(".xlsx")) {
				workbook = (XSSFWorkbook) WorkbookFactory.create(fis);
			} else {
				workbook = (HSSFWorkbook) WorkbookFactory.create(fis);
			}
			fis.close();
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
	}

	/**
	 * Returns row count of the given sheet.
	 * 
	 * @param sheetName
	 * @return
	 */
	public int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);

		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			return number;
		}

	}

	/**
	 * Returns column data by providing column number.
	 * 
	 * @param sheetName
	 * @param colNum
	 * @return
	 */
	public List<String> getColumnData(String sheetName, int colNum) {
		List<String> list = null;
		try {

			list = new ArrayList<String>();
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return list;

			sheet = workbook.getSheetAt(index);
			list = this.getEntireColumnCellValues(sheet, colNum);
			return list;

		} catch (RuntimeException e) {
			if (e.getMessage() != null && e.getMessage().isEmpty()) {
				LOGGER.error(e.getMessage());
			} else {
			}
			return list;
		}

	}

	/**
	 * Returns column data by providing column name.
	 * 
	 * @param sheetName
	 * @param colName
	 * @return
	 */
	public List<String> getColumnData(String sheetName, String colName) {
		List<String> list = null;
		try {

			list = new ArrayList<String>();
			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return list;

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				return list;

			int colNum = 0;
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					colNum = i;
				}
			}
			if (colNum == -1)
				return list;

			list = this.getEntireColumnCellValues(sheet, colNum);
			return list;

		} catch (RuntimeException e) {
			if (e.getMessage() != null && e.getMessage().isEmpty()) {
				LOGGER.error(e.getMessage());
			} else {
			}
			return list;
		}
	}

	/**
	 * Returns the data of the a cell by provide colname and rownum
	 * 
	 * @param sheetName
	 * @param colName
	 * @param rowNum
	 * @return
	 */
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				if (headerRow.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					return getCellValue(row.getCell(i));
				}
			}
			return null;

		} catch (RuntimeException e) {
			if (e.getMessage() != null && e.getMessage().isEmpty()) {
				LOGGER.error(e.getMessage());
			} else {
				LOGGER.error("row " + rowNum + " or column " + colName + " does not exist in file");
			}
			return "row " + rowNum + " or column " + colName + " does not exist in file";
		}
	}

	/**
	 * Returns the data of the a cell by provide colnum and rownum
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 */
	public String getCellData(String sheetName, int rowNum, int colNum) {
		try {
			if (rowNum <= 0)
				return "";

			int index = workbook.getSheetIndex(sheetName);

			if (index == -1)
				return "";

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";

			cell = row.getCell(colNum);

			return getCellValue(cell);

		} catch (RuntimeException e) {
			if (e.getMessage() != null && e.getMessage().isEmpty()) {
				LOGGER.error(e.getMessage());
			} else {
				LOGGER.error("row " + rowNum + " or column " + colNum + " does not exist  in file");
			}
			return "row " + rowNum + " or column " + colNum + " does not exist  in file";
		}
	}

	/**
	 * Finds whether sheet exists or not
	 * 
	 * @param sheetName
	 * @return
	 */
	public boolean isSheetExist(String sheetName) {

		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

	/**
	 * Returns number of columns in a sheet
	 * 
	 * @param sheetName
	 * @return
	 */
	public int getColumnCount(String sheetName) {
		if (!isSheetExist(sheetName))
			return -1;

		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		if (row == null)
			return -1;

		return row.getLastCellNum();

	}

	/**
	 * Returns row number by providing colname and cellvalue
	 * 
	 * @param sheetName
	 * @param colName
	 * @param cellValue
	 * @return
	 */
	public int getCellRowNum(String sheetName, String colName, String cellValue) {
		for (int i = 2; i <= getRowCount(sheetName); i++) {
			if (getCellData(sheetName, colName, i).equalsIgnoreCase(cellValue)) {
				return i;
			}
		}
		return -1;

	}

	/**
	 * Returns Row data in a sheet.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	public HashMap<String, String> getRowData(String sheetName, int rowNum) {
		HashMap<String, String> hashMap = null;
		try {

			hashMap = new HashMap<String, String>();
			if (rowNum <= 0)
				return hashMap;

			int index = workbook.getSheetIndex(sheetName);
			if (index == -1)
				return hashMap;

			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum);
			Row headerRow = sheet.getRow(0);

			if (headerRow == null || row == null)
				return hashMap;

			for (int i = 0; i < headerRow.getLastCellNum(); i++) {
				hashMap.put(getCellValue(headerRow.getCell(i)), getCellValue(row.getCell(i)));
			}
			return hashMap;

		} catch (RuntimeException e) {
			if (e.getMessage() != null && e.getMessage().isEmpty()) {
				LOGGER.error(e.getMessage());
			} else {
				LOGGER.error("row " + rowNum + " does not exist  in file");
			}
			return hashMap;
		}
	}

	/**
	 * Returns Row data as Map.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	public void prepareRowMap(String key) {
		rowsMap = new HashMap<String, Map<String, String>>();
		String keyValue = "";
		Iterator<Sheet> sheetIterator;
		String executionStatus="";
		try {
			
			sheetIterator = workbook.sheetIterator();
			while(sheetIterator.hasNext()){

//			int index = workbook.getSheetIndex(sheetName);
//
//			sheet = workbook.getSheetAt(index);
				Sheet sheet = sheetIterator.next();

			Row headerRow = sheet.getRow(0);

			for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
				Map<String, String> rowMap = new HashMap<String, String>();
				row = sheet.getRow(i);
				executionStatus = getCellData(sheet.getSheetName(), "Execution Status", i);
				if(executionStatus.equalsIgnoreCase("Yes")) {
				keyValue = getCellData(sheet.getSheetName(), key, i);
				for (int j = 0; j < headerRow.getLastCellNum(); j++) {
					rowMap.put(getCellValue(headerRow.getCell(j)), getCellValue(row.getCell(j)));
				}
				rowsMap.put(keyValue, rowMap);
			}
			}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns Row from the Map by providing key
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getRowFromMap(String key) {
		return rowsMap.get(key);
	}

	/**
	 * Returns the cell data as string
	 * 
	 * @param cell
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private String getCellValue(Cell cell) {

		if (cell == null)
			return "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			return cell.getStringCellValue().trim();
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			double d = cell.getNumericCellValue();
			long longValue = (new Double(d)).longValue();
			String cellText = String.valueOf(longValue);
			if (DateUtil.isCellDateFormatted(cell)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(DateUtil.getJavaDate(d));
				cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
				cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;

			}
			return cellText;
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			return "";
		else
			return String.valueOf(cell.getBooleanCellValue());

	}

	/**
	 * Returns column cell data as a list by providing colnum
	 * 
	 * @param sheet
	 * @param colNum
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private List<String> getEntireColumnCellValues(Sheet sheet, int colNum) {

		List<String> list = new ArrayList<String>();
		for (Row row : sheet) {
			if (row.getRowNum() != 0) {
				cell = (XSSFCell) row.getCell(colNum);
				if (cell != null) {
					if (cell.getCellType() == Cell.CELL_TYPE_STRING)
						list.add(cell.getStringCellValue());
					else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
							|| cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

						String cellText = String.valueOf(cell.getNumericCellValue());
						if (DateUtil.isCellDateFormatted(cell)) {
							double d = cell.getNumericCellValue();

							Calendar cal = Calendar.getInstance();
							cal.setTime(DateUtil.getJavaDate(d));
							cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
							cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/"
									+ cellText;
						}

						list.add(cellText);
					} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
						list.add("");
					else
						list.add(String.valueOf(cell.getBooleanCellValue()));
				}
			}
		}
		return list;
	}

	/**
	 * creates cell data.
	 * 
	 * @param sheetName
	 * @param colName
	 * @param rowNum
	 * @param data
	 * @return
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public boolean setCellData(String sheetName, String colName, int rowNum, String data)
			throws InvalidFormatException, IOException {
		try {
			if (rowNum <= 0)
				return false;
			int index = workbook.getSheetIndex(sheetName);
			int colNum = -1;
			if (index == -1)
				return false;
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName))
					colNum = i;
			}
			if (colNum == -1)
				return false;
			sheet.autoSizeColumn(colNum);
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				row = sheet.createRow(rowNum - 1);
			cell = row.getCell(colNum);
			if (cell == null)
				cell = row.createCell(colNum);
			cell.setCellValue(data);
			fileOut = new FileOutputStream(path);
			workbook.write(fileOut);
			fileOut.close();
			fis = new FileInputStream(path);
			this.workbook = (XSSFWorkbook) WorkbookFactory.create(fis);

		} catch (RuntimeException e) {
			LOGGER.info(e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * closes the workbook
	 */
	public void closeWorkBook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
