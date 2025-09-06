package org.example.api_concesionaria.application.service;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.colorCarUseCase.CreateColorCarUseCase;
import org.example.api_concesionaria.application.port.output.CarRepositoryPort;
import org.example.api_concesionaria.application.port.output.ColorCarRepositoryPort;
import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.model.ColorCar;
import org.example.api_concesionaria.dto.request.CreateColorCarRequest;
import org.example.api_concesionaria.mapper.ColorCarMapper;
import org.example.api_concesionaria.utils.FileMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorCarService implements CreateColorCarUseCase {

    private final ColorCarRepositoryPort colorCarRepositoryPort;

    private final CarRepositoryPort carRepositoryPort;

    private final FileMapper fileMapper;

    @Override
    public void createColorCar(CreateColorCarRequest createColorCarRequest) throws Exception {

        String urlImgColor = fileMapper.saveFileColorCar(createColorCarRequest);

        Car car = carRepositoryPort.findCarById(createColorCarRequest.id_car());

        ColorCar colorCar = ColorCarMapper.toCreateColorCar(createColorCarRequest,car,urlImgColor);

        colorCarRepositoryPort.saveColorCar(colorCar);
    }

}
