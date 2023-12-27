package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider(/*indices= {1,2}*/parallel = !true)
	public String[][] getData() throws IOException{
		
		String[][] exceldata = ReadExcel.getExceldata();
		
		return exceldata;
		
	}
}
