package pages.musicPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

abstract class AlbumPanel {

    static final SelenideElement ROOT_ELEM = $(byAttribute("name", "content"));
    static final By SONG_AMOUNT_ELEM = byAttribute("data-tsid", "tracks_count");
    static final By TITLE_ELEM = byAttribute("data-tsid", "content_name");
    static final By ADD_BOOKMARK_ELEM = byAttribute("data-l", "t,add-bookmark");
    static final By REMOVE_BOOKMARK_ELEM = byAttribute("data-l", "t,remove-bookmark");
    static final By OPTIONS_ELEM = byAttribute("data-l", "t,more");
    static final By SHARE_ELEM = byAttribute("data-l", "t,share");
    static final By DELETE_ALB_ELEM = byAttribute("data-l", "t,remove");


    abstract public void shareAlbum();
    abstract public void removeAlbum();

    public static boolean isOwnAlbum() {
        return !(ROOT_ELEM.innerText().contains("Добав"));
    }

    public String getTitle() {
        return ROOT_ELEM.$(TITLE_ELEM).text();
    }

    public int getTracksAmount() {
        return Integer.parseInt(
                ROOT_ELEM.$(SONG_AMOUNT_ELEM).text().split(" ")[0]
        );
    }
}
