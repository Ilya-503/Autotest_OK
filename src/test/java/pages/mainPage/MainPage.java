package pages.mainPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.Loadable;
import pages.messagePage.MessagePage;
import pages.musicPage.MusicPage;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements Loadable {

    private final UpperToolBar upperToolBar;
    private final static By NOTE_FIELD = byText("Напишите заметку");
    private final static By UPPER_TOOL_BAR =
            byAttribute("data-l", "t,navigationToolbar");


    public MainPage() {
        upperToolBar = new UpperToolBar($(UPPER_TOOL_BAR));
        validate();
    }

    public SelenideElement getNoteFiled() {
        return $(NOTE_FIELD);
    }

    public MusicPage goToMusicPage() {
        upperToolBar.goToMusicPage();
        return new MusicPage();
    }

    public MessagePage goToDialogs() {
        upperToolBar.goToDialogs();
        return new MessagePage();
    }

    @Override
    public void validate() {
        upperToolBar.isVisible();
    }
}
