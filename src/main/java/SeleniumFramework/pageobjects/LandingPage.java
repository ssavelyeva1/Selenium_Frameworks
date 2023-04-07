package SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	// constructor method
	public LandingPage(WebDriver driver) {
		// passing driver from StandaloneTest class to LandingPage class
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement password;
	
	@FindBy(id = "login")
	WebElement submit;
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	public void loginApplication(String email, String psswd) {
		userEmail.sendKeys(email);
		password.sendKeys(psswd);
		submit.click();
	}

}
