package pages.musicPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Loadable;
import pages.musicPage.pageElements.UpperMusicToolBar;
import pages.musicPage.wrappers.TrackWrapper;
import pages.musicPage.factories.AlbumPanelFactory;
import pages.musicPage.pageElements.LeftMusicPanel;
import pages.musicPage.pageElements.OtherAlbumPanel;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MusicPage implements Loadable {

    private static final SelenideElement MSC_PAGE_CONTAINER = $(byClassName("page-container"));
    private static final SelenideElement LEFT_PANEL_ELEM = $(byAttribute("data-l", "t,menu"));
    private static final SelenideElement UPPER_TOOLBAR_ELEM = $(byXpath("//header"));
    private static final By TRACk_ELEM = byTagName("wm-track");
    private static final By ALBUM_CARD_ELEM = byTagName("wm-track");
    private static final By EMPTY_TRACKLIST_WRAPPER = byAttribute("data-tsid", "empty_wrapper");

    /**
     * Левая панель с кнопками "Популярное", "Моя музыка" и т.д.
     */
    private static LeftMusicPanel leftMusicPanel;

    /**
     * Верхний тул бар - взаимодействие с треками и альбомами
     */
    private static UpperMusicToolBar upperMusicToolBar;

    public MusicPage() {
        leftMusicPanel = new LeftMusicPanel(LEFT_PANEL_ELEM);
        upperMusicToolBar = new UpperMusicToolBar(UPPER_TOOLBAR_ELEM);
        validate();
    }

    public void findTrack(String trackName) {
        // upperMusicToolBar.clearSearchField();
        upperMusicToolBar.findTrack(trackName);
    }

    public TrackWrapper addTrackToLibrary(String trackName) {
        return addTrack(trackName);
    }

    /**
     * @return все треки со страницы
     */
    public List<TrackWrapper> getTracks() {
        By rootElem = byTagName("wm-tracks-list");
        List<TrackWrapper> trackList = new ArrayList<>();
        $(rootElem).shouldBe(visible.because("Не прогрузилась страница с треками"));
        ElementsCollection trackElemColl = $(rootElem).$$(TRACk_ELEM);
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
        $(ALBUM_CARD_ELEM).shouldBe(visible.because("Не прогрузились карточки с альбомами")).click();
        ((OtherAlbumPanel) AlbumPanelFactory.getAlbumPanel()).addAlbumToLibrary();
    }

    public List<TrackWrapper> getMyTracks() {
        if ($(EMPTY_TRACKLIST_WRAPPER).exists()) {
            return new ArrayList<>();
        }
        return getTracks();
    }

    public void clearLibrary() {
        removeMyTracks();
        removeMyAlbums();
    }

    public String getAlbumTitle() {
        return AlbumPanelFactory.getAlbumPanel().getTitle();
    }

    public int getAlbumTracksAmount() {
        return AlbumPanelFactory.getAlbumPanel().getTracksAmount();
    }

    /**
     * Заходит на страницу первого альбома в библиотеке
     */
    public void goToFirstLibraryAlbum() {
        leftMusicPanel.goToFirstLibraryAlbum();
    }

    private TrackWrapper addTrack(String trackName) {
        SelenideElement addedMsg = $(byXpath("//*[contains(@data-l, 'similar-tracks')]")); // msg - трек был добавлен
        SelenideElement closeMsg =  addedMsg.$(byAttribute("data-l", "t,close"));
        List<TrackWrapper> allTracks = getTracks();
        for (var track: allTracks) {
            if (track.getTitle().contains(trackName)) {
                track.addTrackToLibrary();
                addedMsg.shouldBe(visible.because("Не появилось сообщение о добавлении трека"));
                closeMsg.shouldBe(visible.because("Нет крестика для закрытия сообщения о добавлении трека")).click();
                return track;
            }
        }
        return null;
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

    @Override
    public void validate() {
        MSC_PAGE_CONTAINER.shouldBe(visible.because("Не прогрузился контейнер страницы с музыкой"));
    }
}
