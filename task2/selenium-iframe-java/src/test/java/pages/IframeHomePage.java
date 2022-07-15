package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframeHomePage extends BasePage {


    @FindBy(id = "Single")
    public WebElement elementOutsideTheIframe;
    @FindBy(id = "singleframe")
    public WebElement singleFrameElement;

    @FindBy(css = "input[type=\"text\"]")
    public WebElement iframe_singleFrameInputText;

    public IframeHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

}