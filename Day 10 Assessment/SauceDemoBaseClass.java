package Day10_BaseclassUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Day10_POMpages.LoginPage;
import Day10_data.CommonData;

public class SaucedemoBaseClass extends CommonData {
	
	protected WebDriver driver;
	@BeforeSuite
	public void bS()
	{
		Reporter.log("Open database connectivity",true);
	}
	
	@AfterSuite
	public void aS()
	{
		Reporter.log("close database connectivity",true);
	}
	
	@BeforeTest
	public void bT()
	{
		Reporter.log("pre conditions",true);
	}
	
	@AfterTest
	public void aT()
	{
		Reporter.log("post conditions",true);
	}
	
	@BeforeClass
	public void bC() throws IOException
	{
		data();
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Reporter.log("launch the browser",true);
	}
	
	@AfterClass
	public void aC()
	{
		driver.quit();
		Reporter.log("close the browser",true);
	}
	
	@BeforeMethod
	public void bM() throws InterruptedException
	{
		Thread.sleep(2000);
		LoginPage login = new LoginPage(driver);
		
		driver.get(url);
		
		login.getUntf(un);
		Thread.sleep(1000);
		
		login.getPwdtf(pwd);
		Thread.sleep(1000);
		
		login.getLoginButton();
		Thread.sleep(2000);
		
		Reporter.log("login done",true);
	}
	
	@AfterMethod
	public void aM()
	{
		Reporter.log("logout done",true);
	}
}
