package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage {

    private SelenideElement noteField = $(byText("Напишите заметку"));

    public SelenideElement getNoteFiled() {
        return noteField;
    }
}
