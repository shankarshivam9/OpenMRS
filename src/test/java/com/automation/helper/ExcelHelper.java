package com.automation.helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {

	public static Object[][] getTestData() throws Exception {

		Object[][] data = null;
		File file = new File(
				"D:\\2023\\Automation\\Selenium\\Workplace_Apr\\OpenMRS\\src\\test\\resources\\OpenMRSLogin.xls");

		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");

		data = new Object[sheet.getPhysicalNumberOfRows() - 1][sheet.getRow(0).getPhysicalNumberOfCells()];

		for (int rowIndex = sheet.getFirstRowNum() + 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

			for (int colIndex = sheet.getRow(0).getFirstCellNum(); colIndex < sheet.getRow(0)
					.getLastCellNum(); colIndex++) {
				data[rowIndex - 1][colIndex] = sheet.getRow(rowIndex).getCell(colIndex).toString();
			}

			workbook.close();

		}
		return data;
	}
}
