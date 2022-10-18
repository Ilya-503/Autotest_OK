package selenidePractise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchPageTest {

    private final String URL = "https://appleinsider.ru/";
    private final String SEARCH_STRING = "чем iphone 13 отличается от iphone 12";
    private final String EXPECTED_WORD = "iphone-13";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void test() {
        assertTrue(new SearchPage(URL)
                .clickOnLupa(SEARCH_STRING)
                .getHrefFromFirst()
                .contains(EXPECTED_WORD));
    }

    @Test
    public void openHrefs() throws InterruptedException {
        open("https://en.wikipedia.org/wiki/Vikings_(TV_series)");
        ElementsCollection collection = $$x("//div[@id = 'toc']//a[@href]");
        List<String> links = new ArrayList<>();
        collection.forEach(x -> links.add(x.getAttribute("href")));
        for (int i = 0; i < links.size(); i++) {
            String listUrl = links.get(i);
            open(listUrl);
            String curUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            assertEquals(curUrl, listUrl);
        }
    }
}
