package pages;

import org.openqa.selenium.WebDriver;
import utils.Driver;

public abstract class BasePage {

    WebDriver driver = Driver.getDriver();
    String pageName;

    protected BasePage(String pageName) {
        this.pageName = pageName;
    }

}
