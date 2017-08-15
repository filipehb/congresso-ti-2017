package core;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import static core.SingletonDriver.getDriver;
import static core.SingletonDriver.getWait;

import org.openqa.selenium.WebElement;

public final class SeleniumUtils {

    private SeleniumUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void click(WebElement element) {
        waitForClickableElement(element);
        element.click();
    }

    private static void waitForClickableElement(WebElement element) {
        getWait().until(elementToBeClickable(element));
    }

    public static void quit() {
        SingletonDriver.destroySession();
    }

    public static void navigateToUrl(String url) {
        getDriver().navigate().to(url);
    }
}
