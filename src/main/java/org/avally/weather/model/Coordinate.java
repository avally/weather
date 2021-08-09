package org.avally.weather.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Represents city coordinates
 */
@Data
@Embeddable
public class Coordinate {
    @Column(name = "longitude")
    private Float lon;
    @Column(name = "latitude")
    private Float lat;

    public Coordinate() {
    }
}
