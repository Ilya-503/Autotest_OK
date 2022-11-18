import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.messagePage.MessagePage;

public class MessagePageTest extends BaseTest {

    MessagePage messagePage;
    // private SelenideDriver bot_sender, bot_reader;

    @BeforeEach
    public void prepareTest() {

//        bot_sender = new SelenideDriver(new SelenideConfig().browser("chrome"));
//        bot_reader = new SelenideDriver(new SelenideConfig().browser("chrome"));

        new LoginPage("https://ok.ru/")
                .setLogin("technoPol17")
                .setPassword("technoPolis2022")
                .submit();
        messagePage = new MainPage().goToDialogs();
    }

    @Test
    public void test() {

    }
}
