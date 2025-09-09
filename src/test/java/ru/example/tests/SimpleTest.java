package ru.example.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest extends BaseTest {

    @Test
    void simpleTest() {
        open("/");

        $(".rs-hero").shouldHave(text("Kotlin"));
        $(".rs-subtitle-2").shouldHave(text("Concise. Multiplatform. Fun."));
    }
}
