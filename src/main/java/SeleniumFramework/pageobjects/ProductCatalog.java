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

	// PageFactory - list of product web elements
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	// PageFactory - spinner web element
	@FindBy(css = ".ng-animating")
	WebElement spinner;

	// locator of the list of products
	By productsLocator = By.cssSelector(".mb-3");
	By addToCartLocator = By.cssSelector(".card-body button:last-of-type");
	By toastMassageLocator = By.cssSelector("#toast-container");
	By cartIconLocator = By.cssSelector("[routerlink*='cart']");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsLocator);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement coatProduct = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return coatProduct;
	}

	public void addProductToCart(String productName) {
		WebElement coatProduct = getProductByName(productName);
		coatProduct.findElement(addToCartLocator).click();
		waitForElementToAppear(toastMassageLocator);
		waitForElementToDisappear(spinner);
		waitElementToBeClickable(cartIconLocator);
	}

}
