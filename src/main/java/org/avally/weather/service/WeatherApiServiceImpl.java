package org.avally.weather.service;

import org.avally.weather.AppProperties;
import org.avally.weather.model.Summary;
import org.avally.weather.util.WeatherApiErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherApiServiceImpl implements WeatherApiService{
    private final String url;
    private final String token;
    private final RestTemplate restTemplate;

    public WeatherApiServiceImpl(AppProperties appProperties, RestTemplateBuilder restTemplateBuilder) {
        this.url = appProperties.getUrl();
        this.token = appProperties.getToken();
        this.restTemplate = restTemplateBuilder
                .errorHandler(new WeatherApiErrorHandler())
                .build();
    }

    @Override
    public ResponseEntity<Summary> getWeatherFromApi(String city) {
//        build URI with required params
        String weatherApiUri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", city)
                .queryParam("appid", token)
                .toUriString();

        return restTemplate.getForEntity(weatherApiUri, Summary.class);
    }
}
