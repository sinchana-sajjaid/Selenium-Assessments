package Day12_OranageHRMBase;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClassOrangrHRM 
{
	 protected String browser;
	 protected String url;
	 protected String un;
	 protected String pwd;
	 protected String vname;
	 protected String jobTitle;
	 protected String description;
	 protected String noOfPositions;
	 protected String fn;
	 protected String ln;
	 protected String empid;
	 protected Loginpage_OrangeHRM loginpage;
	 protected Homepage_OrangeHRM homepage;
	 protected Recruitmentpage_OrangeHRM recruitmentpage;
	 protected Vacanciespage_OrangeHRM vacanciespage;
	 protected MyInfopage_OrangeHRM myInfopage;
	 
	 protected WebDriver driver;
	
	public void Data() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Day12/OrangeHRMCommonData.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		browser = p.getProperty("browser");
		url = p.getProperty("url");
		un = p.getProperty("username");
		pwd = p.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day12/OranagleHRMSpecificData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		
		vname = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		jobTitle = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		description = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		noOfPositions = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		fn = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		ln = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		empid = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		
	}
	
	@BeforeClass
	public void beforeClass() throws IOException, AWTException
	{
		Data();
		if(browser.equals("chrome"))
		{
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		}
		
		else if(browser.equals("edge"))
		{
			EdgeOptions settings = new EdgeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new EdgeDriver(settings);
		}
		
		else if(browser.equals("firefox"))
		{
			FirefoxOptions settings = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("signon.management.page.breachAlert.enabled", false);
			settings.setProfile(profile);
			driver = new FirefoxDriver(settings);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		loginpage = new Loginpage_OrangeHRM(driver);
		homepage = new Homepage_OrangeHRM(driver);
		recruitmentpage = new Recruitmentpage_OrangeHRM(driver);
		vacanciespage = new Vacanciespage_OrangeHRM(driver);
		myInfopage = new MyInfopage_OrangeHRM(driver);
		
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		driver.get(url);
		loginpage.getUntf(un);
		loginpage.getPwdtf(pwd);
		Thread.sleep(1000);
		loginpage.getLoginButton();
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		homepage.getLogoutButton();
		System.out.println("Logout done");
	}
	
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		System.out.println("closing the browser");
	}
	
}
