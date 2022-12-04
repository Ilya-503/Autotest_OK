package pages.musicPage.pageElements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LeftMusicPanel {

    private static SelenideElement rootElem;

    private static final By POPULAR_MSC_BTN = byAttribute("data-tsid", "showcase");
    private static final By MY_MSC_BTN = byAttribute("data-tsid", "library");
    private static final By RADIO_BTN = byAttribute("data-tsid", "radio");
    private static final By MSC_ALBUMS_BTN = byAttribute("data-tsid", "collections");
    private static final By MY_ALBUMS_PANEL = byClassName("submenu");
    private static final By PLAYLIST_ELEM = byAttribute("data-tsid", "playlist_item");

    public LeftMusicPanel(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void goToLibrary() {
        rootElem.$(MY_MSC_BTN)
                .shouldBe(visible.because("Нет кнопки перехода в библиотеку музыки"))
                .click();
    }

    public void goToAlbums() {
        rootElem.$(MSC_ALBUMS_BTN)
                .shouldBe(visible.because("Нет кнопки перехода на страницу альбомов"))
                .click();
    }

    public ElementsCollection getMyAlbums() {
        if (!(($(MY_ALBUMS_PANEL)).isDisplayed())) {
            $(MY_MSC_BTN).shouldBe(visible.because("Нет кнопки добавленной музыки")).click();
        }
        return rootElem.$$(PLAYLIST_ELEM);
    }

    public void goToFirstLibraryAlbum() {
        rootElem.$(PLAYLIST_ELEM)
                .shouldBe(visible.because("Нет альбомов в библиотеке"))
                .click();
    }
}
