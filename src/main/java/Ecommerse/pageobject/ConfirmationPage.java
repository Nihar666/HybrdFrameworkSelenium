package Ecommerse.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Ecommerce.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	@FindBy(css = ".hero-primary")
	WebElement confirmMessage;
	
	public String veriryConfirmationMessage() {
		return confirmMessage.getText();
	}

}
