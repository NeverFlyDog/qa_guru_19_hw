package ru.example.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties",
        "classpath:local.properties"
})
public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("baseUrl")
    @DefaultValue("https://kotlinlang.org")
    String baseUrl();

    @Key("remoteUrl")
    String remoteUrl();
}
