package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Objects;

public class TestData {
    Faker faker = new Faker(new Locale("en-GB"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.options().option("Male","Other","Female");
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String dateOfBirth = String.format("%02d", faker.number().numberBetween(1,28));
    String monthOfBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    String yearOfBirth = String.valueOf(faker.number().numberBetween(1900,2000));
    String subject = faker.options().option("Economics","English","Arts");
    String hobbies = faker.options().option("Sports","Music","Reading");
    String address = faker.address().streetAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    String city = setCity(state);

    public static String setCity(String state) {
        Faker faker = new Faker();

        if (Objects.equals(state, "NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (Objects.equals(state, "Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        } else if (Objects.equals(state, "Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        } else
            return state;
    }

}

