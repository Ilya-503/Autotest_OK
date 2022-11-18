package pages.messagePage;

import org.openqa.selenium.By;
import pages.Loadable;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage implements Loadable {

    private static final By CHATS_LIST = byAttribute("data-tsid", "conversation_list");
    private static final By INPUTE_FIELD = byAttribute("data-tsid", "write_msg_input");
    private static final By DIALOG_PANEL = byTagName("msg-message-list");

    public MessagePage() {
        validate();
    }

    public void goToDialogWith(String friendName) {
        $(CHATS_LIST).$(withTextCaseInsensitive(friendName)).click();
    }

    public void sendMessage(String message) {
        $(INPUTE_FIELD).setValue(message).pressEnter();
    }

    public void deleteMessageWithContent(String content) {
        $(DIALOG_PANEL).shouldBe(visible);
        $(DIALOG_PANEL).
                $(byAttribute("data-tsid", "msg-message-list")).
                $(withTextCaseInsensitive(content))
                .hover();

    }

    @Override
    public void validate() {
        $(CHATS_LIST).shouldBe(visible);
    }
}
