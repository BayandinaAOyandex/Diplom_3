package com.annaBayandina.api.generatingdata;

import com.annaBayandina.api.models.User;
import com.github.javafaker.Faker;

public class GeneratingDataOfUser {
    public static User createNewUser() {
        return User.builder()
                .email(Faker.instance().internet().emailAddress())
                .password(Faker.instance().internet().password())
                .name(Faker.instance().name().nameWithMiddle())
                .build();
    }
}