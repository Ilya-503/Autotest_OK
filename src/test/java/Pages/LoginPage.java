package Pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage implements Loadable {

    private static final SelenideElement loginContainer = $(byXpath("//*[@data-state-id='login']"));
    private static final SelenideElement loginField = $(byId("field_email"));
    private static final SelenideElement passwordField = $(byId("field_password"));
    private static final SelenideElement submitBtn = $(byAttribute("type", "submit"));
    private static final SelenideElement loginErrorString =
            $x("//div[contains(@class, 'login_error')]");

    public LoginPage(String url) {
        open(url);
    }

    public LoginPage setLogin(String login) {
        loginField.setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public void submit() {
        submitBtn.click();
    }

    public String getErrorString() {
        return loginErrorString.text();
    }

    @Override
    public void validate() {
        loginContainer.shouldBe(visible);
    }
}
