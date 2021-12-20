package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step("Клик по элементу с заданным Xpath")
    public MainPage clickByXpath(String s) {
        WebElement buttonByXpath = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
        buttonByXpath.click();
        return this;
    }
    @Step("Клик по элементу с заданным Id")
    public MainPage clickById(String s) {
        WebElement buttonById = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(s)));
        buttonById.click();
        return this;
    }

}
