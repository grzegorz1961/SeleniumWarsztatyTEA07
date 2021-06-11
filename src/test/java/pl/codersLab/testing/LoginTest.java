package pl.codersLab.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.codersLab.function.LoginSetUp;
import pl.codersLab.pages.LoginPage;

public class LoginTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        this.driver = LoginSetUp.setUp();
    }

    @Test
    public void loginTest() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("krwrseepkmzaomxhbv@twzhhq.online", "Pass123");
    }

    @After
    public void tearDown() {
       driver.quit();
    }
}
