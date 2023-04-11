package SeleniumFramework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.testcomponents.BaseTest;

public class ErrorValidations extends BaseTest {

	@Test
	public void submitOrder() throws IOException {
		// logging to the web site with wrong credentials
		landingPage.loginApplication("invanova1.20@gmail.com", "Def_6789");

		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}

}
