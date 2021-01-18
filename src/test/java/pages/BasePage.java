package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;
    String pageName;

    protected BasePage(WebDriver driver, String pageName) {
        this.driver = driver;
        this.pageName = pageName;
    }

}
