//TestCase
NAvigate to SauceDemo Application.
Login using a valid username and password.
Verify that the Products page is displayed.
Add Sauce Labs Backpack to the cart.
Verify that the cart contains 1 item.
Open the cart.
Verify that Sauce Labs Backpack is displayed.
Click on  to checkout.
Enter: Fisrt Name ,Last Name and postal code and click on continue.
Verify that the Checkout: Overview page is displayed.
Click Finish.
Verify the message "Thank you for your order!".
Close the browser.


Note : Use Two test MEthods
1.loginTest()
2.oderPalcementTest()

Maintain property file,Excel File,Pom Pages and Use TestNg annotations 
*/
package Day10_Implementation;

import java.io.IOException;

import org.testng.annotations.Test;

import Day10_BaseclassUtility.SaucedemoBaseClass;
import Day10_POMpages.CartPage;
import Day10_POMpages.CheckoutOverviewPage;
import Day10_POMpages.CheckoutPage;
import Day10_POMpages.HomePage;
import Day10_POMpages.checkoutCompletePage;

public class SauceDemoImplementation extends SaucedemoBaseClass {
	@Test
	public void loginTest()
	{
		System.out.println("Test case 1 Executed");
	}
	
	@Test
	public void oderPalcementTest() throws InterruptedException, IOException
	{
		HomePage homePage = new HomePage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutCompletePage checkoutCompletePage = new checkoutCompletePage(driver);
		data();
		Thread.sleep(1000);
		homePage.verifyProductPage(productPage);
		Thread.sleep(1000);
		homePage.clickAddToCart();
		Thread.sleep(1000);
		homePage.verifyCartContains1item(cart);
		Thread.sleep(1000);
		homePage.clickCartLink();
		Thread.sleep(1000);
		cartPage.productDisplayed(product);
		Thread.sleep(1000);
		cartPage.clickCheckout();
		Thread.sleep(1000);
		checkoutPage.getFntf(fn);
		Thread.sleep(1000);
		checkoutPage.getLntf(ln);
		Thread.sleep(1000);
		checkoutPage.getZipcodetf(zipCode);
		Thread.sleep(1000);
		checkoutPage.getContinueButton();
		Thread.sleep(1000);
		checkoutOverviewPage.getCheckoutOverview(overviewPage);
		Thread.sleep(1000);
		checkoutOverviewPage.getFinishButton();
		Thread.sleep(1000);
		checkoutCompletePage.verifyMessage(message);
		Thread.sleep(1000);
		
	}
}
