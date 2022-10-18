package firstHomeTask;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class NewsPage {

    private SelenideElement noteField = $(byAttribute("data-l", "t,mainpf_open"));

    public SelenideElement getNoteFiled() {
        return noteField;
    }
}
