package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class RegistrationPage {
    private WebDriver driver;
    private final By namePlaceHolder = By.xpath("//label[text()='Имя']/parent::div/input[@name='name']");
    private final By emailPlaceHolder = By.xpath("//label[text()='Email']/parent::div/input[@name='name']");
    private final By passwordPlaceHolder = By.xpath("//input[@name='Пароль']");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath("//a[@href = '/login']");
    private final By badPassText = By.xpath("//p[text()='Некорректный пароль']");
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Заполнить поля имя, почта, пароль и нажать кнопку зарегистрироваться")
    public void fillRegForm(String name, String email, String password){
        driver.findElement(namePlaceHolder).sendKeys(name);
        driver.findElement(emailPlaceHolder).sendKeys(email);
        driver.findElement(passwordPlaceHolder).sendKeys(password);
        driver.findElement(registrationButton).click();
    }
    @Step("Проверить что появилась надпись про неверный пароль")
    public void presentBadPassText(){
       /* new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(badPassText));*/
        WebElement presentOrderButton = driver.findElement(badPassText);
        assertTrue(presentOrderButton.isDisplayed());
    }
    @Step("нажать на кнопку Войти")
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
}
