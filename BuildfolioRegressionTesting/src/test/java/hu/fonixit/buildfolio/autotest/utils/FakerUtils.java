package hu.fonixit.buildfolio.autotest.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public Long generateRandomNumber(){
        Faker faker = new Faker();
        return faker.number().randomNumber(5,true);
    }
    public String generateRandomNumber10(){
        Faker faker = new Faker();
        return String.valueOf(faker.number().randomNumber(10,true));
    }
}
