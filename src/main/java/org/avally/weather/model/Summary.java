package org.avally.weather.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Represents a summary info about weather in distinct city
 */
@Data
@Entity
@Table(name = "summary")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Summary {
    @JsonIgnore
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonSetter("name")
    private String city;
    @JsonSetter("coord")
    @Embedded
    private Coordinate coordinate;
    private Date date;
    @OneToMany(cascade = CascadeType.ALL)
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
