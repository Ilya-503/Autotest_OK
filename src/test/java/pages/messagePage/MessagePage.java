package pages.messagePage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.Loadable;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage implements Loadable {

    private static final By CHATS_LIST = byAttribute("data-tsid", "conversation_list");
    private static final By INPUTE_FIELD = byAttribute("data-tsid", "write_msg_input");
    private static final By DIALOG_PANEL = byTagName("msg-message-list");
    private static final By EMPTY_DIALOG_WRAP = byClassName("welcome-chat-text");
    private static final By CHAT_OPTIONS_BTN = byAttribute("data-tsid", "chat_info_button");
    private static final By CLEAR_CHAT_BTN = byAttribute("data-tsid", "clear-chat-history-btn");
    private static final By SUBMIT_BTN = byAttribute("data-tsid", "confirm-primary");
    private static final By MSG_ELEM = byAttribute("data-tsid", "message_root");

    public MessagePage() {
        validate();
    }

    public void goToDialogWith(String friendName) {
        $(CHATS_LIST).$(withTextCaseInsensitive(friendName)).click();
    }

    public void sendMessage(String message) {
        $(INPUTE_FIELD).setValue(message).pressEnter();
    }

    public int countMessages() {
        return getAllMessages().size();
    }

    public void deleteMessageWithContentForEveryone(String content) {
        var allMessages = getAllMessages();
        for (var msg: allMessages) {
            if (msg.getText().contains(content)) {
                msg.deleteMessage();
                Selenide.refresh();
                break;
            }
        }
    }

    public boolean isEmptyDialog() {
        return $(EMPTY_DIALOG_WRAP).is(visible);
    }

    public void removeAllMessages() {
        $(CHAT_OPTIONS_BTN).click();
        $(CLEAR_CHAT_BTN).click();
        $(SUBMIT_BTN).click();
    }

    private List<MessageWrapper> getAllMessages() {
        List<MessageWrapper> allMessages = new ArrayList<>();
        if (isEmptyDialog()) {
            return allMessages;
        }
        ElementsCollection msgElems =
                $(DIALOG_PANEL).$$(MSG_ELEM);
        for (var elem: msgElems) {
            allMessages.add(new MessageWrapper(elem));
        }
        return allMessages;
    }

    @Override
    public void validate() {
        $(CHATS_LIST).shouldBe(visible);
    }
}
