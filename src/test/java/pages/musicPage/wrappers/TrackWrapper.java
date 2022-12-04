package pages.musicPage.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;

public class TrackWrapper {

    private static final By TITLE_ELEM = byAttribute("data-l", "t,title");
    private static final By ARTIST_ELEM = byAttribute("data-l", "t,artist");
    private static final By DURATION_ELEM = byClassName("duration");
    private static final By ADD_BTN = byAttribute("data-l", "t,add");
    private static final By REMOVE_BTN = byAttribute("data-tsid", "remove_track");
    private static final By OPTIONS_BTN = byAttribute("data-l", "t,track-actions");

    private final SelenideElement trackElem;
    private final String title, artist;
    private final int duration;

    public TrackWrapper(SelenideElement trackElem) {
        this.trackElem = trackElem;
        title = trackElem.$(TITLE_ELEM).shouldBe(visible.because("Нет элемента с названием трека")).text();
        artist = trackElem.$(ARTIST_ELEM).shouldBe(visible.because("Нет элемента с автором трека")).text();
        trackElem.$(DURATION_ELEM).shouldBe(visible.because("Нет элемента с продолжит. трека"));
        int[] durationInfo = Arrays.stream(trackElem.$(DURATION_ELEM)
                .text().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        duration = durationInfo[0] * 60 + durationInfo[1];
    }

    public void addTrackToLibrary() {
        trackElem.hover().$(ADD_BTN)
                .shouldBe(visible.because("Нет кнопки добавления трека в библиотеку"))
                .click();
    }

    public void removeTrackFromLibrary() {
        trackElem.hover().$(REMOVE_BTN)
                .shouldBe(visible.because("Нет кнопки удаления трека из библиотеки"))
                .click();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof TrackWrapper))
            return false;
        TrackWrapper oth = (TrackWrapper) obj;
        return oth.title.equals(title) && oth.artist.equals(artist) && oth.duration == duration;
    }
}
