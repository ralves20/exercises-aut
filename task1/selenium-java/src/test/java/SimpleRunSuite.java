import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SimpleRun;
import tests.wikipedia.WikipediaSearchUiTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SimpleRun.class)
@Suite.SuiteClasses(WikipediaSearchUiTest.class)
public class SimpleRunSuite {

}
