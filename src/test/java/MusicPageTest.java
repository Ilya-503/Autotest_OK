import com.codeborne.selenide.Selenide;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.*;
import pages.mainPage.MainPage;
import pages.musicPage.MusicPage;
import pages.musicPage.wrappers.TrackWrapper;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MusicPageTest extends BaseTest {

    private MusicPage musicPage;

    @BeforeEach
    public void prepareTest() {
        logIn();
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
        assertEquals(Lists.reverse(expectedTracks), musicPage.getMyTracks(),
                "Треки в библиотеке не совпадают с ожидаемами");
    }

    @Test
    @DisplayName("Проверка добавления альбома в библиотеку")
    public void addAlbumToLibrary() {
        musicPage.goToAlbums();
        musicPage.goToFirstAlbumAndAddIt();
        var expectedTracks = musicPage.getTracks();
        String expectedTitle = musicPage.getAlbumTitle();
        int expectedTracksAmount = musicPage.getAlbumTracksAmount();

        musicPage.goToLibrary().goToFirstLibraryAlbum();

        assertAll(
                () -> assertEquals(expectedTitle, musicPage.getAlbumTitle(),
                        "Название альбом не совпадает с ожидаемым"),
                () -> assertEquals(expectedTracksAmount, musicPage.getAlbumTracksAmount(),
                        "Количество треков не совпадает с ожидаемым"),
                () -> assertEquals(expectedTracks, musicPage.getTracks(),
                        "Треки альбома не соотвествуют ожидаемым")
        );
    }

    @AfterEach
    public void clearLibrary() {
        musicPage.goToLibrary().clearLibrary();
        Selenide.closeWebDriver(); // del repeat
    }
}

