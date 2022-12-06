import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private final String TEST_ERR_MSG = "Тип ошибки не совпадает с ожидаемым";

    @BeforeEach
    public void openBrowser() {
        open(Configuration.baseUrl);
        loginPage = new LoginPage();
    }


    @Tag("LoginFunc")
    @DisplayName("Вход при различных недопустимых значениях в полях")
    @ParameterizedTest(name = "login = {0}, psw = {1}, err = {2}")
    @MethodSource("provideInvalidLoginParams")
    public void testIllegalFieldsValues(String login, String password, String expectedErrorStr) {
        loginPage
                .setLogin(login)
                .setPassword(password)
                .submit();
        assertEquals(expectedErrorStr, loginPage.getErrorString(), TEST_ERR_MSG);
    }

    private static Stream<Arguments> provideInvalidLoginParams() {
        return Stream.of(
                Arguments.of(null, null, "Введите логин"),
                Arguments.of("login", null, "Введите пароль"),
                Arguments.of(LOGIN, null, "Введите пароль"),
                Arguments.of(LOGIN, "password", "Неправильно указан логин и/или пароль")
        );
    }

    @Tag("LoginFunc")
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