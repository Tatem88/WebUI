package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWiki {
    public static void main(String[] args) throws InterruptedException {
       one();
       two();
       three ();
       four ();
    }
          // Тест-кейс 1. Проверка формы авторизации
    public static void one () throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://ru.wikipedia.org/"); // Главная страница Википедии
            driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span")).click(); // кликнула по кнопке Войти
            WebElement loginField = driver.findElement(By.id("wpName1")); // нашла поле логин
            loginField.sendKeys("Tatkuz"); // ввела логин
            driver.findElement(By.id("wpPassword1")).sendKeys("151725qwe"); // ввела пароль
            driver.findElement(By.id("wpLoginAttempt")).click(); // нажала кнопку Войти
            Thread.sleep(5000); // подождала 5 сек
            driver.findElement(By.id("pt-logout")).click();
            Thread.sleep(5000); // подождала 5 сек
            driver.quit();
        }

        // Тест-кейс 2. Поиск статьи по автоматизированному тестированию в Википедии
        public static void two() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ru.wikipedia.org/"); // Главная страница Википедии
        driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span")).click(); // кликнула по кнопке Войти
        WebElement loginField = driver.findElement(By.id("wpName1")); // нашла поле логин
        loginField.sendKeys("Tatkuz"); // ввела логин
        driver.findElement(By.id("wpPassword1")).sendKeys("151725qwe"); // ввела пароль
        driver.findElement(By.id("wpLoginAttempt")).click(); // нажала кнопку Войти
        driver.findElement(By.id("searchInput")).sendKeys("Автоматизированное тестирование");// кликнула по полю Искать в Википедии
        driver.findElement(By.id("searchButton")).click(); // кликнула поиск
        Thread.sleep(5000); // подождала 5 сек
        driver.findElement(By.id("pt-logout")).click();
        Thread.sleep(5000); // подождала 5 сек
        driver.quit();
    }

        // Тест-кейс 3. Проверка возможности перехода по ссылке
        public static void three () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://ru.wikipedia.org/"); // Главная страница Википедии
            driver.findElement(By.id("searchInput")).sendKeys("Тестирование");// кликнула по полю Искать в Википедии
            driver.findElement(By.id("searchButton")).click(); // кликнула поиск
            Thread.sleep(5000); // подождала 5 сек
            driver.findElement(By.xpath("//*[@title=\"Тестирование программного обеспечения\"]")).click();
            Thread.sleep(5000); // подождала 5 сек
            driver.quit();
        }

       // Тест-кейс 4. Возможность перехода на MediaWiki
    public static void four () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://ru.wikipedia.org/"); // Главная страница Википедии
        Thread.sleep(5000); // подождала 5 сек
        driver.findElement(By.xpath("//span[text()='Медиавики']")).click();
        Thread.sleep(5000); // подождала 5 сек
        driver.quit();
    }

        }



