package pages;

import elements.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='login']")
   private Button signInBtn;

    public HomePage(WebDriver driver) {
        super(driver, "Home page");
        this.driver = driver;
    }

    public void clickSignIn() {
        signInBtn.click();
    }
}
