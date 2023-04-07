package SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.abstractcomponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	// constructor method
	public ProductCatalog(WebDriver driver) {
		// sending driver form child to AbstractComponent class
		super(driver);

		// passing driver from StandaloneTest class to LandingPage class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory - list of products
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	// locator of the list of products
	By productsLocator = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsLocator);
		return products;
	}

}
