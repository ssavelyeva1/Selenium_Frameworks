package SeleniumFramework.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramework.pageobjects.CartPage;
import SeleniumFramework.pageobjects.CheckoutPage;
import SeleniumFramework.pageobjects.ConfirmationPage;
import SeleniumFramework.pageobjects.OrderPage;
import SeleniumFramework.pageobjects.ProductCatalog;
import SeleniumFrameworkDesign.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void SubmitOrder(HashMap<String, String> input) throws IOException {

		// logging to the web site
		ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("psswd"));

		// finding and adding product to the cart
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalog.goToCartPage();

		// making sure the item was added to the cart and going to the checkout
		Boolean match = cartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();

		// selecting the country and submitting the order
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		// asserting confirmation message
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	// this test is dependent on successful run of submitOrder test
	@Test(dependsOnMethods = { "SubmitOrder" })
	public void OrderHistoryTest() {
		ProductCatalog productCatalog = landingPage.loginApplication("savelyeva1.20@gmail.com", "Abc_12345");
		OrderPage ordersPage = productCatalog.goToOrdersPage();

		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}

	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "savelyeva1.20@gmail.com");
		map1.put("psswd", "Abc_12345");
		map1.put("productName", "ZARA COAT 3");

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "savelyeva1.20@gmail.com");
		map2.put("psswd", "Abc_12345");
		map2.put("productName", "ADIDAS ORIGINAL");

		return new Object[][] { { map1 }, { map2 } };
	}

}
