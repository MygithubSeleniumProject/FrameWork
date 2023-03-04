package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	
	/*
	 * 
	 * this method is used to fecth data from excel
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable, IOException{
	
	FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
	   Workbook book=WorkbookFactory.create(fes);
	  Sheet sheet= book.getSheet(sheetName);
	  Row row = sheet.getRow(rowNum)  ;
	  Cell cell = row.getCell(cellNum);
	  String Value = cell.getStringCellValue();
	return Value;
	
	
}
/*Fectching sata by using dataFormatter
 * 
 * 
 * @author=santoshi
 * 
 * 
 */
	  /* DataFormatter format=new DataFormatter();
	String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	return data;*/
	public String getExcelUsingDataFormater(String sheetName,int rowNum,int cellNum) throws Throwable, IOException{
		
		FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
		   Workbook book1=WorkbookFactory.create(fes);
		   DataFormatter format=new DataFormatter();
			String data = format.formatCellValue(book1.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
			return data;
	
	
	
}
}
