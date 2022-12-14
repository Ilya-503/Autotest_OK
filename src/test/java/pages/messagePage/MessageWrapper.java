package pages.messagePage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class MessageWrapper {

    private static final By OPTIONS_BTN = byAttribute("data-l", "t,messageActionmore");
    private static final By DEL_MSG_BTN = byAttribute("data-tsid", "remove_msg_button");
    private static final By EDIT_MSG_BTN = byAttribute("data-tsid", "edit_msg_button");
    private static final By TEXT_ELEM = byAttribute("data-tsid", "message_text");

    private final SelenideElement msgElem;
    private final String text;

    MessageWrapper(SelenideElement msgElem) {
        this.msgElem = msgElem;
        text = $(TEXT_ELEM).shouldBe(visible.because("Нет элемента с текстом сообщения")).text();
    }

    public String getText() {
        return text;
    }

    public void deleteMessage() {
        By checkBoxRemoveForAll = byAttribute("data-tsid", "checkbox_remove_all");
        By confirmBtnElem = byAttribute("data-tsid", "confirm-primary");
        msgElem.hover().$(OPTIONS_BTN).hover();
        $(DEL_MSG_BTN).shouldBe(visible.because("Нет кнопки удаления сообщения")).click();
        SelenideElement forEveryoneCheck =
                $(checkBoxRemoveForAll);
        forEveryoneCheck.shouldBe(visible.because("Нет опции выбора удаления сообщения для всех пользователей"));
        $(confirmBtnElem).shouldBe(visible.because("Нет кнопки подтверждения удаления сообщения")).click();
    }
}
