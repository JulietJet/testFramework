package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Element {

    WebDriver driver;

    public Button(WebDriver driver, By locator) {
        super(driver, locator);
    }

}
