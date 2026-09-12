package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class OrangeHrmTestCase2 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1"); // FIXED - Capital S
		
		String Browser = sh.getRow(1).getCell(0).getStringCellValue();
		String url = sh.getRow(1).getCell(1).getStringCellValue();
		String un = sh.getRow(1).getCell(2).getStringCellValue();
		String pw = sh.getRow(1).getCell(3).getStringCellValue();
		
		WebDriver driver = null;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pw);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); // FIXED - old xpath had spaces
		
		wb.close();
		fis.close();
	}
}
