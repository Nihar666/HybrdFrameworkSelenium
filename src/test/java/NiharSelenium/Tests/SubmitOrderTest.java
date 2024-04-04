package NiharSelenium.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerse.pageobject.CartPage;
import Ecommerse.pageobject.CheckoutPage;
import Ecommerse.pageobject.ConfirmationPage;
import Ecommerse.pageobject.LandingPage;
import Ecommerse.pageobject.OrderPage;
import Ecommerse.pageobject.ProductCataloguePage;
import NiharSelenium.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";
	
	@Test
	public void submitOrder() throws InterruptedException, IOException {

		
		ProductCataloguePage productCatalogue = landingPage.loginApplication("niharpatel123mca@gmail.com",
				"Rahulshetty1#");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		// we can access parent class method from child class object
		CartPage cartPage = productCatalogue.goToCartPage();
		cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(true);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.veriryConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods= {"submitOrder"},enabled=false)
	public void orderHistoryTest() {
		//ZARA COAT 3
		ProductCataloguePage productCatalogue = landingPage.loginApplication("niharpatel123mca@gmail.com",
				"Rahulshetty1#");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
		
		
	}
	

}
