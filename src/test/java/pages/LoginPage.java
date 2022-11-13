package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage implements Loadable {

    private static final SelenideElement LOGIN_CONTAINER = $(byXpath("//*[@data-state-id='login']"));
    private static final SelenideElement LOGIN_FILED = $(byId("field_email"));
    private static final SelenideElement PASSWORD_FIELD = $(byId("field_password"));
    private static final SelenideElement SUBMIT_BTN = $(byAttribute("type", "submit"));
    private static final SelenideElement LOGIN_ERR_STRING =
            $x("//div[contains(@class, 'login_error')]");

    public LoginPage(String url) {
        open(url);
    }

    public LoginPage setLogin(String login) {
        LOGIN_FILED.setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        PASSWORD_FIELD.setValue(password);
        return this;
    }

    public void submit() {
        SUBMIT_BTN.click();
    }

    public String getErrorString() {
        return LOGIN_ERR_STRING.text();
    }

    @Override
    public void validate() {
        LOGIN_CONTAINER.shouldBe(visible);
    }
}
