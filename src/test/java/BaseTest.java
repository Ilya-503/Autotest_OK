import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.musicPage.pageElements.UpperMusicToolBar;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 6_000;
    }

    @AfterEach
    public void close() {
        Selenide.closeWebDriver();
    }
}
