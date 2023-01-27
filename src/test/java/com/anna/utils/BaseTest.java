package com.annaBayandina.utils;

import com.annaBayandina.api.generatingdata.GeneratingDataOfUser;
import com.annaBayandina.api.models.User;
import com.annaBayandina.pageobject.*;
import com.annaBayandina.steps.UserSteps;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected MainPage mainPage = new MainPage();
    protected LoginPage loginPage = new LoginPage();
    protected RegistrationPage registrationPage = new RegistrationPage();
    protected ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    protected PersonalAccount personalAccount = new PersonalAccount();
    protected String accessToken;
    protected User user;
    protected ValidatableResponse response;

    @Before
    @Description("Конфигурация перед началом выполнения теста")
    public void setUp() throws InterruptedException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        user = GeneratingDataOfUser.createNewUser();
        response = UserSteps.createUser(user);
    }

    @After
    @Description("Конфигурация после окончания теста")
    public void deleteDataOfUser() throws InterruptedException {
        if (response.extract().body().path("success").equals(true)) {
            accessToken = UserSteps.getAccessToken(response);
            user.setAccessToken(accessToken);
            UserSteps.deleteUser(user);
        }
        Thread.sleep(2000);
    }
}
