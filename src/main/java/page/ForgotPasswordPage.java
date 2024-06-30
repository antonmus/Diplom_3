package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;
    private final By enterButton = By.xpath("//a[@href = '/login']");
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("нажать на кнопку Войти")
    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }
}
