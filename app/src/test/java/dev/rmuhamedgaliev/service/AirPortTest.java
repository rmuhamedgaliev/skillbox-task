package dev.rmuhamedgaliev.service;

import java.util.List;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class AirPortTest {

    @Test
    void checkCountOfAircraft() {
        List<Aircraft> aircrafts = Airport.getInstance().getAllAircrafts();

        assertTrue(aircrafts.size() > 0);

        log.info("Количество самолетов в аэропорту {}", aircrafts.size());
    }
}
