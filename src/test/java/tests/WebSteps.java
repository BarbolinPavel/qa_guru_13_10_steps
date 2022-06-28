package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        Selenide.open("https://github.com");
    }

    @Step("Ищем репозиторий по имени {repository}")
    public void searchForRepository(String repository) {
        $("[data-test-selector ='nav-search-input']").click();
        $("[data-test-selector ='nav-search-input']").setValue(repository).pressEnter();
    }

    @Step("В результатах поиска переходим по ссылке репозитория")
    public void openRepositoryLink() {
        $$("ul.repo-list li").first().$("a").click();
    }

    @Step("Проверяем что существует Issue")
    public void shouldIssue() {
        $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
    }

}
