import pages.loginPage.LoginPage;

public class Step {

    private Step() {}

    public static void logIn() {
        new LoginPage()
                .setLogin("technoPol17")
                .setPassword("technoPolis2022")
                .submit();
    }
}
