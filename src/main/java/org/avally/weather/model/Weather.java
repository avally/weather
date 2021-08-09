package org.avally.weather.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Data
public class Weather {
    @JsonSetter("main")
    private String name;
    private String description;
    private String icon;
}
