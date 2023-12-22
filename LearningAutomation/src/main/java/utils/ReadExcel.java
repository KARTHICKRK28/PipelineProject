package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String fileLocation = "./test data/Login-Data.xlsx";
		XSSFWorkbook wfbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wfbook.getSheetAt(0);
		for (int i = 1; i <=2; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < 2; j++) {
				XSSFCell column = row.getCell(j);
				String stringCellValue = column.getStringCellValue();
				System.out.println(stringCellValue);
			}

		}
		wfbook.close();

	}
}
