package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

final class SingletonDriver {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private SingletonDriver() {
    }

    static WebDriver getDriver() {
        synchronized (SingletonDriver.class) {
            if (driver == null) {
                driver = createFirefoxDriver();
            }

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

        return driver;
    }

    static WebDriverWait getWait() {
        synchronized (SingletonDriver.class) {
            if (wait == null) {
                wait = new WebDriverWait(getDriver(), 10, 1000);
            }
        }

        return wait;
    }

    static void destroySession() {
        driver.quit();
        driver = null;
        wait = null;
    }

    private static WebDriver createFirefoxDriver() {
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "LOCALDODRIVER");

        /*FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setPreference("security.insecure_field_warning.contextual.enabled", false);
        profile.setPreference("intl.accept_languages", "en-US");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(getProperties().getBrowserBinary());
        options.setProfile(profile);*/

        return new FirefoxDriver();
    }
}
