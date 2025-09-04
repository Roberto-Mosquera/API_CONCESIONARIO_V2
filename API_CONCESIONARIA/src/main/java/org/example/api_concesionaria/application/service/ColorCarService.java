package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.colorCarUseCase.CreateColorCarUseCase;
import org.example.api_concesionaria.application.port.output.ColorCarRepositoryPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorCarService implements CreateColorCarUseCase {

    private final ColorCarRepositoryPort colorCarRepositoryPort;

    @Override
    public void createColorCar(String color_name, String url_img_color) {

    }
}
