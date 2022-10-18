package selenidePractise;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class ArticlesPage {

    private final ElementsCollection articleTitles = $$(byXpath("//h2//a"));

    public  String getHrefFromFirst() {
        return articleTitles.first().getAttribute("href");
    }

}
