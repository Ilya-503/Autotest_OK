package pages.musicPage.pageElements;

import org.openqa.selenium.By;
import pages.musicPage.factories.AlbumPanel;

import static com.codeborne.selenide.Selectors.byAttribute;

public class OtherAlbumPanel extends AlbumPanel {

    private static final By ADD_BTN = byAttribute("data-l", "t,add");

    @Override
    public void shareAlbum() {
        ROOT_ELEM.$(OPTIONS_ELEM).hover().$(SHARE_ELEM).click();
    }

    @Override
    public void removeAlbum() {
        ROOT_ELEM.$(DELETE_ALB_ELEM).click();
    }

    public void addAlbumToLibrary() {
        ROOT_ELEM.$(ADD_BTN).click();
    }
}
