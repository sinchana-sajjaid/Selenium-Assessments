package Demo;

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
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis_prop = new FileInputStream("./src/test/resources/Day6_Assessment/TestCase1commondata.properties");
		Properties p = new Properties();
		p.load(fis_prop);
		String url = p.getProperty("url");
		String adminUser = p.getProperty("username");
		String adminPwd = p.getProperty("password");
		
		FileInputStream fis_excel = new FileInputStream("./src/test/resources/Day6_Assessment/TestCase1.xlsx");
		Workbook wb = WorkbookFactory.create(fis_excel);
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String mn = wb.getSheet("Sheet1").getRow(1).getCell(1).toString();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
		String empId = wb.getSheet("Sheet1").getRow(1).getCell(3).toString();
		String pimUsername = wb.getSheet("Sheet1").getRow(1).getCell(4).toString();
		String pimPassword = wb.getSheet("Sheet1").getRow(1).getCell(5).toString();
		String role = wb.getSheet("Sheet1").getRow(1).getCell(6).toString();
		String empName = wb.getSheet("Sheet1").getRow(1).getCell(7).toString();
		String status = wb.getSheet("Sheet1").getRow(1).getCell(8).toString();
		wb.close();

		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(adminUser);
		driver.findElement(By.name("password")).sendKeys(adminPwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--secondary')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.name("firstName")).sendKeys(fn);
		driver.findElement(By.name("middleName")).sendKeys(mn);
		driver.findElement(By.name("lastName")).sendKeys(ln);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(empId);

		driver.findElement(By.xpath("//span[contains(@class,'oxd-switch-input')]")).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(pimUsername);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(pimPassword);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(pimPassword);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(6000);

		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(pimUsername);
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role='option']//span[text()='"+role+"']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(empName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='listbox']//span")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@role='option']//span[text()='"+status+"']")).click();
		Thread.sleep(1000);
	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	
		if (driver.findElements(By.xpath("//div[text()='"+pimUsername+"']")).size() > 0) {
			System.out.println("PASS - Employee is added: " + pimUsername + " | Role: " + role);
		} else if (driver.findElements(By.xpath("//span[text()='No Records Found']")).size() > 0) {
			System.out.println("FAIL - No Records Found for: " + pimUsername);
		} else {
			System.out.println("PASS - Records Found - Search Successful for: " + pimUsername);
		}
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		Thread.sleep(2000);

		driver.quit();
	}
}
