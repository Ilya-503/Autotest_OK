package pages.musicPage.factories;

import pages.musicPage.pageElements.MyAlbumPanel;
import pages.musicPage.pageElements.OtherAlbumPanel;

public class AlbumPanelFactory {

    public static AlbumPanel getAlbumPanel() {
        return AlbumPanel.isOwnAlbum() ? new MyAlbumPanel() : new OtherAlbumPanel();
    }
}
