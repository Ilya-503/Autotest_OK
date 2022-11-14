package pages.musicPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.Loadable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<TrackWrapper> getTracks(SelenideElement item) {
        List<TrackWrapper> list = new ArrayList<>();
        ElementsCollection coll = item.$$(byTagName("wm-track"));
        for (var elem : coll) {
            //System.out.println(elem.text());
            TrackWrapper track = new TrackWrapper(elem);
            list.add(track);
        }
        return list;
    }

    public String getTrackInfo(TrackWrapper track) {
        return track.getTrackInfo();
    }

    @Override
    public void validate() {
        MSC_PAGE_CONTAINER.shouldBe(visible);
    }
}
