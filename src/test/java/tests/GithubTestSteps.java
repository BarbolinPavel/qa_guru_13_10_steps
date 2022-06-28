package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class GithubTestSteps {

    final String REPOSITORY = "Selenide";

    @Test
    public void githubTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу",() -> {
                Selenide.open("https://github.com");
        });
        step("Ищем репозиторий по имени " + REPOSITORY, () ->{
            $("[data-test-selector ='nav-search-input']").click();
            $("[data-test-selector ='nav-search-input']").setValue("selenide").pressEnter();
        });
        step("В результатах поиска переходим по ссылке репозитория " + REPOSITORY, () -> {
            $$("ul.repo-list li").first().$("a").click();
        });
        step("Проверяем что существует Issue", () -> {
            $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
        });
    }
}
