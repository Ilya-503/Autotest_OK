package pages.musicPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class TrackWrapper {

    private  SelenideElement trackElem;

    private static final By INFO = byTagName("wm-card-details"); // name + author
    private static final By DURATION = byClassName("duration");
    private static final By ADD_DEL_BTN = byAttribute("data-l", "t,add");
    private static final By OPTIONS = byAttribute("data-l", "t,track-actions");

    public TrackWrapper(SelenideElement trackElem) {
        this.trackElem = trackElem;
    }

    public String getTrackInfo() {
        return trackElem.$(INFO).text();
    }

}
