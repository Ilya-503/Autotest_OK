package firstHomeTask;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final SelenideElement loginField = $(byId("field_email"));
    private static final SelenideElement passwordField = $(byId("field_password"));
    private static final SelenideElement submitBtn = $(byAttribute("type", "submit"));



    public LoginPage(String url) {
        open(url);
    }

    public void setLogin(String login) {
        loginField.setValue(login);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void submit() {
        submitBtn.click();
    }
}
