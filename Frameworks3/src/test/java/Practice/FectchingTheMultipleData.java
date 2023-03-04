package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//data formatter is used to fecth the data from the excel and print data on console as it is

public class FectchingTheMultipleData {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		
		FileInputStream fes =new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fes);
		Sheet sheet = workbook.getSheet("Campaign");
		for(int i =0;i<=sheet.getLastRowNum();i++) {
			Row row =sheet.getRow(i);
			for(int j =0;j<=sheet.getLastRowNum();j++)	{
				Cell cell=row.getCell(j);
				DataFormatter dataFormater=new DataFormatter();
				String data= dataFormater.formatCellValue(cell);
				System.out.println(data);
			}
			
		}
	}

}
