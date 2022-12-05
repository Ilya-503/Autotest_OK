package pages.musicPage.pageElements;

import org.openqa.selenium.By;
import pages.musicPage.factories.AlbumPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;

public class OtherAlbumPanel extends AlbumPanel {

    private static final By ADD_BTN = byAttribute("data-l", "t,add");

    @Override
    public void shareAlbum() {
        ROOT_ELEM
                .$(OPTIONS_ELEM).shouldBe(visible.because("Нет кнопки доп. действий с альбомом")).hover()
                .$(SHARE_ELEM).shouldBe(visible.because("Нет кнопки 'поделиться' альбомом")).click();
    }

    @Override
    public void removeAlbum() {
        ROOT_ELEM.$(DELETE_ALB_ELEM)
                .shouldBe(visible.because("Нет кнопки удаления альбома из библиотеки"))
                .click();
    }

    public void addAlbumToLibrary() {
        ROOT_ELEM.$(ADD_BTN)
                .shouldBe(visible.because("Нет кнопки добавления альбома в библиотеку"))
                .click();
    }
}
