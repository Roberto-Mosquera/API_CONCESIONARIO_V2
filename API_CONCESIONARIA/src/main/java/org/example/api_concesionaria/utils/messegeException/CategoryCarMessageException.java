package org.example.api_concesionaria.utils.messegeException;

public interface CategoryCarMessageException {
    String NOT_FOUNT_CATEGORY_CAR_BY_ID = "No se encontro la categoria con este id";
    String THAT_NAME_ALREADY_EXISTS = "No se permiten ingresar categorias con nombre repetidos";
    String MISSING_NAME_CATEGORY_CAR = "Te falta el nombre de la categoria";
    String PAGE_NEGATIVE = "No se permiten numeros negativos para la paginacion";
}
