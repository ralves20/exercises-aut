package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage extends BasePage {

    @FindBy(id = "searchInput")
    public WebElement searchInput;

    @FindBy(xpath = "//i[text()='Search']/parent::button[@type='submit']")
    public WebElement performSearchElement;

    public WikiHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

}