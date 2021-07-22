package pages;

import elements.Button;
import elements.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.FieldDecorator;

public abstract class BasePage {

    WebDriver driver;
    String pageName;

    @FindBy(css = "#search_query_top")
    private Element searchField;

    @FindBy(css = "[name='submit_search']")
    private Button submitSearchBtn;

    @FindBy(css = "p.alert-warning")
    private Element searchError;


    protected BasePage(WebDriver driver, String pageName) {
        this.driver = driver;
        this.pageName = pageName;
        PageFactory.initElements(new FieldDecorator(driver), this);
    }

    public void search(String searchQuery) {
        searchField.click();
        submitSearchBtn.click();
    }

    public String getSearchErrorMessage() {
        return searchError.getText();
    }

    public boolean isErrorDisplayed() {
        return searchError.isDisplayed();
    }

    public boolean isErrorNotDisplayed() {
        return searchError.isNotDisplayed();
    }

}
