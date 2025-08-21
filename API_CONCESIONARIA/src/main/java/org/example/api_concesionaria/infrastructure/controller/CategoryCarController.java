package org.example.api_concesionaria.infrastructure.controller;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.FindCategoryCarUseCase;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.ListCategoryCarUseCase;
import org.example.api_concesionaria.utils.SuccessMessage;
import org.example.api_concesionaria.application.port.input.simpleUseCase.categoryCarUseCase.CreateCategoryCarUseCase;
import org.example.api_concesionaria.dto.request.CreateCategoryCarRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/categoryCar")
@RestController
@RequiredArgsConstructor
public class CategoryCarController {

    private final CreateCategoryCarUseCase createCategoryCarUseCase;
    private final ListCategoryCarUseCase listCategoryCarUseCase;
    private final FindCategoryCarUseCase findCategoryCarUseCase;

    @PostMapping("/add")
    public ResponseEntity<SuccessMessage<?>> saveCategoryCar(@RequestBody CreateCategoryCarRequest categoryCarRequest){
        createCategoryCarUseCase.createCategory(categoryCarRequest);
        SuccessMessage<Void> successMessage = SuccessMessage.<Void>builder()
                .status(200)
                .message("Se ha guardado Correctamente la categoria")
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
    }

    @GetMapping("/list/{page}")
    public ResponseEntity<SuccessMessage<?>> listCategoryCarResponse(@PathVariable(name = "page") int page){
        SuccessMessage<?> successMessage = SuccessMessage.builder()
                .status(200)
                .message("Listado de categorías obtenido correctamente")
                .Body(listCategoryCarUseCase.listCategoryCar(page))
                .build();
        return ResponseEntity.ok(successMessage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessMessage<?>> findCategoryCarResponse(@PathVariable(name = "id") UUID id){
        SuccessMessage<?> successMessage = SuccessMessage.builder()
                .status(200)
                .message("Se ha obtenido correctamente la categoria")
                .Body(findCategoryCarUseCase.findCategoryCar(id))
                .build();
        return ResponseEntity.ok(successMessage);
    }

}
