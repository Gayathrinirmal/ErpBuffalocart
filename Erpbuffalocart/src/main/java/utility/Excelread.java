package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.erpbuffalocart.qa.constants.Constants;




public class Excelread {

	
	public String readExcel(String sheetName,int row1, int cell1) throws IOException {
		String value = null;
		String filePath =Constants.employeedetailsFile;
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row=sheet.getRow(row1);
		Cell cell= row.getCell(cell1);
		switch(cell.getCellType())
		{	
		case NUMERIC:
			value= String.valueOf(cell.getNumericCellValue());
	     break;
		case STRING:
			value= cell.getStringCellValue();
			break;
		}
		
		return value;
	
	}


	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	Excelread excelread = new Excelread();	
	//	String value=excelread.readExcel("Details",4,0);
	//	System.out.println(value);
	//}

}