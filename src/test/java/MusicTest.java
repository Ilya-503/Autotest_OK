import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.musicPage.MusicPage;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

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
        var tracks =
                musicPage.getTracks($(byAttribute("data-l", "t,top_tracks_list")));
        for (var el: tracks) {
            System.out.println(el.getTrackInfo());
        }
    }

}
