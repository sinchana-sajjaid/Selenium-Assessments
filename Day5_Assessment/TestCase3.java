package Demo;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoappsqspidersTestCase3 {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fir = new FileReader("./src/test/resources/DDT/userdataa.json");
		JSONObject json = (JSONObject) new JSONParser().parse(fir);
		
		String Browser = json.get("browser").toString();
		String Url = json.get("url").toString();
		String name = json.get("name").toString();
		String fullname = json.get("fullname").toString();
		String email = json.get("email").toString();
		String password = json.get("password").toString();

		WebDriver driver = null;
		if(Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.findElement(By.id("name")).sendKeys(name); // qspiders uses id="name" not "username"
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		// Note: If your qspiders form has fullname field, add this line:
		// driver.findElement(By.id("fullname")).sendKeys(fullname);
	}
}
