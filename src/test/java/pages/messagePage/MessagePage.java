package pages.messagePage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Loadable;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MessagePage implements Loadable {

    private static final By CHATS_LIST = byAttribute("data-tsid", "conversation_list");
    private static final By INPUTE_FIELD = byAttribute("data-tsid", "write_msg_input");
    private static final By DIALOG_PANEL = byTagName("msg-message-list");
    private static final By OPTIONS_BTN = byAttribute("data-l", "t,messageActionmore");
    private static final By DEL_MSG_BTN = byAttribute("data-tsid", "remove_msg_button");
    private static final By EDIT_MSG_BTN = byAttribute("data-tsid", "edit_msg_button");

    public MessagePage() {
        validate();
    }

    public void goToDialogWith(String friendName) {
        $(CHATS_LIST).$(withTextCaseInsensitive(friendName)).click();
    }

    public void sendMessage(String message) {
        $(INPUTE_FIELD).setValue(message).pressEnter();
    }

    public void deleteMessageWithContentForEveryone(String content) {
        $(DIALOG_PANEL).shouldBe(visible);
        $(DIALOG_PANEL)
                .$(withTextCaseInsensitive(content))
                .hover();
        $(DIALOG_PANEL).$(OPTIONS_BTN).hover().hover();
        $(DEL_MSG_BTN).click();

        SelenideElement forEveryoneCheck =
                $(byAttribute("data-tsid", "checkbox_remove_all"));
        if (!forEveryoneCheck.isSelected()) {
            forEveryoneCheck.click();
        }
        $(byAttribute("data-tsid", "confirm-primary")).click();
    }

    @Override
    public void validate() {
        $(CHATS_LIST).shouldBe(visible);
    }
}
