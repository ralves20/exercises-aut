package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiContentUiPage extends BasePage {

    @FindBy(id = "firstHeading")
    public WebElement titleOfPage;

    @FindBy(css = "table[class=\"infobox ib-spaceflight\"]")
    public WebElement sideBarInfoBox;

    @FindBy(id = "bodyContent")
    public WebElement textContentDescription;

    public WikiContentUiPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
}
