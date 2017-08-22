package search;

import core.SeleniumUtils;
import org.junit.*;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePageObject;
import pageobjects.ResultPageObject;

import static core.SeleniumUtils.getDriver;
import static org.junit.Assert.assertEquals;

public class SearchTest {
    private static HomePageObject homePageObject;

    @BeforeClass
    public static void init() {
        homePageObject = PageFactory.initElements(getDriver(), HomePageObject.class);
    }

    @AfterClass
    public static void tearDown() {
        SeleniumUtils.sair();
    }

    @Before
    public void setup() {
        SeleniumUtils.navegarParaPaginaPrincipal();
    }

    @After
    public void clean() {
    }

    @Test
    public void ValidarPesquisar() {
        assertEquals(homePageObject.searchFor("QA").getResultTitle(), "qa - Pesquisa Google");
    }
}
