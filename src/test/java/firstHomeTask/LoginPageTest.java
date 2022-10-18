package firstHomeTask;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    @Before
    public  void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
    }

    @Test
    public void testLogin() {
        assertTrue(new LoginPage(ConfProperties.getProperty("url"))
                .login()
                .getNoteFiled()
                .exists());
    }
}