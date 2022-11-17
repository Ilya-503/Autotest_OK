package pages.musicPage;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class MyAlbumPanel extends AlbumPanel {

    @Override
    public void shareAlbum() {
        ROOT_ELEM.$(SHARE_ELEM).click();
    }

    @Override
    public void removeAlbum() {
        ROOT_ELEM.$(OPTIONS_ELEM).hover().$(DELETE_ALB_ELEM).click();
        $(byClassName("buttons")).$(byAttribute("data-l", "t,submit")).click();
    }

}
