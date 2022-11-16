import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.musicPage.MusicPage;
import pages.musicPage.TrackWrapper;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicTest extends BaseTest {

    @BeforeEach
    public void prepareTest() {
        new LoginPage("https://ok.ru/")
                .setLogin("technoPol17")
                .setPassword("technoPolis2022")
                .submit();
    }

    @Test
    public void test() {
        MusicPage musicPage = new MainPage().goToMusicPage();
        List<Track> expectedTracks = new ArrayList<>();
        Map<String, String> tracksName = new HashMap<>();
        tracksName.put("Эд ширан shape", "Shape of You");
        tracksName.put("Градусы", "Голая");
        tracksName.put("Ленинград", "Вояж");

        for (var trackAuthor: tracksName.keySet()) {
            musicPage.findTrack(trackAuthor);
            musicPage.addTrackToLibrary(tracksName.get(trackAuthor));
            expectedTracks.add(musicPage.)
        }

        musicPage.goToLibrary();
    }

//    @AfterEach
//    public void clearLibrary() {
//        MusicPage ms = new MusicPage();
//        ms.goToLibrary();
//        WebDriverRunner.closeWebDriver();
//    }

}

// prepareToTest -> go to music page
// write matcher to compare tracks
