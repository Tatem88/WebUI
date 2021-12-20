package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class LoginBlock extends MainPage {
    public LoginBlock(WebDriver driver) {
        super(driver);
    }
    @Step("Клик по кнопке Войти")
   void login () {
       driver.findElement(By.xpath("//*[@id=\"pt-login\"]/a/span")).click();
   }

    private final static String loginInputLocatorById = "wpName1"; // поле логин
    @FindBy(id = loginInputLocatorById)
    private WebElement loginInput;

@Step ("Ввод в поле логин имя пользователя")
    public LoginBlock fillLoginInput(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginInputLocatorById)));
        loginInput.sendKeys(login);
        return this;
    }


        @FindBy(id = "wpPassword1") // поле пароль
        private WebElement passwordInput;

    @Step ("Ввод в поле пароль пользователя")
        public LoginBlock fillPasswordInput (String password){
            passwordInput.sendKeys(password);
            return this;
        }


        @FindBy(xpath = "//span[.='Войти']") // кнопка Войти, чтобы залогиниться
        private WebElement SubmitLoginButton;

    @Step ("Нажать кнопку Войти")
     public MainPage SubmitLoginButton() {
         assertThat(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]")), isDisplayed());
        return new MainPage(driver);
    }
}


