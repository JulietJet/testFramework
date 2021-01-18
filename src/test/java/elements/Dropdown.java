package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.UIInteractionException;

import java.util.ArrayList;
import java.util.List;

public class Dropdown extends Element {

    public Dropdown(WebDriver driver, By locator) {
        super(driver, locator);
    }

    private Select getSelect() {
        return new Select(getWebElement());
    }

    public void selectByValue(String value) {
        try {
            getSelect().selectByValue(value);
        } catch (WebDriverException e) {
            throw new UIInteractionException("Select dropdown element", e);
        }
    }

    public void deselectByValue(String value) {
        try {
            getSelect().deselectByValue(value);
        } catch (WebDriverException e) {
            throw new UIInteractionException("Deselect dropdown element", e);
        }
    }

    public void deselectAll() {
        try {
            getSelect().deselectAll();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Deselect all dropdown elements", e);
        }
    }

    public List<String> getAllSelectedOptions() {
        List<String> values = new ArrayList<>();
        try {
            List<WebElement> elements = getSelect().getAllSelectedOptions();
            elements.stream().forEach(el -> {
                values.add(el.getText());
            });
            return values;
        } catch (WebDriverException e) {
            throw new UIInteractionException("Get all selected options", e);
        }
    }

    public List<String> getOptions() {
        List<String> options = new ArrayList<>();
        try {
            List<WebElement> elements = getSelect().getOptions();
            elements.stream().forEach(el -> {
                options.add(el.getText());
            });
            return options;
        } catch (WebDriverException e) {
            throw new UIInteractionException("Get all dropdown options", e);
        }
    }


}
