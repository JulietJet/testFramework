package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.UIInteractionException;

public class Checkbox extends Element {

    WebDriver driver;

    public Checkbox(WebDriver driver, By locator) {
        super(driver, locator);
    }


    public void select() {
        if (!isSelected())
            click();
    }

    public void unselect() {
        if (isSelected())
            click();
    }

    public boolean isSelected() {
        try {
            return getWebElement().isSelected();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Is checkbox selected", e);
        }
    }
}
