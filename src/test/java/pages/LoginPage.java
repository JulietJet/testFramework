package pages;

import elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    Element loginField;

    public LoginPage(WebDriver driver) {
        super(driver, "Home page");
        this.driver = driver;
    }
}
