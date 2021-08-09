package org.avally.weather.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Represents a summary info about weather in distinct city
 */
@Data
public class Summary {
    @JsonSetter("name")
    private String city;
    @JsonSetter("coord")
    private Coordinate coordinate;
    private Date date;
    private List<Weather> weather;
}
