package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

public class AbstractTest {

	protected WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		try {
			driver = Driver.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest()  {
		Driver.closeDriver();
	}


}
