package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {
	WebDriver driver;

	public CheckoutOverviewPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Checkout: Overview']")
	private WebElement CheckoutOverview;
	
	@FindBy(name = "finish")
	private WebElement finishButton;

	public void getCheckoutOverview(String value) {
		if(CheckoutOverview.getText().contains(value))
			System.out.println(value+" is displayed");
		else
			System.out.println(value+" is not  displayed");
	}

	public void getFinishButton() {
		finishButton.click();
	}
}
