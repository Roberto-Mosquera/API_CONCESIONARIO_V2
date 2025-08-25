package org.example.api_concesionaria.dto.response;

import java.util.List;

public record GalleryCarResponse (
    String nameGallery,
    List<String> url_img_item
) {
    
}
