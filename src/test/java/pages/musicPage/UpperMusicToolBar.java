package pages.musicPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UpperMusicToolBar {

    private static SelenideElement rootElem;

    private static final SelenideElement INPUT_FIELD =
            $(byAttribute("data-tsid","inner_input"));

    private static final SelenideElement CURRENT_PLAYLIST_BTN =
            $(byAttribute("data-tsid", "current_playlist"));

    private static final SelenideElement SHARE_TRAC_BTN =
            $(byAttribute("data-tsid", "share_track"));

    private static final SelenideElement ADD_TRACK_BTN =
            $(byAttribute("data-tsid", "add_track"));

    private static final SelenideElement TRACK_NAME =
            $(byAttribute("data-tsid", "track_name"));

    private static final SelenideElement TRACK_AUTHOR =
            $(byClassName("artist"));

    private static final SelenideElement NEXT_TRACK_BTN =
            $(byAttribute("data-tsid", "forward_button"));

    private static final SelenideElement PREV_TRACK_BTN =
            $(byAttribute("data-tsid", "backward_button"));

    public UpperMusicToolBar(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void findTrack(String trackName) {
        INPUT_FIELD.setValue(trackName).pressEnter();
    }

    public void clearSearchField() {
        INPUT_FIELD.clear();
    }
}

