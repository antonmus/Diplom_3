import api.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MainPageBurger;
import page.RegistrationPage;
import testData.User;
import static api.EndPoint.HOST;

public class LoginTest {
    private WebDriver driver;
    private final UserSteps userSteps = new UserSteps();
    User user;
    MainPageBurger mainPageBurger;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    ForgotPasswordPage forgotPasswordPage;
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

        userSteps.createUser(user);
    }
    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void enterButtonLoginTest(){
        mainPageBurger.clickLogInButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPageBurger.presentOrderButton();
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void persAccountButtonLoginTest() {
        mainPageBurger.clickPersAccButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPageBurger.presentOrderButton();
    }
    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void formRegLoginTest() {
        mainPageBurger.clickLogInButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickEnterButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPageBurger.presentOrderButton();
    }
    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void forgotPassLoginTest() {
        mainPageBurger.clickLogInButton();
        loginPage.clickForgotPassButton();
        forgotPasswordPage.clickEnterButton();
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPageBurger.presentOrderButton();
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
