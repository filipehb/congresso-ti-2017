package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.SeleniumUtils.clicar;
import static core.SeleniumUtils.inserir;

public class HomePageObject {
    @FindBy(id = "lst-ib")
    WebElement searchField;

    @FindBy(name = "btnK")
    WebElement searchBtn;

    public ResultPageObject searchFor(String words) {
        inserir(searchField, words);
        clicar(searchBtn);

        return new ResultPageObject();
    }
}
