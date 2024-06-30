package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainPageBurger {
    private  WebDriver driver;
    private final By persAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By logInButton = By.xpath("//button[text()='Войти в аккаунт']");

    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By bunTab = By.xpath("//span[text()='Булки']");
    private final By sauceTab = By.xpath("//span[text()='Соусы']");
    private final By fillingTab = By.xpath("//span[text()='Начинки']");
    private final By selectedTab = By.xpath("//div[contains(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10')]");//выбранная вкладка ингредиентов

    public MainPageBurger(WebDriver driver){
        this.driver = driver;
    }
    @Step("Нажать на кнопку личного кабинета")
    public void clickPersAccButton(){
        driver.findElement(persAccountButton).click();
    }
    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLogInButton(){
        driver.findElement(logInButton).click();
    }
    @Step("Проверить появление кнопки оформить заказ")
    public void presentOrderButton(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        WebElement presentOrderButton = driver.findElement(createOrderButton);
        assertTrue(presentOrderButton.isDisplayed());
    }
    @Step("Перейти по всем вкладкам конструктора и проверить активность соответствующей вкладки")
    public void constructorTest(){
        //driver.findElement(bunTab).click();
        WebElement bun = driver.findElement(selectedTab);
        assertEquals("Булки", bun.getText());

        driver.findElement(sauceTab).click();
        WebElement sauce = driver.findElement(selectedTab);
        assertEquals("Соусы", sauce.getText());

        driver.findElement(fillingTab).click();
        WebElement filling = driver.findElement(selectedTab);
        assertEquals("Начинки", filling.getText());
    }
}
