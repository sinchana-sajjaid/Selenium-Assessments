package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "firstName")
	private WebElement fntf;
	
	@FindBy(name = "lastName")
	private WebElement lntf;
	
	@FindBy(name = "postalCode")
	private WebElement zipcodetf;
	
	@FindBy(name = "continue")
	private WebElement continueButton;

	public void getFntf(String value) {
		fntf.sendKeys(value);
	}

	public void getLntf(String value) {
		lntf.sendKeys(value);
	}

	public void getZipcodetf(String value) {
		zipcodetf.sendKeys(value);
	}

	public void getContinueButton() {
		continueButton.click();
	}
	
	
	
}
