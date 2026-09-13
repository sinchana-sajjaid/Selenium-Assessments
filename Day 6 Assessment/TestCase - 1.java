package Demo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day6_testcase1 {
    public static void main(String[] args) throws Exception {

        FileInputStream f = new FileInputStream("./src/test/resources/DDT/Day6_testcase1.properties");
        Properties p = new Properties();
        p.load(f);
        String browser = p.getProperty("browser");
        String url = p.getProperty("url");
        String un = p.getProperty("username");
        String pw = p.getProperty("password");

        FileInputStream f1 = new FileInputStream("./src/test/resources/DDT/Day6_testcase.xlsx");
        Workbook w = WorkbookFactory.create(f1);
        String first_name = w.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        String middle_name = w.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        String last_name = w.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
        String eid = w.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
        String user_name = w.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
        String password = w.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
        String confirm_pw = w.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();

        ChromeOptions settings = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        settings.setExperimentalOption("prefs", prefs);

        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(settings);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(url);
        driver.findElement(By.name("username")).sendKeys(un);
        driver.findElement(By.name("password")).sendKeys(pw);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//button[contains(.,'Add')]")).click();

        driver.findElement(By.name("firstName")).sendKeys(first_name);
        driver.findElement(By.name("middleName")).sendKeys(middle_name);
        driver.findElement(By.name("lastName")).sendKeys(last_name);

        WebElement empIdField = driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[1]"));
        empIdField.sendKeys(Keys.CONTROL + "a");
        empIdField.sendKeys(Keys.DELETE);
        empIdField.sendKeys(eid);

        driver.findElement(By.xpath("//span[contains(@class,'oxd-switch-input')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[text()='Username']/following::input[1]")).sendKeys(user_name);
        driver.findElement(By.xpath("//label[text()='Password']/following::input[1]")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]")).sendKeys(confirm_pw);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        driver.findElement(By.xpath("//label[text()='Username']/following::input[1]")).sendKeys(user_name);

        driver.findElement(By.xpath("//label[text()='User Role']/following::div[1]")).click();
        driver.findElement(By.xpath("//span[text()='ESS']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys(first_name);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='option']")).click();

        driver.findElement(By.xpath("//label[text()='Status']/following::div[1]")).click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        String records = driver.findElement(By.xpath("//span[contains(text(),'Records Found')]")).getText();
        if (records.contains("(1)")) {
            System.out.println("PASS: Employee added - " + records);
        } else {
            System.out.println("FAIL: Employee not found - " + records);
        }

        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        w.close();
        f.close();
        f1.close();
        driver.quit();
    }
}
