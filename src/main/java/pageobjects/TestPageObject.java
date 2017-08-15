package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageObject {

    @FindBy(id = "txtName")
    private WebElement usernameTextField;

    public WebElement getUsernameTextField() {
        return usernameTextField;
    }
}
