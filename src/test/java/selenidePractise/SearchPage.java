package selenidePractise;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchPage {

    private final SelenideElement inputField =  $(byName("s"));

    SearchPage(String URL) {
        open(URL);
    }

    public ArticlesPage clickOnLupa(String str) {
        inputField.setValue(str).sendKeys(Keys.ENTER);
        return new ArticlesPage();
    }
}
