package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "user-name")
	private WebElement untf;
	
	@FindBy(id = "password")
	private WebElement pwdtf;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public void getUntf(String value) {
		untf.sendKeys(value);
	}

	public void getPwdtf(String value) {
		pwdtf.sendKeys(value);
	}

	public void getLoginButton() {
		loginButton.click();
	}
}
