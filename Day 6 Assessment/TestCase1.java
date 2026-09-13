package Demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		FileInputStream fis_p = new FileInputStream("./src/test/resources/Day6_Assessment/TestCase1commondata.properties");
		Properties p = new Properties();
		p.load(fis_p);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		FileInputStream fis_excel = new FileInputStream("./src/test/resources/Day6_Assessment/Day6testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis_excel);
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String e_un = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String e_pwd = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		String role = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
		String ename = wb.getSheet("Sheet1").getRow(1).getCell(7).toString();
		String status = wb.getSheet("Sheet1").getRow(1).getCell(8).toString();
		String a_us = wb.getSheet("Sheet1").getRow(1).getCell(9).toString();
		String a_pwd = wb.getSheet("Sheet1").getRow(1).getCell(10).toString();
		wb.close();
		
		WebDriver driver = null;
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		
		if(browser.contains("chrome"))
			driver = new ChromeDriver(settings);
		if(browser.contains("edge"))
			driver = new EdgeDriver();
		if(browser.contains("firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(1000);
		
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
		
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(e_pwd);
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(e_pwd);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(1000);
		
		WebElement role1 = driver.findElement(By.xpath("//div[@class='oxd-select-text-input']"));
		role1.click();
		Thread.sleep(500);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		WebElement employee = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employee.sendKeys(ename);
		Thread.sleep(3000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		WebElement status1 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		status1.click();
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(a_us);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(a_pwd);
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(a_pwd);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(a_us);
		Thread.sleep(1000);
		
		WebElement role2 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
		role2.click();
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);

		WebElement employee1 = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		employee1.sendKeys(ename);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='listbox']//span")).click();
		Thread.sleep(1000);
		
		WebElement status2 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
		status2.click();
		Thread.sleep(500);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		if(driver.findElements(By.xpath("//span[text()='No Records Found']")).size() > 0) {
			System.out.println("no record found");
		} else {
			System.out.println("Record found for: " + a_us);
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
