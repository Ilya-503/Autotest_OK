package pages.musicPage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;

public class AlbumPanelFactory {

    public static AlbumPanel getAlbumPanel() {
        return AlbumPanel.isOwnAlbum() ? new MyAlbumPanel() : new OtherAlbumPanel();
    }
}
