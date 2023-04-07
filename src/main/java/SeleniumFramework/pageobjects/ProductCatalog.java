package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog {

	WebDriver driver;

	// constructor method
	public ProductCatalog(WebDriver driver) {
		// passing driver from StandaloneTest class to LandingPage class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(css = ".mb-3")
	List<WebElement> products;

}
