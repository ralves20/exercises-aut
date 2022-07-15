package tests.wikipedia;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import tests.SimpleRun;


public class WikipediaSearchUiTest extends BaseSteps {

    @Category(SimpleRun.class)
    @Test
    public void shouldPerformASuccessfullSearchAtWikipediaWhenThePropersParametersAreInformed() throws InterruptedException {
        String searchParam = "Voyager 1";
        wikiHomePage.searchInput.sendKeys(searchParam);
        wikiHomePage.performSearchElement.click();
        Thread.sleep(5000);

        Assert.assertEquals(wikiContentUiPage.titleOfPage.getText(), searchParam);
        Assert.assertTrue(wikiContentUiPage.sideBarInfoBox.isDisplayed());
        Assert.assertNotNull(wikiContentUiPage.textContentDescription.getText());

    }

}
