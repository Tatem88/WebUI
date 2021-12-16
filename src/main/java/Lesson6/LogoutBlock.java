package Lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutBlock extends BaseView {
    public LogoutBlock(WebDriver driver) {
        super(driver);
    }

    void logout () {
        driver.findElement(By.xpath("//*[@id=\\\"pt-logout\\\"]")).click();
    }

}