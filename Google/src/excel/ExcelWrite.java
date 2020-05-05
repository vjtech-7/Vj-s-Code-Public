package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

///import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String args[]) throws IOException {
		
		FileInputStream xl = new FileInputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(xl);
		
		wb.createSheet("MySheet");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");
		wb.write(fos);
		wb.close();
		
		FileInputStream xl1 = new FileInputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");
		XSSFWorkbook wb1 = new XSSFWorkbook(xl1);
		XSSFSheet s = wb1.getSheet("MySheet");
		
		Row row = s.createRow(10);
		Cell cell = row.createCell(0);
		
		cell.setCellValue(10);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");
		wb1.write(fos1);
		
		wb1.close();
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
