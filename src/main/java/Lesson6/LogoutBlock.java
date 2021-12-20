package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutBlock extends BaseView {
    public LogoutBlock(WebDriver driver) {
        super(driver);
    }
    @Step("Нажать кнопку Выход")
    void logout () {
        driver.findElement(By.xpath("//*[@id=\\\"pt-logout\\\"]")).click();
    }

}