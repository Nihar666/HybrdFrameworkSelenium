package NiharSelenium.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerse.pageobject.CartPage;
import Ecommerse.pageobject.CheckoutPage;
import Ecommerse.pageobject.ConfirmationPage;
import Ecommerse.pageobject.ProductCataloguePage;
import NiharSelenium.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void loginErrorMsgValidation() {
		landingPage.loginApplication("nihrpallelelrrr333@gmail.com", "kjflkelkelk");
		Assert.assertEquals("Incorrect email or .", landingPage.getErrorMessage());
	}
	
	@Test(groups= {"ErrorHandling"})
	public void productErrorValidation() throws InterruptedException {

		String productName = "ZARA COAT 3";
		ProductCataloguePage productCatalogue = landingPage.loginApplication("niharpatel123mca@gmail.com",
				"Rahulshetty1#");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		// we can access parent class method from child class object
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("zara coat333");
		Assert.assertFalse(match);
		
	}
	
}
