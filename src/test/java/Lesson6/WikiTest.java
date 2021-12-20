package Lesson6;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
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
    @Description("Тест проверки возможности авторизоваться в Wiki и разлогиниться")
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
    @Description("Тест поискового поля")
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
    @Description("Тест возможности перехода по ссылке из текста")
    void followingLink() throws InterruptedException {
        new SearchWord(driver)
                .fillSearchInput("тестирование")
                .clickByXpath("//*[@title=\"Тестирование программного обеспечения\"]");
    }

    @Test
    @Description("Тест возможности перехода по ссылке в Медиавики")
    void AbilitySwitchMediaWiki() throws InterruptedException {
        new MainPage(driver)
                .clickByXpath("//span[text()='Медиавики']");
        Thread.sleep(5000);
    }

    @Test
    @Description("Тест перехода в Викисловарь и поиска в нём значения")
    void searchWiktionary() throws InterruptedException {
        new SearchWord(driver)
                .clickByXpath("//*[text()='Викисловарь']");
        new SearchWord(driver)
                .fillSearchInput("лапидарность")
                .clickById("searchButton");
        Thread.sleep(5000);
    }

    @Test
    @Description("Тест перехода к статистике Wiki")
    void Statistics() throws InterruptedException {
        new MainPage(driver)
                .clickById("footer-places-statslink");
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}