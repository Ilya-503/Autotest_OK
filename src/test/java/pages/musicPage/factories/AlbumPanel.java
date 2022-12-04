package pages.musicPage.factories;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

abstract public class AlbumPanel {

    protected static final SelenideElement ROOT_ELEM = $(byAttribute("name", "content"));
    protected static final By SONG_AMOUNT_ELEM = byAttribute("data-tsid", "tracks_count");
    protected static final By TITLE_ELEM = byAttribute("data-tsid", "content_name");
    protected static final By ADD_BOOKMARK_ELEM = byAttribute("data-l", "t,add-bookmark");
    protected static final By REMOVE_BOOKMARK_ELEM = byAttribute("data-l", "t,remove-bookmark");
    protected static final By OPTIONS_ELEM = byAttribute("data-l", "t,more");
    protected static final By SHARE_ELEM = byAttribute("data-l", "t,share");
    protected static final By DELETE_ALB_ELEM = byAttribute("data-l", "t,remove");


    abstract public void shareAlbum();
    abstract public void removeAlbum();

    public static boolean isOwnAlbum() {
        return !(ROOT_ELEM.shouldBe(visible.because("Нет панели альбома на странице"))
                .innerText()
                .contains("Добав"));
    }

    public String getTitle() {
        return ROOT_ELEM.$(TITLE_ELEM)
                .shouldBe(visible.because("Нет элемента названия альбома"))
                .text();
    }

    public int getTracksAmount() {
        return Integer.parseInt(
                ROOT_ELEM.$(SONG_AMOUNT_ELEM)
                        .shouldBe(visible.because("Нет элемента с кол-вом треков альбома"))
                        .text().split(" ")[0]
        );
    }
}
