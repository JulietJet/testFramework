package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver;

public class AbstractTest {

	@BeforeTest
	public void beforeTest() {
		try {
			Driver.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		Driver.closeDriver();
	}


}
