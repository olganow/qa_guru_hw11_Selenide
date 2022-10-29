package ru.ya.olganow;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSearchTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void githubSearchTest() {
        open("https://github.com");
        $x("//input[contains(@type,'text')]").setValue("selenide").submit();
        $x("//a[contains(@href,'selenide/selenide')]").click();
        $("#wiki-tab").click();
        $("input[placeholder='Find a page…']").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("#wiki-wrapper").shouldHave(text("Using JUnit4"));
    }

}
