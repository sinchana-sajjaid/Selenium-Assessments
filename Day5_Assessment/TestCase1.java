// Test case - 1

package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoWebshoppTestCase1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/userdata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String User = p.getProperty("user");
		String Pass = p.getProperty("pass");
		
		WebDriver driver = null;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(User);
		driver.findElement(By.id("Password")).sendKeys(Pass);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
	}
}
