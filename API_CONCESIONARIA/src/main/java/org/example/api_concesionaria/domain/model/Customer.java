package org.example.api_concesionaria.domain.model;

import org.example.api_concesionaria.Enum.TypeDocument;

import java.util.UUID;

public record Customer(
        UUID id,
        String firstName,
        String middleName,
        String paternalSurname,
        String maternalSurname,
        String email,
        String phone,
        TypeDocument typeDocument,
        String documentText,
        Boolean enabled,
        UUID id_user
) {}
