package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class PersAccountPage {
    WebDriver driver;
    private final By persAccLabel = By.xpath("//p[text()='Личный Кабинет']");
    private final By profilButton = By.xpath("//a[@href = '/account/profile']");
    private final By exitButton = By.xpath("//button[text()='Выход']");
    private final By constructorButton = By.xpath("//p[text()='Конструктор']");
    private final By burgerLogo = By.xpath("//div/a");
    public PersAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("проверка что есть лейбл личный кабинет, кнопка перехода в профиль, в кострукор и кнопка выход")
    public void persAccTest(){
       /* new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(persAccLabel));*/
        WebElement persAccTest1 = driver.findElement(persAccLabel);
        assertTrue(persAccTest1.isDisplayed());
        WebElement persAccTest2 = driver.findElement(profilButton);
        assertTrue(persAccTest2.isDisplayed());
        WebElement persAccTest3 = driver.findElement(exitButton);
        assertTrue(persAccTest3.isDisplayed());
        WebElement persAccTest4 = driver.findElement(constructorButton);
        assertTrue(persAccTest4.isDisplayed());
    }
    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton(){
        driver.findElement(constructorButton);
    }
    @Step("Нажать на логотип")
    public void clickLogo(){
        driver.findElement(burgerLogo);
    }
    @Step("Нажать на кнопку выход")
    public void clickExitButton(){
      /*  new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(exitButton));*/
       driver.findElement(exitButton).click();
    }
}
