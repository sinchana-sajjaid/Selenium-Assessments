package AdvancedSeleniumDemo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day6assessment {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		FileInputStream fis_p = new FileInputStream("./src/test/resources/DDT/TestCase1commondata.properties");
		Properties p = new Properties();
		p.load(fis_p);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		FileInputStream fis_excel = new FileInputStream("./src/test/resources/DDT/Day6testcase (1).xlsx");
		Workbook wb = WorkbookFactory.create(fis_excel);
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String e_un = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String e_pwd =wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		String role = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
		String ename = wb.getSheet("Sheet1").getRow(1).getCell(7).toString();
		String status = wb.getSheet("Sheet1").getRow(1).getCell(8).toString();
		String a_us = wb.getSheet("Sheet1").getRow(1).getCell(9).toString();
		String a_pwd = wb.getSheet("Sheet1").getRow(1).getCell(10).toString();
		
		WebDriver driver = null;
		
		WebDriverManager.chromedriver().setup();
		if(browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		if(browser.contains("edge"))
			driver = new EdgeDriver();
		if(browser.contains("firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.name("firstName")).sendKeys(fn);
		Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys(ln);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(e_un);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(e_pwd);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(e_pwd);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(1000);
		
		WebElement role1 = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
		role1.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		WebElement employee = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employee.sendKeys(ename);
		Thread.sleep(3500);
		List<WebElement> list = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		if(list.size()>0) {
			list.get(0).click();
		} else {
			employee.clear();
			Thread.sleep(1000);
			employee.sendKeys(fn);
			Thread.sleep(3500);
			List<WebElement> list2 = driver.findElements(By.xpath("//div[@role='listbox']//span"));
			if(list2.size()>0) list2.get(0).click();
		}
		Thread.sleep(1000);
		
		WebElement status1 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		status1.click();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(a_us);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(a_pwd);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(a_pwd);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		
		try {
			driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click();
			Thread.sleep(2000);
		} catch(Exception e) {}
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(a_us);
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		List<WebElement> noRecord = driver.findElements(By.xpath("//span[text()='No Records Found']"));
		if(noRecord.size()==0) {
			System.out.println("Record found - PASS");
		} else {
			System.out.println("no record found - FAIL");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
