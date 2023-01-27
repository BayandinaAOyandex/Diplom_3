package com.annaBayandina.pageobject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.annaBayandina.config.ConfigSingle.config;
import static com.annaBayandina.config.EndPoints.FORGOT_PASSWORD_PAGE;
import static com.codeborne.selenide.Selenide.$x;

public class ForgotPasswordPage {
    private SelenideElement logInButton = $x("//*[contains(text(), 'Войти')]");

    @Step("Открыть страницу забытого пароля")
    public ForgotPasswordPage openForgotPasswordPage() {
        Selenide.open(config.getBaseUriProperties() + FORGOT_PASSWORD_PAGE);

        return this;
    }

    @Step("Клик по кнопке 'Войти'")
    public ForgotPasswordPage clickLogInButton() {
        logInButton.click();

        return this;
    }
}
