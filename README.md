# Spring Boot weather app
This app represents one http endpoint to retrieve weather data for a specific city.

>Used technologies: SpringBoot (WEB, Data-JPA), PostgreSQL, lombok.

To start the app you need to provide an appropriate openweather API access token. Pass it to the following property 
in **application.properties**:
```
openweather.token = your_openweather_api_token
```
## Example
Request example:
```http request
http://localhost:8080/api/weather?city=Kyiv
```
Response example (JSON):
```json
{
  "weather": [
    {
      "description": "clear sky",
      "icon": "01d",
      "main": "Clear"
    }
  ],
  "name": "Kyiv",
  "coord": {
    "lon": 30.5167,
    "lat": 50.4333
  },
  "time": "2021-08-10T15:28:36.000+00:00"
}
```
## Query params
| Param name | Default | Description                                                  |
| ---------- | ------- | ------------------------------------------------------------ |
| city       | ---     | City name, state code and country code divided by comma, Please, refer to [ISO 3166](https://www.iso.org/obp/ui/#search) for the state codes or country codes. |