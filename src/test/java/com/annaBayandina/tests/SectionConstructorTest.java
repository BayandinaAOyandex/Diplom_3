package com.annaBayandina.tests;

import com.annaBayandina.utils.BaseTest;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SectionConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход разделу «Булки»")
    public void transitionToTheBunsSection() {
        mainPage
                .openMainPage()
                .clickFillingsButton()
                .clickBunsButton()
                .logoOfBunsButtonVisible();
    }

    @Test
    @DisplayName("Переход разделу «Соусы»")
    public void transitionToTheSaucesSection() {
        mainPage
                .openMainPage()
                .clickSaucesButton()
                .logoOfSaucesButtonVisible();
    }

    @Test
    @DisplayName("Переход разделу «Начинки»")
    public void transitionToTheFillingsSection() {
        mainPage
                .openMainPage()
                .clickFillingsButton()
                .logoOfFillingsButtonVisible();
    }
}
