package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;
import utils.UIInteractionException;

import java.time.Duration;

public class Element {

    private WebDriver driver;
    protected final By locator;
    private int elementTimeout;

    public Element(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        elementTimeout = Integer.parseInt(PropertyReader.readProperty("waitTimeout"));
    }

    public boolean isDisplayed() {
        try {
            getFluentWait(elementTimeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isNotDisplayed() {
        try {
            getFluentWait(elementTimeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void click() {
        try {
            getWebElement().click();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Get text", e);
        }
    }

    public String getText() {
        try {
            return getWebElement().getText();
        } catch (WebDriverException e) {
            throw new UIInteractionException("Get text", e);
        }
    }

    public String getCssValue(String propertyName) {
        try {
            return getWebElement().getCssValue(propertyName);
        } catch (WebDriverException e) {
            throw new WebDriverException("Get element css value", e);
        }
    }

    public String getAttribute(String attribute) {
        try {
            return getWebElement().getAttribute(attribute);
        } catch (WebDriverException e) {
            throw new WebDriverException("Get element attribute", e);
        }
    }

    public boolean isEnabled() {
        try {
            return getWebElement().isEnabled();
        } catch (WebDriverException e) {
            throw new WebDriverException("Is element enabled", e);
        }
    }

    protected WebElement getWebElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(elementTimeout));
        return wait.pollingEvery(Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private FluentWait<WebDriver> getFluentWait(int timeout) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
    }

}
