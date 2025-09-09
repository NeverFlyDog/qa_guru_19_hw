package ru.example.config;

import com.codeborne.selenide.Configuration;
import com.google.common.base.Strings;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebConfigProvider {
    private static final WebConfig config = ConfigFactory.create(WebConfig.class);

    public static void configure() {
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

        if (!Strings.isNullOrEmpty(config.remoteUrl())) {
            Configuration.remote = config.remoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(
                    "selenoid:options", Map.<String, Object>of(
                            "enableVNC", true,
                            "enableVideo", true
                    )
            );
            Configuration.browserCapabilities = capabilities;
        }
    }
}
