package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.SeleniumUtils.getTitulo;

public class ResultPageObject {
    public String getResultTitle() {
        return getTitulo();
    }
}
