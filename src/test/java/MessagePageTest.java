import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.mainPage.MainPage;
import pages.messagePage.MessagePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagePageTest extends BaseTest {

    MessagePage messagePage;
    private final String DIALOG_PARTNER_NAME = "techno";

    @BeforeEach
    public void prepareTest() {
        logIn();
        messagePage = new MainPage().goToDialogs();
    }

    @Test
    @DisplayName("Проверка функции удаления сообщения")
    public void testDeleteMessage() {
        messagePage.goToDialogWith(DIALOG_PARTNER_NAME);
        int msgAmountBefore = messagePage.countMessages();
        messagePage.sendMessage("Hi, brother!");
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
