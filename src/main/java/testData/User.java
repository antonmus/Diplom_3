package testData;

import org.apache.commons.lang3.RandomStringUtils;

public class User {
    private String name;
    private String password;
    private String email;
    private String accessToken;
    private String tempName;
    public void setUser(){
        this.name = RandomStringUtils.randomAlphabetic(10);
        this.password = RandomStringUtils.randomAlphabetic(10).toLowerCase();
        this.email = RandomStringUtils.randomAlphabetic(10).toLowerCase()+ "@yandex.ru";
        this.tempName = name;
    }

    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTempName() { return tempName;}
    public User() {
    }
}
