package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GithubTest {
    void githubTest(){

        Selenide.open("https://github.com");

        $("[data-test-selector ='nav-search-input']").click();
        $("[data-test-selector ='nav-search-input']").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
    }
}
