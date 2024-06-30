package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class LoginPage {
    private WebDriver driver;
    private final By enterHeader = By.xpath("//h2[text()='Вход']");
    private final By emailPlaceHolder = By.xpath("//label[text()='Email']/parent::div/input[@name='name']");//странный атрибуь для поля email на мой взгляд
    private final By passwordPlaceHolder = By.xpath("//input[@name='Пароль']");
    private final By registrationButton = By.xpath("//a[@href = '/register']");//написал локатор по ссылке, а не по тексту, так как  посчитал, что текст поменяют раньше апишки
    private final By forgotPasswordButton = By.xpath("//a[@href = '/forgot-password']");
    private final By enterButton = By.xpath("//button[text()='Войти']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Нажать на кнопку зарегистрироваться")
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    @Step("Заполнить поля почта и пароль и нажать кнопку войти")
    public void fillLoginForm(String email, String password){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(enterButton));
        driver.findElement(emailPlaceHolder).sendKeys(email);
        driver.findElement(passwordPlaceHolder).sendKeys(password);
        driver.findElement(enterButton).click();
    }
    @Step("Нажать на кнопку восстановления пароля")
    public void clickForgotPassButton(){
        driver.findElement(forgotPasswordButton).click();
    }
    @Step("Проверить, что мы на странице авторизации")
    public void findLoginPage(){
      /*  new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(enterHeader));*/
        WebElement presentOrderButton = driver.findElement(enterHeader);
        assertTrue(presentOrderButton.isDisplayed());
    }
}
