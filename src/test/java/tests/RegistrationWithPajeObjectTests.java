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
                .setFirstName("Aleksey")
                .setLastName("Maxwell")
                .setUserName("pra@pra.ru")
                .setGender("Male")
                .setUserNumber("7950505050")
                .setDateOfBrith("26","September","1994")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setPicture("images_3.jpg")
                .setCurrentAddress("MORSE")
                .setCurrent("NCR")
                .setAddress("Delhi")
                .submitForm();




        registrationPage.checkResultModal("Thanks for submitting the form")
                        .checkResult("Student Name", "Aleksey Maxwell")
                        .checkResult("Student Email", "pra@pra.ru")
                        .checkResult("Gender", "Male")
                        .checkResult("Mobile", "7950505050")
                        .checkResult("Date of Birth", "26 September,1994")
                        .checkResult("Subjects", "Maths")
                        .checkResult("Hobbies", "Sports")
                        .checkResult("Picture", "images_3.jpg")
                        .checkResult("Address", "MORSE")
                        .checkResult("State and City", "NCR Delhi");

        //$("#example-modal-sizes-title-lg").shouldHave(text("T"));
//        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("Aleksey Maxwell"));
//        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("pra@pra.ru"));
//        $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Male"));
//        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("7950505050"));
//        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("26 September,1994"));
//        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Maths"));
//        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports"));
//        $(".table").$(byText("Picture")).sibling(0).shouldHave(text("images_3.jpg"));
//        $(".table").$(byText("Address")).sibling(0).shouldHave(text("MORSE"));
//        $(".table").$(byText("State and City")).sibling(0).shouldHave(text("NCR Delhi"));
  }
}
