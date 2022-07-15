package tests.iframetest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.SimpleIframeRun;


public class IframeBasicValidationTest extends BaseSteps {


    @Category(SimpleIframeRun.class)
    @Test
    public void switchToIFrameAndValidateContent() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20000);
        webDriverWait.until(ExpectedConditions.visibilityOf(iframeHomePage.elementOutsideTheIframe));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeHomePage.singleFrameElement));
        iframeHomePage.iframe_singleFrameInputText.sendKeys("TYPING INSIDE THE IFRAME");
        Thread.sleep(5000);
        Assert.assertNotNull(iframeHomePage.iframe_singleFrameInputText.getText());
    }

}
