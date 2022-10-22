package firstHomeTask;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final SelenideElement loginField = $(byId("field_email"));
    private static final SelenideElement passwordField = $(byId("field_password"));
    private static final SelenideElement submitBtn = $(byAttribute("type", "submit"));

    private static final String LOGIN = "alexkworker@mail.ru ";
    private static final String PASSWORD = " qwerty_6543210";
    private static final String URL = "https://ok.ru/";

    public LoginPage() {
        open(URL);
    }

    public void setLogin() {
        loginField.setValue(LOGIN);
    }

    public void setPassword() {
        passwordField.setValue(PASSWORD);
    }

    public void submit() {
        submitBtn.click();
    }
}
