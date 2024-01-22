package tests;

import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import pageObjects.RegistrationPage;

import java.util.Locale;

public class SuccessRegistrationFormWithFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        TestData testData = new TestData();


        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.dateOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject)
                .setHobbies(testData.hobbies)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .uploadPictures()
                .submitRegistration()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.dateOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", "images.jpg")
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);

    }
    @Test
    void failedRegistrationTest() {

        TestData testData = new TestData();

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .submitRegistration()
                .checkLastNameTyping("border-color", "rgb(220, 53, 69)");
    }

    @Test
    void minimalRegistrationTest() {
        TestData testData = new TestData();

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.dateOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setAddress(testData.address)
                .submitRegistration()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.dateOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .checkResult("Address", testData.address);

    }
}
