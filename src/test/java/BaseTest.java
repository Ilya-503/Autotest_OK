import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.loginPage.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.driverManagerEnabled = true;
        Configuration.baseUrl = "https://ok.ru/";
        Configuration.browser = "chrome";
        Configuration.timeout = 6_000;    // change to local place
    }

    @AfterEach
    public void close() {Selenide.closeWebDriver();}

    protected void logIn() {
        open(Configuration.baseUrl);
        Selenide.refresh();
    }
}
