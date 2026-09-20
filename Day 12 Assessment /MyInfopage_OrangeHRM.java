package Day12_OranageHRMBase;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyInfopage_OrangeHRM {
	WebDriver driver;

	public MyInfopage_OrangeHRM(WebDriver driver) throws AWTException {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@FindBy(name = "firstName")
	private WebElement fntf;
	
	@FindBy(name = "lastName")
	private WebElement lntf;
	
	@FindBy(xpath = "//label[text()='Employee Id']/../..//input")
	private WebElement empidtf;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;

	public void getFntf(String value) {
		fntf.sendKeys(Keys.CONTROL+"a");
		fntf.sendKeys(Keys.BACK_SPACE);
		fntf.sendKeys(value);
	}

	public void getLntf(String value) {
		lntf.sendKeys(Keys.CONTROL+"a");
		lntf.sendKeys(Keys.BACK_SPACE);
		lntf.sendKeys(value);
	}

	public void getEmpidtf(String value) {
		empidtf.sendKeys(Keys.CONTROL+"a");
		empidtf.sendKeys(Keys.BACK_SPACE);
		empidtf.sendKeys(value);
	}

	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String getFirstName()
	{
		return fntf.getAttribute("value");
	}
	
	public void verifyDetailsUpdated(String value) throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println(getFirstName());
//		if(getFirstName().equals(value))
//			System.out.println("Details updated");
		Assert.assertEquals(getFirstName(),value);
//		else
//			System.out.println("Details not updated");
	}
}
