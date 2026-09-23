Basic Selenium
Test Case - 1

package FinalAssessment;
import java.time.Duration;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Assesment1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		Thread.sleep(2000);
		
		WebElement buttn = driver.findElement(By.id("tog"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('disabled');",buttn);
		js.executeScript("arguments[0].click();", buttn);
		Thread.sleep(2000);
		
		WebElement buttn2 = driver.findElement(By.id("togg"));
		js.executeScript("arguments[0].removeAttribute('disabled');",buttn2);
		js.executeScript("arguments[0].click();", buttn2);
		Thread.sleep(2000);
		
		WebElement buttn3 = driver.findElement(By.id("toggl"));
		js.executeScript("arguments[0].removeAttribute('disabled');",buttn3);
		js.executeScript("arguments[0].click();", buttn3);
		Thread.sleep(2000);
		WebElement buttn4 = driver.findElement(By.id("toggler"));
		js.executeScript("arguments[0].removeAttribute('disabled');",buttn4);
		js.executeScript("arguments[0].click();", buttn4);
		
	    driver.findElement(By.id("togglers")).click();
	
		String url = driver.getCurrentUrl();
		System.out.println(url);
		if(url.equals("https://demoapps.qspiders.com/ui/image"))
		{
			System.out.println("order is placed");
		}
		else {
			System.out.println("order is not placed");
		}

	}

}

Test Case - 2

package FinalAssessment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assessment2 {

	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();

	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        driver.get("https://demoapps.qspiders.com/ui/slider");

	        WebElement ch = driver.findElement(By.id("slide"));

	        Actions act = new Actions(driver);

	        act.clickAndHold(ch).moveByOffset(100, 0).release().build().perform();

	        Thread.sleep(3000);
	        String text = driver.findElement(By.xpath("(//h3[@class='text-sm font-bold pb-1'])[3]")).getText();
	        System.out.println(text);
	        
	        if(text.equals("Mens Cotton Jacket..."))
	        {
	        	System.out.println("product is displayed");
	        }
	        else {
	        	System.out.println("product is not dispalyed");
	        }

	        driver.quit();


	}

}

Test Case - 3

package FinalAssessment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assessment3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		
		WebElement ele1 = driver.findElement(By.id("dragElement1"));
		WebElement ele2 = driver.findElement(By.id("dragElement2"));
		WebElement ele3 = driver.findElement(By.id("dragElement3"));
		WebElement ele4 = driver.findElement(By.id("dragElement4"));
		
		WebElement locator1 = driver.findElement(By.id("dropZone1"));
		WebElement locator2 = driver.findElement(By.id("dropZone2"));
		
		Actions act = new Actions(driver);
		act.click(ele1).perform();
		act.click(ele3).perform();
		act.clickAndHold(ele2).moveToElement(locator1).release().perform();
		act.clickAndHold(ele1).moveToElement(locator2).release().perform();
		
		act.click(ele2).perform();
		act.click(ele4).perform();
		act.clickAndHold(ele1).moveToElement(locator2).release().perform();
		act.clickAndHold(ele3).moveToElement(locator2).release().perform();
	}

}

Test Case - 4

package FinalAssessment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assessment4 {

	public static void main(String[] args) throws InterruptedException {
				EdgeDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
				driver.get("https://www.shoppersstack.com/");
				Thread.sleep(30000);
				driver.findElement(By.id("loginBtn")).click();
				driver.findElement(By.id("Email")).sendKeys("sonykulkarni07.z@gmail.com");
				driver.findElement(By.id("Password")).sendKeys("$U$h7090");
				
				driver.findElement(By.id("Login")).click();
				
				driver.findElement(By.xpath("//div[@class='featuredProducts_cardBody__l4gLE']")).click();
				
				driver.findElement(By.xpath("//input[@id='Check Delivery']")).sendKeys("678103");
				
				WebElement refe = driver.findElement(By.xpath("//button[@id='Check']"));
				
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				wait.until(ExpectedConditions.elementToBeClickable(refe));
				refe.click();
				
				String text=driver.findElement(By.xpath("//p[@id='Check Delivery-helper-text']")).getText();
				
				System.out.println(text);

			}
}


Advance Selenium
TestCase - 1
--Login Page--

package FinalAssessment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		    WebDriver driver;

		    public LoginPage(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }

		    @FindBy(name="username")
		    private WebElement username;

		    @FindBy(name="password")
		    private WebElement password;

		    @FindBy(xpath="//button[@type='submit']")
		    private WebElement loginButton;

		    public void enterUsername(String user) {
		        username.sendKeys(user);
		    }

		    public void enterPassword(String pass) {
		        password.sendKeys(pass);
		    }

		    public void clickLogin() {
		        loginButton.click();
		    }
		}

--Buzz File--

package FinalAssessment;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buzzorg {

			WebDriver driver;
			public Buzzorg(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}

			@FindBy(xpath = "//a[@href='/web/index.php/buzz/viewBuzz']")
			private WebElement buzz;

			@FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
			private WebElement text;

			@FindBy(xpath = "//button[normalize-space()='Post']")
			private WebElement post;

			@FindBy(xpath = "//div[contains(@class,'orangehrm-buzz-post')]")
			private WebElement recentPost;

			public void clickBuzz() {
				buzz.click();
			}

			public void enterPost(String msg) {
				text.sendKeys(msg);
			}

			public void clickPost() {
				post.click();
			}

			public boolean verifyPost(String text) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfAllElements(recentPost));
				return recentPost.isDisplayed();
			}

			

	}

--Logout page--

package FinalAssessment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpage {
		 WebDriver driver;

		    public Logoutpage(WebDriver driver) {
		        this.driver = driver;
		        PageFactory.initElements(driver, this);
		    }

		    @FindBy(xpath="//span[contains(@class,'oxd-userdropdown-tab')]")
		    private WebElement userMenu;

		    @FindBy(xpath="//a[text()='Logout']")
		    private WebElement logout;

		    public void clickUserMenu() {
		        userMenu.click();
		    }

		    public void clickLogout() {
		        logout.click();
		    }
		}

--Basic File--

package BaseclassUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import OraangeAssess.Loginpage;
import OraangeAssess.Logoutorg;

public class BaseclassOrg {
		public WebDriver driver;
		String Browser;
		String username;
		String password;
		String url;
	    @BeforeSuite
		public void Bs() {
			System.out.println("Open databse connectivity");
		}
	    @BeforeTest
	    public void BT() {
	    	System.out.println("precondition");
	    }
	    @BeforeClass
		public void Bc() throws IOException {
	    	FileInputStream fis = new FileInputStream("./src/test/resources/DDT/Orangecoomondata");
	        Properties p = new Properties();

	        p.load(fis);
	        
	        Browser = p.getProperty("browser");
	        url=p.getProperty("url");
	        username=p.getProperty("username");
	        password=p.getProperty("password");
	        

			if(Browser.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			if(Browser.equals("Edge"))
			{
				driver=new EdgeDriver();
			}
			if(Browser.equals("Firefox"))
			{
				driver=new FirefoxDriver();
			}
	        driver.manage().window().maximize();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	    @BeforeMethod
	    public void launchBrowser() throws IOException, InterruptedException {
	        // Launch application
	    	driver.get(url);
	    	Thread.sleep(2000);
	    	// Login
	        Loginpage login = new Loginpage(driver);

	        login.enterUsername(username);
	        Thread.sleep(2000);
	        login.enterPassword(password);

	        login.clickLogin();
	    	
	    }
	    @AfterClass
		public void Ac() {
			System.out.println("close the browser");
			driver.quit();
		}
	
		@AfterMethod
		public void Am() {
			System.out.println("logout successfull");
			Logoutorg logout = new Logoutorg(driver);

	        logout.clickUserMenu();
	        logout.clickLogout();
		}
		@AfterTest
		public void AT() {
			System.out.println("Postcondition");
		}
		@AfterSuite
		public void As() {
			System.out.println("close database");
		}
		
}

--Property File--

browser Edge
url https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
username Admin

--Excel File--
text
Hello Team AutomationTesting
Good Morning Everyone

--Test Script--

package UsingTestNG;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseclassUtility.BaseclassOrg;
import FinalAssess.Buzzorg;

public class FinalAss  extends BaseclassOrg{
	@Test
	public void BuzzFile() throws EncryptedDocumentException, IOException{
		
		   Buzzorg bz=new Buzzorg(driver);
		 FileInputStream fi = new FileInputStream("./src/test/resources/DDT/OrangeHrm.xlsx");

			Workbook wb = WorkbookFactory.create(fi);
				Sheet s = wb.getSheet("Sheet2");
				String postText = s.getRow(1).getCell(0).getStringCellValue();

				// Click Buzz
				bz.clickBuzz();

				// Enter text
				bz.enterPost(postText);

				// Click Post
				bz.clickPost();

				boolean result = bz.verifyPost(postText);
				Assert.assertTrue(result);
				System.out.println("Post is successfully displayed in Recent Posts");
			}
		
	}
