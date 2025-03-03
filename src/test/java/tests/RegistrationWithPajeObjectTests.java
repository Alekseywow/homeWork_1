package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPajeObjectTests extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successFullFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Aleksey")
                .setLastName("Maxwell")
                .setUserEmail("pra@pra.ru")
                .setGender("Male")
                .setUserNumber("7950505050")
                .setDateOfBrith("26","September","1994")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setPicture("images_3.jpg")
                .setAddress("MORSE")
                .setState("NCR")
                .setCity("Delhi")
                .submit();


        registrationPage.checkResult("Student Name", "Aleksey Maxwell")
                        .checkResult("Student Email", "pra@pra.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7950505050")
                        .checkResult("Date of Birth", "26 September,1994")
                        .checkResult("Subjects", "Maths")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "images_3.jpg")
                        .checkResult("Address", "MORSE")
                        .checkResult("State and City", "NCR Delhi");

  }

  @Test
    void minimalFormTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName("Aleksey")
                .setLastName("Maxwell")
                .setUserEmail("pra@pra.ru")
                .setGender("Male")
                .setUserNumber("7950505050")
                .submit();

        registrationPage.checkResult("Student Name", "Aleksey Maxwell")
                .checkResult("Student Email", "pra@pra.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7950505050");

  }

  @Test
    void negativeFormTests() {
      registrationPage.openPage()
              .removeBanner()
              .setFirstName("Aleksey")
              .setLastName("Maxwell")
              .setUserEmail("pra@pra.ru")
              .setGender("Male")
              .setUserNumber("795050505")
              .submit()
              .verifyUserNumberFieldIsRed();
  }
}
