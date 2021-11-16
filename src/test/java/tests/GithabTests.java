package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithabTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.headless = false;
    }

    @Test
    void checkTextOnPagesOnWiki() {
        // открыть страничку selenide
        open("https://github.com/selenide/selenide");
        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        // в списке страниц (Pages) есть страница SoftAssertions
        $(".js-wiki-more-pages-link").click();
        // и открыть ее
        $x("//a[.='SoftAssertions']").click();
        //проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("JUnit5"));
    }
}
