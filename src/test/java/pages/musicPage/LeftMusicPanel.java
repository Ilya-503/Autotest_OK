package pages.musicPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LeftMusicPanel {

    private static SelenideElement rootElem;

    private static final By POPULAR_MSC_BTN = byAttribute("data-tsid", "showcase");

    private static final By MY_MSC_BTN = byAttribute("data-tsid", "library");

    private static final By RADIO_BTN = byAttribute("data-tsid", "radio");

    private static final By MSC_ALBUMS_BTN = byAttribute("data-tsid", "collections");

    public LeftMusicPanel(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void goToLibrary() {
        rootElem.$(MY_MSC_BTN).click();
    }

}
