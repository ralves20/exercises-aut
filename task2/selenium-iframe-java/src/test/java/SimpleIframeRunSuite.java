import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SimpleIframeRun;
import tests.iframetest.IframeBasicValidationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SimpleIframeRun.class)
@Suite.SuiteClasses(IframeBasicValidationTest.class)
public class SimpleIframeRunSuite {

}
