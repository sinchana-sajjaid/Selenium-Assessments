package Day10_POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']/../../..//button")
	private WebElement addToCart;
	
	@FindBy(xpath = "//span[text()='1']")
	private WebElement cart;
	
	public void clickAddToCart()
	{
		addToCart.click();
	}
	
	public boolean verifyProductPage(String value)
	{
		
		if(driver.getCurrentUrl().contains(value))
			return true;
		else
			return false;
	}
	
	public void verifyCartContains1item(String value)
	{
		if(cart.getText().equals(value))
			System.out.println("cart contains 1 item");
		else
			System.out.println("cart doesn't contains 1 item");
	}
	
	public void clickCartLink()
	{
		cart.click();
	}
}
