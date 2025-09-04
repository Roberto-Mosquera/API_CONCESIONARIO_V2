package org.example.api_concesionaria.domain.model;

import org.example.api_concesionaria.Enum.RoleUser;

import java.util.UUID;

public record User(
        UUID id,
        String username,
        String password,
        RoleUser role_user,
        Boolean enabled
) {
}
