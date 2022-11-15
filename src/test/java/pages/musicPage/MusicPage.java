package pages.musicPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Loadable;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage implements Loadable {

    private static final SelenideElement MSC_PAGE_CONTAINER = $(byClassName("page-container"));

    LeftMusicPanel leftMusicPanel;
    UpperMusicToolBar upperMusicToolBar;

    public MusicPage() {
        leftMusicPanel = new LeftMusicPanel($(byAttribute("data-l", "t,menu")));
        upperMusicToolBar = new UpperMusicToolBar($(byXpath("//header")));
        validate();
    }

    public void findTrack(String trackName) {
        upperMusicToolBar.clearSearchField();
        upperMusicToolBar.findTrack(trackName);
    }

    public void addTrackToLibrary(String trackName) {
        addTrack(trackName, byXpath("//wm-tracks-list"));
    }

    private void addTrack(String trackName, By rootElem) {
        $(rootElem).shouldBe(visible);
        SelenideElement addedMsg = $(byXpath("//*[contains(@data-l, 'similar-tracks')]"));
        List<TrackWrapper> allTracks = getTracks(rootElem);
        for (var track: allTracks) {
            if (track.getTrackInfo().contains(trackName)) {
                track.addTrackToLibrary();
                addedMsg.shouldBe(visible);
                addedMsg.$(byAttribute("data-l", "t,close")).click();
                break;
            }
        }
    }

    public List<TrackWrapper> getTracks(By rootElem) {
        List<TrackWrapper> trackList = new ArrayList<>();
        ElementsCollection trackElemColl = $(rootElem).$$(byTagName("wm-track"));
        for (var elem : trackElemColl) {
            TrackWrapper track = new TrackWrapper(elem);
            trackList.add(track);
        }
        return trackList;
    }

    public void goToLibrary() {
        leftMusicPanel.goToLibrary();
    }

    public List<TrackWrapper> getMyTracks() {
        return getTracks(byAttribute("data-l", "t,tracks"));
    }

    public void clearLibrary() {

    }

    public void deleteTrackFromLibrary(String trackName) {

    }

    @Override
    public void validate() {
        MSC_PAGE_CONTAINER.shouldBe(visible);
    }
}
