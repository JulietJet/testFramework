package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Driver {

	private WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		String operationSystem = System.getProperty("os.name").toLowerCase();

		if (operationSystem.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chrome/mac/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chrome/win/chromedriver");
		}

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lamoda.by/");


	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test
	public void test() {
		WebElement searchInput = driver.findElement(By.cssSelector("input.search__input"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(searchInput));

		Assert.assertTrue(searchInput.isDisplayed());

	}


}
