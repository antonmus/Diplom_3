package api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import testData.User;
import static io.restassured.RestAssured.given;
import static api.EndPoint.*;

public class UserSteps {
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .baseUri(HOST)
                .contentType(ContentType.JSON)
                .body(user)
                .when().post(CREATE)
                .then();
    }
    @Step("Логин пользователя")
    public ValidatableResponse loginUser (User user)  {
        user.setName(null);
        return given()
                .baseUri(HOST)
                .contentType(ContentType.JSON)
                .body(user)
                .when().post(LOGIN)
                .then();
    }
    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(User user){
        return given()
                .baseUri(HOST)
                .contentType(ContentType.JSON)
                .header("Authorization", user.getAccessToken())
                .body(user)
                .when().delete(DELETE)
                .then();
    }

}