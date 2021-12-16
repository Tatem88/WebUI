package Lesson6;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WikiTest {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String WIKI_BASE_URL = "https://ru.wikipedia.org/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(WIKI_BASE_URL);
    }

    @Test
    void CheckingAuthorizationForm() throws InterruptedException {
        new MainPage(driver).clickByXpath("//*[@id=\"pt-login\"]/a/span");
        new LoginBlock(driver)
                .fillLoginInput("Tatkuz")
                .fillPasswordInput("151725qwe")
                .clickById("wpLoginAttempt");
        Thread.sleep(5000);

        new LogoutBlock(driver);
    }

    @Test
    void CheckingSearching() throws InterruptedException {
        new MainPage(driver).clickByXpath("//*[@id=\"pt-login\"]/a/span");

        new LoginBlock(driver)
                .fillLoginInput("Tatkuz")
                .fillPasswordInput("151725qwe")
                .clickById("wpLoginAttempt");
        new SearchWord(driver)
                .fillSearchInput("Автоматизированное тестирование")
                .clickById("searchButton");
        Thread.sleep(5000);
        new LogoutBlock(driver);
    }
    @Test
    void followingLink() throws InterruptedException {
        new SearchWord(driver)
                .fillSearchInput("тестирование")
                .clickByXpath("//*[@title=\"Тестирование программного обеспечения\"]");
    }

    @Test
    void AbilitySwitchMediaWiki() throws InterruptedException {
        new MainPage(driver)
                .clickByXpath("//span[text()='Медиавики']");
        Thread.sleep(5000);
    }

    @Test
    void searchWiktionary() throws InterruptedException {
        new SearchWord(driver)
                .clickByXpath("//*[text()='Викисловарь']");
        new SearchWord(driver)
                .fillSearchInput("лапидарность")
                .clickById("searchButton");
        Thread.sleep(5000);
    }

    @Test
    void Statistics() throws InterruptedException {
        new MainPage(driver)
                .clickById("footer-places-statslink");
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}