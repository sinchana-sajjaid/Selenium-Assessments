package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement product;
	
	@FindBy(xpath = "//button[text()='Checkout']")
	private WebElement checkoutButton;
	
	public void productDisplayed(String value)
	{
		if(product.getText().equals(value))
			System.out.println(value+" product is displayed");
		else
			System.out.println(value+" product is not displayed");
	}
	
	public void clickCheckout()
	{
		checkoutButton.click();
	}
}
