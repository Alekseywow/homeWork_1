package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    public void checkTableResult(String key, String value) {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
