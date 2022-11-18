import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.messagePage.MessagePage;

public class MessagePageTest extends BaseTest {

    MessagePage messagePage;
    @BeforeEach
    public void prepareTest() {
        new LoginPage("https://ok.ru/")
                .setLogin("technoPol17")
                .setPassword("technoPolis2022")
                .submit();
        messagePage = new MainPage().goToDialogs();
    }

    @Test
    public void test() {
        messagePage.goToDialogWith("techno");
        messagePage.sendMessage("SHIT");
    }
}
