package pages.musicPage;

import com.beust.ah.A;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.By;
import pages.Loadable;
import pages.musicPage.wrappers.TrackWrapper;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage implements Loadable {

    private static final SelenideElement MSC_PAGE_CONTAINER = $(byClassName("page-container"));

    private static LeftMusicPanel leftMusicPanel;
    private static UpperMusicToolBar upperMusicToolBar;

    public MusicPage() {
        leftMusicPanel = new LeftMusicPanel($(byAttribute("data-l", "t,menu")));
        upperMusicToolBar = new UpperMusicToolBar($(byXpath("//header")));
        validate();
    }

    public void findTrack(String trackName) {
        upperMusicToolBar.clearSearchField();
        upperMusicToolBar.findTrack(trackName);
    }

    public TrackWrapper addTrackToLibrary(String trackName) {
        return addTrack(trackName, byAttribute("data-l", "t,tab-tracks"));
    }

    private TrackWrapper addTrack(String trackName, By rootElem) {
        SelenideElement addedMsg = $(byXpath("//*[contains(@data-l, 'similar-tracks')]"));
        List<TrackWrapper> allTracks = getTracks();
        for (var track: allTracks) {
            if (track.getTitle().contains(trackName)) {
                track.addTrackToLibrary();
                addedMsg.shouldBe(visible);
                addedMsg.$(byAttribute("data-l", "t,close")).click();
                return track;
            }
        }
        return null;
    }

    public List<TrackWrapper> getTracks() {
        By rootElem = byTagName("wm-tracks-list");
        List<TrackWrapper> trackList = new ArrayList<>();
        $(rootElem).shouldBe(visible);
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

    public void goToAlbums() {
        leftMusicPanel.goToAlbums();
    }

    public void goToFirstAlbumAndAddIt() {
        $(byAttribute("data-tsid", "music_card_wrapper")).click();
        ((OtherAlbumPanel) AlbumPanelFactory.getAlbumPanel()).addAlbumToLibrary();
    }

    public List<TrackWrapper> getMyTracks() {
        if ($(byAttribute("data-tsid", "empty_wrapper")).exists()) {
            System.out.println("There");
            return new ArrayList<>();
        }
        return getTracks();
    }

    public void clearLibrary() {
        removeMyTracks();
        removeMyAlbums();
    }

    private void removeMyTracks() {
        List<TrackWrapper> myTracks = getMyTracks();
        for (var track: myTracks) {
            track.removeTrackFromLibrary();
        }
    }

    private void removeMyAlbums() {
        ElementsCollection myAlbums = leftMusicPanel.getMyAlbums();
        for (int i = 0; i < myAlbums.size(); i++) {
            myAlbums.get(i).click();
            AlbumPanelFactory.getAlbumPanel().removeAlbum();
        }
    }

    public String getAlbumTitle() {
        return AlbumPanelFactory.getAlbumPanel().getTitle();
    }

    public int getAlbumTracksAmount() {
        return AlbumPanelFactory.getAlbumPanel().getTracksAmount();
    }

    public void goToFirstLibraryAlbum() {
        leftMusicPanel.goToFirstLibraryAlbum();
    }

    @Override
    public void validate() {
        MSC_PAGE_CONTAINER.shouldBe(visible);
    }
}
