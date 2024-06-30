import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.*;
import static api.EndPoint.HOST;
public class ConstructorTest {
    private WebDriver driver;
    MainPageBurger mainPageBurger;
    @Before
    public void setup() {
        driver = WebDriverFactory.getDriver();
        driver.get(HOST);
        mainPageBurger = new MainPageBurger(driver);
    }
    @Test
    @DisplayName("проверка конструктора")
    public void constructorTest(){
        mainPageBurger.constructorTest();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
