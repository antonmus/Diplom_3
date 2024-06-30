import api.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.*;
import testData.User;
import java.util.concurrent.TimeUnit;
import static api.EndPoint.HOST;
public class PersAccountTests {
    private WebDriver driver;
    private final UserSteps userSteps = new UserSteps();
    User user;
    MainPageBurger mainPageBurger;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;
    PersAccountPage persAccountPage;
    @Before
    public void setup() {
        user = new User();
        user.setUser();

        driver = WebDriverFactory.getDriver();
        driver.get(HOST);

        mainPageBurger = new MainPageBurger(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        persAccountPage = new PersAccountPage(driver);

        userSteps.createUser(user);

        mainPageBurger.clickPersAccButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @Test
    @DisplayName("переход по клику на «Личный кабинет»")
    public void enterPersAccountTest(){
        mainPageBurger.clickPersAccButton();
    }
    @Test
    @DisplayName("Переход в конструктор нажатием на кнопку коструктора")
    public void enterConstructor(){
        mainPageBurger.clickPersAccButton();
        persAccountPage.clickConstructorButton();
    }
    @Test
    @DisplayName("Переход в конструктор нажатием на лого")
    public void enterConstructorClickLogo(){
        mainPageBurger.clickPersAccButton();
        persAccountPage.clickLogo();
    }
    @Test
    @DisplayName("Выход из аккаунта")
    public void exitAccount(){
        mainPageBurger.clickPersAccButton();
        persAccountPage.clickExitButton();
        loginPage.findLoginPage();
    }
    @After
    public void tearDown() {
        user.setAccessToken(userSteps
                .loginUser(user)
                .extract().body().path("accessToken"));
        userSteps
                .deleteUser(user);
        driver.quit();
    }
}
