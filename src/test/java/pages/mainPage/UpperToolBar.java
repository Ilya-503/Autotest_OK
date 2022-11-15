package pages.mainPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class UpperToolBar {

    private SelenideElement rootElem;

    private static final By MESSAGES = byAttribute("data-l", "t,messages");

    private static final By MUSIC = byAttribute("data-l", "t,music");

    public UpperToolBar(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void goToMusicPage() {
        rootElem.$(MUSIC).click();
    }

    public void goToDialogs() {
        rootElem.$(MESSAGES).click();
    }

    public boolean isDisplayed() {
        return rootElem.isDisplayed();
    }
}
