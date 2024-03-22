package com.zigwheels.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static String[][] readExcelData() {
        //READING DATA FROM THE FILE
		String[][] data = null;
		File file;
		FileInputStream fis = null;
		XSSFWorkbook workBook = null;

		file = new File("C:\\Users\\Sam jehova\\eclipse-workspace\\HackathonProject\\src\\test\\resources\\TestData\\BikeBrand.xlsx");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
        // TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workBook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				String value = cell.getStringCellValue();
                //System.out.println(value);
				data[i - 1][j] = value;
				//System.out.println(data[i - 1][j]);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ReadExcelFile.readExcelData();

	}

}
