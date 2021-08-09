package org.avally.weather.repository;

import org.avally.weather.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Summary, Long> {
}
