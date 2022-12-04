package pages.mainPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;

public class UpperToolBar {

    private SelenideElement rootElem;

    private static final By MESSAGES = byAttribute("data-l", "t,messages");
    private static final By MUSIC = byAttribute("data-l", "t,music");

    public UpperToolBar(SelenideElement rootElem) {
        this.rootElem = rootElem;
    }

    public void goToMusicPage() {
        rootElem.$(MUSIC).shouldBe(visible.because("Нет элемента страницы музыки")).click();
    }

    public void goToDialogs() {
        rootElem.$(MESSAGES).shouldBe(visible.because("Нет элемента страницы сообщений")).click();
    }

    public boolean isVisible() {
        return rootElem.is(visible.because("Не прогрузился элемент верхнего тул бара"));
    }
}
