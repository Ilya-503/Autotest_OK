package pages.musicPage.pageElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byClassName;
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

    public void goToAlbums() {
        rootElem.$(MSC_ALBUMS_BTN).click();
    }

    public ElementsCollection getMyAlbums() {
        if (!$(byClassName("submenu")).isDisplayed()) {
            $(MY_MSC_BTN).click();
        }
        return rootElem.$$(byAttribute("data-tsid", "playlist_item"));
    }

    public void goToFirstLibraryAlbum() {
        rootElem.$(byAttribute("data-tsid", "playlist_item")).click();
    }
}
