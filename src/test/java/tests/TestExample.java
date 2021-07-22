package tests;


import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.Driver;


public class TestExample extends AbstractTest {



	@Test(description = "Test 1")
	public void test() {
		final String query = "ldm;ldm;alsda";

		driver = Driver.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.search(query);
		SoftAssert softAssert = new SoftAssert();
		homePage.isErrorNotDisplayed();
		softAssert.assertEquals(homePage.getSearchErrorMessage(), "No results were found for your search \"" + query + "\"");
		homePage.clickSignIn();

		softAssert.assertAll();

	}

	@Test(description = "Test 2")
	public void test2() {

	}
}
