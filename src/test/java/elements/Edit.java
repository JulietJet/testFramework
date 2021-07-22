package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utils.UIInteractionException;

public class Edit extends Element {

    private WebDriver driver;

    public Edit(WebElement webElement) {
        super(webElement);
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
