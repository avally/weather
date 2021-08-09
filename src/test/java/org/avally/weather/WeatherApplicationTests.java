package org.avally.weather;

import lombok.extern.slf4j.Slf4j;
import org.avally.weather.controller.WeatherController;
import org.avally.weather.model.Summary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherApplicationTests {
    @Autowired
    private WeatherController weatherController;
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(weatherController);
    }

    @Test
    public void checkSuccessUrl() {
        String successRequestUrl = "http://localhost:" + port + "/api/weather?city=Kyiv";
        ResponseEntity<Summary> summaryResponseEntity = restTemplate.getForEntity(successRequestUrl, Summary.class);
        HttpStatus statusCode = summaryResponseEntity.getStatusCode();
        Assertions.assertEquals(HttpStatus.OK, statusCode);

        Summary summary = summaryResponseEntity.getBody();
        log.info("summary: " + summary);
        Assertions.assertNotNull(summary);
    }

    @Test
    public void checkFailureUrl() {
        String wrongRequestUrl = "http://localhost:" + port + "/api/weather?city=Kyiv11";
        ResponseEntity<Summary> summaryResponseEntity = this.restTemplate.getForEntity(wrongRequestUrl, Summary.class);
        HttpStatus actualCode = summaryResponseEntity.getStatusCode();
        Assertions.assertEquals(HttpStatus.NOT_FOUND, actualCode);
    }
}
