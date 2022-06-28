package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubTest {

    @Test
    public void githubTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com");
        $("[data-test-selector ='nav-search-input']").click();
        $("[data-test-selector ='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
    }
}