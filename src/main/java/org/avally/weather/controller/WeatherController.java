package org.avally.weather.controller;

import org.avally.weather.model.Summary;
import org.avally.weather.repository.WeatherRepository;
import org.avally.weather.service.WeatherApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class WeatherController {
    private final WeatherApiService weatherApiService;
    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherApiService weatherApiService, WeatherRepository weatherRepository) {
        this.weatherApiService = weatherApiService;
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/weather")
    public ResponseEntity<Summary> getWeatherByCity(@RequestParam("city") String city) {
        ResponseEntity<Summary> apiResponse = weatherApiService.getWeatherFromApi(city);
        if (apiResponse.getStatusCode().is2xxSuccessful() && apiResponse.hasBody()) {
            Summary summary = apiResponse.getBody();
//            Because we don`t have any criteria to fetch data from DB, just saving 'As is'
            Summary savedSummary = weatherRepository.save(Objects.requireNonNull(summary));
            return ResponseEntity.ok(savedSummary);
        }
        return ResponseEntity.badRequest().build();
    }
}
