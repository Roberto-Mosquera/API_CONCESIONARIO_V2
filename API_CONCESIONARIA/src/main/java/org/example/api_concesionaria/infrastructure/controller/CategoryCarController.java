package org.example.api_concesionaria.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.Utils.SuccessMessage;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.CreateCategoryCarUseCase;
import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/categoryCar")
@RestController
@RequiredArgsConstructor
public class CategoryCarController {

    private CreateCategoryCarUseCase createCategoryCarUseCase;

    @PostMapping("/add")
    public ResponseEntity<?> saveCategoryCar(@RequestBody CreateCategoryCarRequest categoryCarRequest){

        createCategoryCarUseCase.createCategory(categoryCarRequest);

        SuccessMessage<Void> successMessage = SuccessMessage.<Void>builder()
                .status(200)
                .message("Se ha guardado Correctamente la categoria")
                .build();

        return ResponseEntity.ok(successMessage);
    }

}
