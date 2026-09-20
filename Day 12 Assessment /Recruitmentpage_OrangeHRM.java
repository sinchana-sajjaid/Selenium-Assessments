package Day12_OranageHRMBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitmentpage_OrangeHRM {
	WebDriver driver;
	Actions act;

	public Recruitmentpage_OrangeHRM(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@FindBy(xpath = "//a[text()='Vacancies']")
	private WebElement vacancies;
	
	public void clickVacancies()
	{
		vacancies.click();
	}
	
}
