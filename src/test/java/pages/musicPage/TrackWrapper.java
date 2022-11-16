package pages.musicPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class TrackWrapper {

    private  SelenideElement trackElem;

    private static final By INFO_ELEM = byTagName("wm-card-details"); // name + author
    private static final By DURATION_ELEM = byClassName("duration");
    private static final By ADD_DEL_BTN = byAttribute("data-l", "t,add");
    private static final By OPTIONS_BTN = byAttribute("data-l", "t,track-actions");
    private static final By ADD_STATUS_ELEM = byTagName("wm-icon");

    private final Track track;

    public TrackWrapper(SelenideElement trackElem) {
        this.trackElem = trackElem;
        List<String> info = Arrays.stream($(INFO_ELEM).text().split("\\n")).toList();
        track = new Track(info.get(0), info.get(1), $(DURATION_ELEM).text());
    }

    public String getTrackInfo() {
        return trackElem.$(INFO_ELEM).text();
    }

    public void addTrackToLibrary() {
        $(ADD_DEL_BTN).click();      // the same btn to delete from lib, but doesn't work
    }

    public void deleteTrackFromLibrary() {
        // TODO
    }

    public Track getTrack() {
        return track;
    }
}
