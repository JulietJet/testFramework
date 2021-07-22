package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utils.UIInteractionException;

public class Checkbox extends Element {

    WebDriver driver;

    public Checkbox(WebElement webElement) {
        super(webElement);
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
