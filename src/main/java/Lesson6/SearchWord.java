package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class SearchWord extends MainPage  {

    public SearchWord(WebDriver driver) {

        super(driver);
    }


    private final static String searchInputLocatorById = "searchInput";

    @FindBy(id = searchInputLocatorById)
    private WebElement searchInput;

    @Step("Ввод значения в поле поиска")
    public MainPage fillSearchInput(String s) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(searchInputLocatorById)));
        searchInput.sendKeys(s);
        return new MainPage(driver);
    }

}
