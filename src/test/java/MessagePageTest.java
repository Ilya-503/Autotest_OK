import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.mainPage.MainPage;
import pages.messagePage.MessagePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagePageTest extends BaseTest {

    MessagePage messagePage;
    //  private final String
    @BeforeEach
    public void prepareTest() {
        Step.logIn();
        messagePage = new MainPage().goToDialogs();
    }

    @Test
    @DisplayName("Проверка функции удаления сообщения")
    public void testDeleteMessage() {
        messagePage.goToDialogWith("techno");
        int msgAmountBefore = messagePage.countMessages();
        messagePage.sendMessage("Hi, brother!");
        messagePage.deleteMessageWithContentForEveryone("Hi");
        assertEquals(msgAmountBefore, messagePage.countMessages());
    }

    @AfterEach
    public void removeAllMessages() {
        messagePage.goToDialogWith("techno");
        messagePage.removeAllMessages();
        Selenide.closeWebDriver();
    }
}
