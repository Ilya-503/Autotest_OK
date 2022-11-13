package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class UpperToolBar {

    private static final SelenideElement MESSAGES_BTN = $(byAttribute("data-l", "t,messages"));
    private static final SelenideElement MUSIC_BTN = $(byAttribute("data-l", "t,music"));

    public UpperToolBar() {
    }

    public void goToMusicPage() {
        MUSIC_BTN.click();
    }

    public void goToDialogs() {
        MESSAGES_BTN.click();
    }

    public boolean isDisplayed() {
        return $(byClassName("toolbar_c")).isDisplayed();
    }
}
