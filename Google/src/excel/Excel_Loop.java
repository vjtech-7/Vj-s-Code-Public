package excel;


import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.sql.Driver;

import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_Loop {

	/*public static String result()
	{
		String res_str;
		
		char[] arr = new char[] {' ',' ',' ',' '};
	
		res_str.getChars(res_str.indexOf("(")+1, res_str.indexOf("c")-3, arr, 0);
		
		String res_str1 = new String(arr);
		
	}*/
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vijay Kumar\\Downloads\\Chromedriver_win32\\chromedriver.exe");
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");;
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Sheet1");
		//System.out.println("Row"+row);
		int i = s.getLastRowNum()-s.getFirstRowNum();
		for (int j=0; j<=i; j++)
		{
			WebDriver driver = new ChromeDriver();
			Row row = s.getRow(j);
			String str = row.getCell(0).getStringCellValue();
			driver.get("http://www.google.co.uk");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(str + Keys.ENTER);
			WebElement results = driver.findElement(By.xpath("//div[@id='result-stats']"));
		    String str1 = results.getText();
		    
		    char[] arr = new char[] {' ',' ',' ',' '};
			
			str1.getChars(str1.indexOf("(")+1, str1.indexOf("c")-3, arr, 0);
			
			String res_str1 = new String(arr);
			Cell cell = row.createCell(2);
		    cell.setCellValue(res_str1);
		    Cell cell1 = row.createCell(4);
		    float f = Float.valueOf(res_str1);
		    	if (f<1)
		    	{
		    		
		    		cell1.setCellValue(true);
		    	} else
		    		cell1.setCellValue(false);
		    	
		    FileOutputStream fos = new FileOutputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xlsx");
		    wb.write(fos);
		    
			//Thread.sleep(2000);
			driver.close();
			
		}
		
		wb.close();
		
	}

}
