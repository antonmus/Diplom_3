import api.UserSteps;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import page.MainPageBurger;
import page.RegistrationPage;
import testData.User;
import java.util.concurrent.TimeUnit;
import static api.EndPoint.HOST;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
public class RegistrationTests {
    private WebDriver driver;
    private final UserSteps userSteps = new UserSteps();
    User user;
    MainPageBurger mainPageBurger;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    @Before
    public void setup() {
        user = new User();
        user.setUser();

        driver = WebDriverFactory.getDriver();
        driver.get(HOST);

        mainPageBurger = new MainPageBurger(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    @DisplayName("Успешная регистрация")
    public void successRegistration(){
        mainPageBurger.clickLogInButton();

        loginPage.clickRegistrationButton();

        registrationPage.fillRegForm(user.getName(), user.getEmail(), user.getPassword()); // регистрируемся

        loginPage.fillLoginForm(user.getEmail(), user.getPassword()); //авторизумеся для проверки, того, что пользователь зарегистрирован
        mainPageBurger.presentOrderButton();

        //можно то же самое через апи проверить.
        userSteps
                .loginUser(user)
                .statusCode(200)
                .body("success",is(true))
                .body("user.email",is(user.getEmail()))
                .body("user.name",is(user.getTempName()))
                .body("accessToken", notNullValue())
                .body("refreshToken", notNullValue());

        //удалим пользователя прямо в тесте, чтобы не городить иф конструкии в афтер
        user.setAccessToken(userSteps
                .loginUser(user)
                .extract().body().path("accessToken"));
        userSteps
                .deleteUser(user);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    @DisplayName("Ошибка при регистрации для некорректного пароля(менее 6 символов)")
    public void regBadPass(){
        mainPageBurger.clickLogInButton();

        loginPage.clickRegistrationButton();

        user.setPassword("12345");
        registrationPage.fillRegForm(user.getName(), user.getEmail(), user.getPassword());

        registrationPage.presentBadPassText();

    }
    @After
       public void tearDown() {
        driver.quit();
        }
}
