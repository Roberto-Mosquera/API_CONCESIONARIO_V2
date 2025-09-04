package org.example.api_concesionaria.domain.model;

import java.util.UUID;

public class ColorCar{
    private UUID id;
    private String nameColor;
    private String urlImgColor;
    private Boolean enabled;

    public ColorCar(UUID id, String nameColor, String urlImgColor, Boolean enabled) {
        this.id = id;
        this.nameColor = nameColor;
        this.urlImgColor = urlImgColor;
        this.enabled = enabled;
    }

    public UUID getId() {
        return id;
    }

    public String getNameColor() {
        return nameColor;
    }

    public String getUrlImgColor() {
        return urlImgColor;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
