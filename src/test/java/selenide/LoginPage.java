package selenide;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private final SelenideElement loginField = $(byId("field_email"));
    private final SelenideElement passwordField = $(byId("field_password"));

    public LoginPage(String url) {
        open(url);
    }

    public void login() {
        loginField.setValue(ConfProperties.getProperty("login"));
        passwordField.setValue(ConfProperties.getProperty("password")).pressEnter();
    }
}
