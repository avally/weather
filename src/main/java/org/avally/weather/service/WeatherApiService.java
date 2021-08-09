package org.avally.weather.service;

import org.avally.weather.model.Summary;
import org.springframework.http.ResponseEntity;

public interface WeatherApiService {
    ResponseEntity<Summary> getWeatherFromApi(String city);
}
