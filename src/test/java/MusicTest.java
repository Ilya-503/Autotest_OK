import com.google.common.collect.Lists;
import org.junit.jupiter.api.*;
import pages.loginPage.LoginPage;
import pages.mainPage.MainPage;
import pages.musicPage.MusicPage;
import pages.musicPage.wrappers.TrackWrapper;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("Проверка работоспособности добавления треков в библиотеку")
    public void addTracksToLibrary() {
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

    @Test
    public void addAlbumToLibrary() {
        musicPage.goToAlbums();
        musicPage.goToFirstAlbumAndAddIt();
        var expectedTracks = musicPage.getTracks();
        String expectedTitle = musicPage.getAlbumTitle();
        int expectedTracksAmount = musicPage.getAlbumTracksAmount();
        musicPage.goToLibrary();
        musicPage.goToFirstLibraryAlbum();

        assertAll(
                () -> assertEquals(expectedTitle, musicPage.getAlbumTitle()),
                () -> assertEquals(expectedTracksAmount, musicPage.getAlbumTracksAmount()),
                () -> assertEquals(expectedTracks, musicPage.getTracks())
        );
    }

    @AfterEach
    public void clearLibrary() {
        musicPage.goToLibrary();
        musicPage.goToLibrary();
        musicPage.clearLibrary();
        // WebDriverRunner.closeWebDriver();
    }

}

// prepareToTest -> go to music page
// write matcher to compare tracks
