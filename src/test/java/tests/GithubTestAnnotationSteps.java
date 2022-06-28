package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class GithubTestAnnotationSteps {

    @Test
    public void githubTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        final String REPOSITORY = "Selenide";

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink();
        steps.shouldIssue();
    }
}
