package org.avally.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @GetMapping("/weather")
    public String getWeatherByCity(@RequestParam("city") String city) {
        return null;
    }
}
