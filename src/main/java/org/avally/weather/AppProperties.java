package org.avally.weather;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("openweather")
public final class AppProperties {
    @Setter @Getter
    private String token;
    @Setter @Getter
    private String url;
}
