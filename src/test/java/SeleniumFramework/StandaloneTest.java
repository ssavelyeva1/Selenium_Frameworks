package SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("savelyeva1.20@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Abc_12345");
		driver.findElement(By.id("login")).click();

		List<WebElement> productsList = driver.findElements(By.cssSelector(".mb-3"));
		WebElement coatProduct = productsList.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals("ZARA_COAT_3")).findFirst()
				.orElse(null);

	}

}

//savelyeva1.20@gmail.com
//Abc_12345