import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successFullFormTest() {

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Aleksey");
        $("#lastName").setValue("Maxwell");
        $("#userEmail").setValue("pra@pra.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7950505050");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1994")).click();
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("26")).click(); // этот код находит и кликает на 26-й день в календаре, который отображается с помощью компонента react-datepicker, при этом игнорируя дни, которые находятся вне текущего месяца.
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("images_3.jpg");
        $("#currentAddress").setValue("MORSE");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();


    }
}
