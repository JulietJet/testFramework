package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import utils.UIInteractionException;

public class RadioButton extends Element {

    WebDriver driver;

    public RadioButton(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public boolean isSelected() {
        try {
            return getWebElement().isSelected();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Is RadioButton selected", e);
        }
    }

    public void select() {
        if (!isSelected())
            click();
    }

    public String getValue() {
        return getAttribute("value");
    }
}
