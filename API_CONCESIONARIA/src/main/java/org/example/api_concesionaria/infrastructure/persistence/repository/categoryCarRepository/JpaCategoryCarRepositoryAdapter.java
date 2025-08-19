package org.example.api_concesionaria.infrastructure.persistence.repository.categoryCarRepository;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.output.CategoryCarRepositoryPort;
import org.example.api_concesionaria.domain.model.CategoryCar;
import org.example.api_concesionaria.dto.response.CategoryCarResponse;
import org.example.api_concesionaria.infrastructure.persistence.entity.CategoryCarEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaCategoryCarRepositoryAdapter implements CategoryCarRepositoryPort {

    private final SpringDataCategoryCarRepository springDataCategoryCarRepository;

    @Override
    @Transactional
    public Boolean saveCategoryCar(CategoryCar categoryCar) {
        try {
            return ServiceRepositoryCategoryCar.save(springDataCategoryCarRepository,categoryCar);
        }catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
            return false;
        }
    }

    @Override
    @Transactional
    public List<CategoryCarResponse> getListCategoryCar(int page) {
        try {
            return ServiceRepositoryCategoryCar.getList(springDataCategoryCarRepository,page);
        }catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
            return List.of();
        }
    }

    @Override
    @Transactional
    public CategoryCarResponse getCategoryCarById(UUID id) {
        try {
            return ServiceRepositoryCategoryCar.getById(springDataCategoryCarRepository,id);
        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
    }

    @Override
    public CategoryCarEntity getCategoryCarEntityById(UUID id) {
        try {
            return ServiceRepositoryCategoryCar.getEntityById(springDataCategoryCarRepository,id);
        }catch (Exception ex){
            System.out.println("Error: "+ex.getMessage());
            return null;
        }
    }

}
