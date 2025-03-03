package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendareComponent;
import pages.components.TableComponent;

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
        stateField = $("#state"),
        stateDropdown = $("#stateCity-wrapper"),
        adressField = $("#city"),
        adressDropdown = $("#stateCity-wrapper"),
        submitButton = $("#submit");




    CalendareComponent calendareComponent = new CalendareComponent();
    TableComponent tableComponent = new TableComponent();



    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage removeBanner() {
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

    public RegistrationPage setUserEmail (String value) {
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

    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }


    public RegistrationPage setPicture (String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setAddress (String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState (String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity (String value) {
        adressField.click();
        adressDropdown.$(byText(value)).click();
        return this;
    }
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableComponent.checkTableResult(key, value);
        return this;
    }
    public RegistrationPage verifyUserNumberFieldIsRed() {
        userNumberInput.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
    }

}
