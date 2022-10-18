import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class FirstTest {

    public static LoginPage loginPage;
    public static WebDriver driver;

    @BeforeClass
    public static void init() {
        System.setProperty("chromedriver.exe", ConfProperties.getProperty("driver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url"));
    }

    @Test
    public void testLogin() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
       // loginPage.submit();
        assertEquals("https://ok.ru/", driver.getCurrentUrl());
    }

    @After
    public void close() {
        driver.close();
    }
}
