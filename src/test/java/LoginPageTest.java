import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;

    private static final String LOGIN = "technoPol17";
    private static final String PASSWORD = "technoPolis2022";
    private static final String URL = "https://ok.ru/";
    private final String TEST_ERR_MSG = "Тип ошибки не совпадает с ожидаемым";
    private String expectedErrorString;

    @BeforeEach
    public void openBrowser() {
        loginPage = new LoginPage(URL);
    }

    @Test
    @DisplayName("Вход при пустых полях")
    public void testEmptyFields() {
        loginPage.submit();
        expectedErrorString = "Введите логин";
        assertEquals(expectedErrorString, loginPage.getErrorString(), TEST_ERR_MSG);
    }

    @DisplayName("Вход при пустом поле пароля")
    @ParameterizedTest
    @ValueSource(strings = {"someLogin", LOGIN})
    public void testEmptyPasswordField(String login) {
        loginPage
                .setLogin(login)
                .submit();
        expectedErrorString = "Введите пароль";
        assertEquals(expectedErrorString, loginPage.getErrorString(), TEST_ERR_MSG);
    }

    @Test
    @DisplayName("Вход при неверных данных")
    public void testIllegalPassword() {
        loginPage
                .setLogin(LOGIN)
                .setPassword("password")
                .submit();
        expectedErrorString = "Неправильно указан логин и/или пароль";
        assertEquals(expectedErrorString, loginPage.getErrorString(), TEST_ERR_MSG);
    }

    @Test
    @DisplayName("Вход при правильных данных")
    public void testLegalLogin() {
        loginPage
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .submit();
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.getNoteFiled().exists(), "Главная страница не загрузилась");
    }
}