package SeleniumFrameworkDesign.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import SeleniumFramework.pageobjects.LandingPage;
import SeleniumFramework.pageobjects.ProductCatalog;
import SeleniumFrameworkDesign.testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{

	public LandingPage landingPage;
	public ProductCatalog productCatalog;
	
	@Given("I landed on E-commerce page")
	public void i_landed_on_E_commerce_page() throws IOException {
		landingPage = launchApplication();
		// code
	}

	@Given("^Logged in with username (.+) and password (.+)$") // (.+) - regexp to mark any input for user name and psswd
	public void logged_in_username_and_password(String username, String password) {
		productCatalog = landingPage.loginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) {
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(productName);
	}
	
}
