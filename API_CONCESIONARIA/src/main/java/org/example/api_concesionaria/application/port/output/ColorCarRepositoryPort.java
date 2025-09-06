package org.example.api_concesionaria.application.port.output;

import org.example.api_concesionaria.domain.model.ColorCar;

public interface ColorCarRepositoryPort {
    void saveColorCar(ColorCar colorCar);
}
