import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.musicPage.MusicPage;

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
        musicPage.findTrack("Эд ширан shape");
        musicPage.addTrackToLibrary("Shape of You");
        musicPage.findTrack("Градусы");
        musicPage.addTrackToLibrary("Голая");
        musicPage.findTrack("Ленинград");
        musicPage.addTrackToLibrary("Вояж");
        musicPage.goToLibrary();
        var myTracks = musicPage.getMyTracks();
        for (var track: myTracks) {
            System.out.println(track.getTrackInfo());
        }


    }

//    @AfterEach
//    public void clearLibrary() {
//        MusicPage ms = new MusicPage();
//        ms.goToLibrary();
//        WebDriverRunner.closeWebDriver();
//    }

}

// prepareToTest -> go to music page