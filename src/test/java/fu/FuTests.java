package fu;

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

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class FuTests {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String FU_BASE_URL = "https://furor-dev-4.nrpo.ntc-vulkan.ru/login";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(FU_BASE_URL);
    }

    @Test
    void authorization () throws InterruptedException {
        Thread.sleep(5000);
        Assertions.assertEquals(driver.findElement(By.xpath("//h3[text()='Вход в систему']")).isDisplayed(),true);
        login();
        Assertions.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]")).isDisplayed(),true);
    }


    @Test
    void transitionDataManagement () throws InterruptedException {
        Thread.sleep(5000);
        Assertions.assertEquals(driver.findElement(By.xpath("//h3[text()='Вход в систему']")).isDisplayed(),true);
        login();
        Assertions.assertEquals(driver.findElement(By.id("root")).isDisplayed(),true);
        driver.findElement(By.xpath("//*[@id=\"root\"][1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]")).click();
      //  Assertions.assertEquals(driver.findElement(By.xpath("//div[text()='Физические объекты']")).isDisplayed(),true);
        Thread.sleep(5000);
    }



    @AfterEach
    void tearDown() {
        driver.quit();
    }

    void login() throws InterruptedException {
        WebElement loginField = driver.findElement(By.xpath("//*[@name='username']"));
        loginField.sendKeys("admin");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@id=\"root\"]")).click();
        Thread.sleep(5000);
    }
}

