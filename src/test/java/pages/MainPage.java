package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.compress.archivers.zip.UnicodePathExtraField;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage implements Loadable {

    private final UpperToolBar upperToolBar;
    private final static SelenideElement NOTE_FIELD = $(byText("Напишите заметку"));

    public MainPage() {
        upperToolBar = new UpperToolBar();
        validate();
    }

    public SelenideElement getNoteFiled() {
        return NOTE_FIELD;
    }

    public MusicPage goToMusicPage() {
        upperToolBar.goToMusicPage();
        return new MusicPage();
    }

    @Override
    public void validate() {
        upperToolBar.isDisplayed();
    }
}
