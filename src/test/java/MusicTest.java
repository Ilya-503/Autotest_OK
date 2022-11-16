import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.musicPage.MusicPage;
import pages.musicPage.TrackWrapper;

import javax.sound.midi.Track;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicTest extends BaseTest {

    private MusicPage musicPage;

    @BeforeEach
    public void prepareTest() {
        new LoginPage("https://ok.ru/")
                .setLogin("technoPol17")
                .setPassword("technoPolis2022")
                .submit();
        musicPage = new MainPage().goToMusicPage();
    }

    @Test
    public void test() {
        List<TrackWrapper> expectedTracks = new ArrayList<>();
        Map<String, String> tracksInfo = new HashMap<>();
        tracksInfo.put("Градусы", "Голая");
        tracksInfo.put("Ленинград", "Вояж");
        tracksInfo.put("arctic monkeys", "Do I");

        for (var elem: tracksInfo.entrySet()) {
            musicPage.findTrack(elem.getKey());
            expectedTracks.add(
                    musicPage.addTrackToLibrary(
                            elem.getValue()
                    )
            );
        }
        musicPage.goToLibrary();
        assertEquals(Lists.reverse(expectedTracks), musicPage.getMyTracks());
    }

    @AfterEach
    public void clearLibrary() {
        musicPage.goToLibrary();
        musicPage.clearLibrary();
        // WebDriverRunner.closeWebDriver();
    }

}

// prepareToTest -> go to music page
// write matcher to compare tracks
