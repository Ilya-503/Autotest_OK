import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'field_email')]")
    private WebElement loginFiled;

    @FindBy(xpath = "//*[contains(@id, 'field_password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private WebElement submitBtn;

    public void inputLogin(String login) {
        loginFiled.sendKeys(login);
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password, Keys.ENTER);
    }

    public void submit() {
        submitBtn.click();
    }
}
