package org.example.api_concesionaria.mapper;

import org.example.api_concesionaria.domain.model.Car;
import org.example.api_concesionaria.domain.model.ColorCar;
import org.example.api_concesionaria.dto.request.CreateColorCarRequest;
import org.example.api_concesionaria.infrastructure.persistence.entity.ColorCarEntity;

public class ColorCarMapper {

    public static ColorCar toCreateColorCar(CreateColorCarRequest createColorCarRequest, Car car){
        return new ColorCar(
                createColorCarRequest.nameColor(),
                createColorCarRequest.urlImgColor(),
                car
        );
    }

    public static ColorCarEntity toColorCarEntity (ColorCar car){
        return new ColorCarEntity(
                null,
                car.getNameColor(),
                car.getUrlImgColor(),
                car.getEnabled(),
                CarMapper.toFindCarEntity(car.getCar())
        );
    }

    public static ColorCar toColorCar(ColorCarEntity colorCarEntity){
        return new ColorCar(
                colorCarEntity.getId(),
                colorCarEntity.getNameColor(),
                colorCarEntity.getUrlImgColor(),
                colorCarEntity.getEnabled()
        );
    }
}
