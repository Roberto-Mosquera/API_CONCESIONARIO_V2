package org.example.api_concesionaria.infrastructure.persistence.repository.colorCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.ColorCarRepositoryPort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaColorCarAdapter implements ColorCarRepositoryPort {

    @Override
    public void saveColorCar(String color_name, String url_img_color) {

    }

}
