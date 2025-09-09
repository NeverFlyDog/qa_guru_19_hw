package ru.example.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import ru.example.config.WebConfigProvider;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {

    @BeforeAll
    static void setup() {
        WebConfigProvider.configure();
    }

    @AfterEach
    void tearDown() {
        if (hasWebDriverStarted()) {
            getWebDriver().quit();
        }
    }
}
