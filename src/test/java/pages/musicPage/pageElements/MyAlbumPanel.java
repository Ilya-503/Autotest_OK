package pages.musicPage.pageElements;

import com.codeborne.selenide.SelenideElement;
import pages.musicPage.factories.AlbumPanel;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class MyAlbumPanel extends AlbumPanel {

    private static final SelenideElement SUBMIT_BTN =
            $(byClassName("buttons")).$(byAttribute("data-l", "t,submit"));

    @Override
    public void shareAlbum() {
        ROOT_ELEM.$(SHARE_ELEM)
                .shouldBe(visible.because("Нет кнопки 'поделиться' добавленным альбомом"))
                .click();
    }

    @Override
    public void removeAlbum() {
        ROOT_ELEM
                .$(OPTIONS_ELEM).shouldBe(visible.because("Нет кнопки с доп. действиями с добавл. альбомом")).hover()
                .$(DELETE_ALB_ELEM).shouldBe(visible.because("Нет кнопки удаления добавленного альбома")).click();
        SUBMIT_BTN.shouldBe(visible.because("Нет кнопки подтверждения удаления")).click();
    }

}
