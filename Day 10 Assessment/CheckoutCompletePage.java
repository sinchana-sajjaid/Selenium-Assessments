package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutCompletePage {
	WebDriver driver;

	public checkoutCompletePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h2")
	private WebElement message;
	
	public void verifyMessage(String value)
	{
		if(message.getText().contains(value))
			System.out.println(value+" is displayed");
		else
			System.out.println(value+" is not displayed");
	}
}
