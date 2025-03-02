package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendareComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        userEmailInput = $("#userEmail"),
        genterWrapper = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        calendarInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
        currentInput = $("#react-select-3-input"),
        adressInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
        modalDialog = $("#example-modal-sizes-title-lg"),
        tableResult = $(".table");






    CalendareComponent calendareComponent = new CalendareComponent();



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserName (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender (String value) {
        genterWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber (String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBrith(String day, String month, String year) {
        calendarInput.click();
        calendareComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture (String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress (String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setCurrent (String value) {
        currentInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setAddress (String value) {
        adressInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage submitForm() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultModal(String value) {
        modalDialog.shouldHave(text(value));
        return this;
    }
    public RegistrationPage checkResult(String key, String value) {
        tableResult.$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }

}
