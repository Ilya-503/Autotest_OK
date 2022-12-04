import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    private Cookie loggedCookie =
            new Cookie("JSESSIONID", "ad7c01d36e36d019eabde89244e9489434241717b0e0f05b.9aa53f85");

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
        WebDriverRunner.getWebDriver().manage().addCookie(loggedCookie);
        Selenide.refresh();
    }
}
