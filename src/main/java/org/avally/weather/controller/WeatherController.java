package org.avally.weather.controller;

import org.avally.weather.model.Summary;
import org.avally.weather.service.WeatherApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {
    private final WeatherApiService weatherApiService;

    public WeatherController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/weather")
    public ResponseEntity<Summary> getWeatherByCity(@RequestParam("city") String city) {
        ResponseEntity<Summary> apiResponse = weatherApiService.getWeatherFromApi(city);
        if (apiResponse.getStatusCode().is2xxSuccessful() && apiResponse.hasBody()) {
            Summary summary = apiResponse.getBody();
            return ResponseEntity.ok(summary);
        }
        return ResponseEntity.badRequest().build();
    }
}
