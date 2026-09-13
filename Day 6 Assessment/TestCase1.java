package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileInputStream fis_p = new FileInputStream("./src/test/resources/Day6_Assessment/TestCase1commondata.properties");
		Properties p = new Properties();
		p.load(fis_p);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String browser = p.getProperty("browser");
		
		FileInputStream fis_e = new FileInputStream("./src/test/resources/Day6_Assessment/TestCase1.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String mn = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String e_un = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String e_pwd = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		String role = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
		String ename = wb.getSheet("Sheet1").getRow(1).getCell(7).toString();
		String status = wb.getSheet("Sheet1").getRow(1).getCell(8).toString();
		String a_us = wb.getSheet("Sheet1").getRow(1).getCell(9).toString();
		String a_pwd = wb.getSheet("Sheet1").getRow(1).getCell(10).toString();
		wb.close();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", login);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.name("firstName")).sendKeys(fn);
		driver.findElement(By.name("middleName")).sendKeys(mn);
		driver.findElement(By.name("lastName")).sendKeys(ln);
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(e_un);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(e_pwd);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(e_pwd);
		
		WebElement save1 = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", save1);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(1500);
		
		WebElement roleDD = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		roleDD.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+role+"']")).click();
		Thread.sleep(1000);
		
		WebElement empName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		empName.sendKeys(ename);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='listbox']//span")).click();
		Thread.sleep(1000);
		
		WebElement statusDD = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		statusDD.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+status+"']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(a_us);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(a_pwd);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(a_pwd);
		
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		
		WebElement save2 = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click()", save2);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1500);
		WebElement searchUser = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
		js.executeScript("arguments[0].style.border='3px solid green'", searchUser);
		searchUser.sendKeys(a_us);
		
		WebElement roleDD2 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		roleDD2.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='"+role+"']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
		if(driver.findElements(By.xpath("//div[text()='"+a_us+"']")).size()>0) {
			System.out.println("PASS - Admin User Found: "+a_us+" with Role: "+role);
			js.executeScript("alert('PASS - Record Verified')");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		} else {
			System.out.println("FAIL - Admin User Not Found");
		}
		
		driver.quit();
	}
}
