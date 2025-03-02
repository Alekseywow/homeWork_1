package pages.components;

import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendareComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").$(byText("September")).click();
        $(".react-datepicker__year-select").$(byText("1994")).click();
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("26")).click(); // этот код находит и кликает на 26-й день в календаре, который отображается с помощью компонента react-datepicker, при этом игнорируя дни, которые находятся вне текущего месяца.

    }

}
