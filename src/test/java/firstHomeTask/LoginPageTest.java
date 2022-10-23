package firstHomeTask;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private LoginPage loginPage;
    private NewsPage newsPage;

    private static final String LOGIN = "technoPol17";
    private static final String PASSWORD = " technoPolis2022";
    private static final String URL = "https://ok.ru/";

    @Before
    public  void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        loginPage = new LoginPage(URL);
        newsPage = new NewsPage();
    }

    @Test
    public void testLogin() {
        loginPage.setLogin(LOGIN);
        loginPage.setPassword(PASSWORD);
        loginPage.submit();
        assertTrue(newsPage.getNoteFiled().exists());
    }
}