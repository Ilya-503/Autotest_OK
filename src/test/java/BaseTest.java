import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

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
    public void close() {
        Selenide.closeWebDriver();
    }
}
