package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("user-agent=Googlebot/2.1 (+https://google.com/bot.html)");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
        Thread.sleep(5000);
        //driver.quit();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        List<String> tabs =  new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        driver.quit();

    }
}
