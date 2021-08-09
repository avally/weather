package org.avally.weather.model;

import com.fasterxml.jackson.annotation.JsonGetter;
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

//    Custom setter to convert incoming openweather api 'dt' timestamp (in seconds) to java Date object
    @JsonSetter("dt")
    public void setDate(Long dateInSec) {
        this.date = new Date(dateInSec * 1000);
    }

    @JsonGetter("time")
    public Date getDate() {
        return date;
    }
}
