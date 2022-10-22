package firstHomeTask;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private LoginPage loginPage;
    private NewsPage newsPage;

    @Before
    public  void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        loginPage = new LoginPage();
        newsPage = new NewsPage();
    }

    @Test
    public void testLogin() {
        loginPage.setLogin();
        loginPage.setPassword();
        loginPage.submit();
        assertTrue(newsPage.getNoteFiled().exists());
    }
}