package selenide;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private static LoginPage loginPage;

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        loginPage = new LoginPage(ConfProperties.getProperty("url"));
    }

    @Test
    public void test() {
        loginPage.login();
        assertTrue($(byAttribute("data-l", "t,mainpf_open")).exists());
    }
}