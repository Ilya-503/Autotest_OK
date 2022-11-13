package Pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private NewsPage newsPage;

    private static final String LOGIN = "technoPol17";
    private static final String PASSWORD = "technoPolis2022";
    private static final String URL = "https://ok.ru/";

    @BeforeEach
    public void openBrowser() {
        loginPage = new LoginPage(URL);
        loginPage.validate();
    }

    @Test
    public void testEmptyFields() {
        loginPage.submit();
        assertEquals("Введите логин", loginPage.getErrorString());
    }

    @Test
    public void testEmptyPasswordField() {
        loginPage
                .setLogin("illegalLogin")
                .submit();
        assertEquals("Введите пароль", loginPage.getErrorString());
    }

    @Test
    public void testIllegalPassword() {
        loginPage
                .setLogin(LOGIN)
                .setPassword("illegalPassword")
                .submit();
        assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrorString());
    }

    @Test
    public void testLogin() {
        loginPage
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .submit();
        newsPage = new NewsPage();
        assertTrue(newsPage.getNoteFiled().exists());
    }


}