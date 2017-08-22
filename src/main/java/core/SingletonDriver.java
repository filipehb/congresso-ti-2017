package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.getProperties;

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
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "caminho do geckodriver");
        return new FirefoxDriver();
    }
}
