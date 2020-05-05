package excel;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel_Read {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vijay Kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		FileInputStream fl = new FileInputStream("C:\\Users\\Vijay Kumar\\Documents\\first.xls");
		HSSFWorkbook wb =new HSSFWorkbook(fl);
		HSSFSheet s = wb.getSheet("Sheet1");
		
		Iterator<Row> rowIt = s.iterator();

		
		while (rowIt.hasNext()) {
			WebDriver driver = new ChromeDriver();
			String str = rowIt.next().getCell(0).getStringCellValue();
			driver.get("http://www.google.co.uk");
			driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys(str + Keys.ENTER);
			
	
			Thread.sleep(6000);
			
			driver.close();
		}
		
		wb.close();
		System.out.println("Closing Window");
		
	}

}
