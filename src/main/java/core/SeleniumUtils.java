package core;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import static core.SingletonDriver.getDriver;
import static core.SingletonDriver.getWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class SeleniumUtils {

    private static final String URL = "https://www.google.com";
    private static final String GOOGLE = "Google";

    private SeleniumUtils() {
        throw new IllegalStateException("Classe de utilidades");
    }

    public static void clicar(WebElement element) {
        EsperarElementoSerClicavel(element);
        element.click();
    }

    public static void inserir(WebElement element, String texto) {
        element.sendKeys(texto);
    }

    public static String getTitulo() {
        return getDriver().getTitle();
    }

    private static void EsperarElementoSerClicavel(WebElement element) {
        getWait().until(elementToBeClickable(element));
    }

    public static void sair() {
        SingletonDriver.destroySession();
    }

    public static void navegarParaPaginaPrincipal() {
        getDriver().navigate().to(URL);
    }

    public static WebDriver getDriver() {
        return SingletonDriver.getDriver();
    }
}
