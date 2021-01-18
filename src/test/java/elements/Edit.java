package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.UIInteractionException;

public class Edit extends Element {

    private WebDriver driver;

    public Edit(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public void type(String text) {
        try {
            getWebElement().clear();
            getWebElement().sendKeys(text);
        } catch (WebDriverException e) {
            throw new UIInteractionException("Type text", e);
        }
    }

    public void clear() {
        try {
            getWebElement().clear();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Clear text", e);
        }
    }

}
