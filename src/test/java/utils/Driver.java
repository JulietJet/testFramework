package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		try {
			if (driver == null) {
				setupDriver();
				launch();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void closeDriver() {
		driver.close();
	}

	private static void setupDriver() throws Exception {
		String browser = PropertyReader.readProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chrome/win/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			throw new Exception("This browser is not supported");
		}
	}

	private static void launch() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(PropertyReader.readProperty("url"));
	}


}
