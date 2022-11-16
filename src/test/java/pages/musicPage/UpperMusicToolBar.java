package pages.musicPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UpperMusicToolBar {

    private static SelenideElement rootElem;

    private static final By INPUT_FIELD =
            byAttribute("data-tsid","inner_input");

    private static final By CURRENT_PLAYLIST_BTN =
            byAttribute("data-tsid", "current_playlist");

    private static final By SHARE_TRAC_BTN =
            byAttribute("data-tsid", "share_track");

    private static final By ADD_TRACK_BTN =
            byAttribute("data-tsid", "add_track");

    private static final By TRACK_NAME =
            byAttribute("data-tsid", "track_name");

    private static final By TRACK_AUTHOR =
            byClassName("artist");

    private static final By NEXT_TRACK_BTN =
            byAttribute("data-tsid", "forward_button");

    private static final By PREV_TRACK_BTN =
            byAttribute("data-tsid", "backward_button");

    public UpperMusicToolBar(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void findTrack(String trackName) {
        rootElem.$(INPUT_FIELD).setValue(trackName);
        try {
            Thread.sleep(500);     // 'search' icon changes too fast :(
        } catch (Exception e) {}
        rootElem.$(INPUT_FIELD).pressEnter();
    }

    public void clearSearchField() {
        rootElem.$(INPUT_FIELD).clear();
    }
}

