package org.example.api_concesionaria.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record SoldCar(
        UUID id,
        LocalDate soldDate,
        LocalTime soldTime,
        Double amount,
        UUID id_car,
        UUID id_customer
) {}
