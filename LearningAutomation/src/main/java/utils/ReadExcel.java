package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] getExceldata() throws IOException {
		// TODO Auto-generated method stub

		String fileLocation = "./test data/Login-Data.xlsx";
		XSSFWorkbook wfbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wfbook.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("Inclusive of Header :" + physicalNumberOfRows);
		System.out.println("No of rows:" + lastRowNum);
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Cells: " + lastCellNum);
		String[][] data=new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell column = row.getCell(j);
				DataFormatter dsf = new DataFormatter();
				String formatCellValue = dsf.formatCellValue(column);
				// String stringCellValue = column.getStringCellValue();
				//System.out.println(formatCellValue);
				data[i-1][j]=formatCellValue;
			}

		}
		wfbook.close();
		return data;

	}
}
