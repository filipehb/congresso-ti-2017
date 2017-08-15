package search;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class SearchTest {
    @BeforeClass
    public static void setUp() {
        loginPage = PageObjectFactory.init(LoginPageObject.class);
        cliTemplateInstancePage = PageObjectFactory.init(CliTemplateInstanceListPageObject.class);
    }

    @AfterClass
    public static void tearDown() {
        SeleniumServiceUtils.quit();
    }

    @Before
    public void setup() {
        navigateToBaseUrl();
    }
}
