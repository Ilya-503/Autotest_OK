import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.mainPage.MainPage;
import pages.messagePage.MessagePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagePageTest extends BaseTest {

    MessagePage messagePage;
    private final String DIALOG_PARTNER_NAME = "techno";

    @BeforeEach
    public void prepareTest() {
        logIn();
        messagePage = new MainPage().goToDialogs();
    }

    @Tag("MsgFunc")
    @Test
    @DisplayName("Проверка функции удаления сообщения")
    public void testDeleteMessage() {
        String msgToSend = "Hi, brother!";
        messagePage.goToDialogWith(DIALOG_PARTNER_NAME);
        int msgAmountBefore = messagePage.countMessages();
        messagePage.sendMessage(msgToSend);
        messagePage.deleteMessageWithContentForEveryone("Hi");
        assertEquals(msgAmountBefore, messagePage.countMessages(), "Ошибка при удалении сообщения");
    }

    @AfterEach
    public void removeAllMessages() {
        messagePage.goToDialogWith(DIALOG_PARTNER_NAME);
        messagePage.removeAllMessages();
        Selenide.closeWebDriver();
    }
}
