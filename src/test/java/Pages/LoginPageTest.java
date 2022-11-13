package Pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginPageTest {

    private LoginPage loginPage;
    private NewsPage newsPage;

    private static final String LOGIN = "technoPol17";
    private static final String PASSWORD = "technoPolis2022";
    private static final String URL = "https://ok.ru/";

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
    }

    @Before
    public void openBrowser() {
        loginPage = new LoginPage(URL);
    }

    @Test
    public void testEmptyFields() {
        loginPage.submit();
        assertEquals("Введите логин", loginPage.getErrorString());
    }

    @Test
    public void testEmptyPasswordField() {
        loginPage.setLogin("some login");
        loginPage.submit();
        assertEquals("Введите пароль", loginPage.getErrorString());
    }

    @Test
    public void testIllegalPassword() {
        loginPage.setLogin(LOGIN);
        loginPage.setPassword("somePassword");
        loginPage.submit();
        assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrorString());
    }

    @Test
    public void testLogin() {
        loginPage.setLogin(LOGIN);
        loginPage.setPassword(PASSWORD);
        loginPage.submit();
        newsPage = new NewsPage();
        assertTrue(newsPage.getNoteFiled().exists());
    }

    @After
    public void close() {
        Selenide.closeWebDriver();
    }
}