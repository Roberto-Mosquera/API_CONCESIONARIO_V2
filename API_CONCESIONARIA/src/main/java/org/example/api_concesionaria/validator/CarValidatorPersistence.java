package org.example.api_concesionaria.validator;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.infrastructure.persistence.repository.carRepository.SpringDataCarRepository;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CarValidatorPersistence {

    public final SpringDataCarRepository springDataCarRepository;


}
