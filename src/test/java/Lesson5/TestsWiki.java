package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class TestsWiki {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String WIKI_BASE_URL = "https://ru.wikipedia.org/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(WIKI_BASE_URL);
    }

    @Test
    void CheckingAuthorizationForm () throws InterruptedException {
        login();
        Assertions.assertEquals(driver.findElement(By.id("Добро_пожаловать_в_Википедию,")).isDisplayed(),true);
        driver.findElement(By.xpath("//*[@id=\"pt-logout\"]")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]")), isDisplayed());
    }

    @Test
    void articleAutomatedTestingOnWiki() throws InterruptedException {
        login();
        driver.findElement(By.id("searchInput")).sendKeys("Автоматизированное тестирование");
        driver.findElement(By.id("searchButton")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//h1[text()='Автоматизированное тестирование']")).isDisplayed(),true);
        driver.findElement(By.id("pt-logout")).click();
        assertThat(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]")), isDisplayed());
    }

    @Test
    void followingLink () throws InterruptedException {
        driver.findElement(By.id("searchInput")).sendKeys("Тестирование");
        driver.findElement(By.id("searchButton")).click();
        assertThat(driver.findElement(By.xpath("//h1[text()='Тест']")), isDisplayed());
        driver.findElement(By.xpath("//*[@title=\"Тестирование программного обеспечения\"]")).click();
        assertThat(driver.findElement(By.xpath("//h1[text()='Тестирование программного обеспечения']")), isDisplayed());
    }

    @Test
    void AbilitySwitchMediaWiki  () throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Медиавики']")).click();
        assertThat(driver.findElement(By.xpath(" //*[text()='MediaWiki']")), isDisplayed());
    }

    @Test
    void searchWiktionary() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Викисловарь']")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"p-logo\"]/a")).isDisplayed(), true);
        driver.findElement(By.id("searchInput")).sendKeys("лапидарность");
        driver.findElement(By.id("searchButton")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[text()='лапидарность']")).isDisplayed(), true);
        driver.findElement(By.xpath("//*[@id=\"ca-history\"]")).click();
        JavascriptExecutor Scrool = (JavascriptExecutor) driver;
        Scrool.executeScript("window.scrollBy(0,300)", "");
        Scrool.executeScript("window.scrollBy(0,-300)", "");
    }

    @Test
    void Statistics() throws InterruptedException {
        JavascriptExecutor Scrool = (JavascriptExecutor) driver;
        Scrool.executeScript("window.scrollBy(0,300)", "");
        driver.findElement(By.id("footer-places-statslink")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//span[text()='Wikimedia Statistics']")).isDisplayed(), true);
    }



    @AfterEach
    void tearDown() {
        driver.quit();
    }

    void login() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span")).click();
        WebElement loginField = driver.findElement(By.id("wpName1"));
        loginField.sendKeys("Tatkuz");
        driver.findElement(By.id("wpPassword1")).sendKeys("151725qwe");
        driver.findElement(By.id("wpLoginAttempt")).click();
        Thread.sleep(5000);
    }
}


