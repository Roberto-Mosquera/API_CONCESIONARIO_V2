package org.example.api_concesionaria.utils;

import lombok.RequiredArgsConstructor;
import org.example.api_concesionaria.dto.request.CreateCarFiles;
import org.example.api_concesionaria.dto.request.CreateCarRequest;
import org.example.api_concesionaria.dto.request.CreateColorCarRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileMapper {

    private final UploadFiles uploadFiles;

    public CreateCarFiles saveFileCategoryCar(CreateCarRequest carRequest) throws Exception {
        String FileImgCar,FileTechnicalSheet;
        FileImgCar = uploadFiles.uploadFile(carRequest.FileImgCar());
        FileTechnicalSheet = uploadFiles.uploadFile(carRequest.FileTechnicalSheet());
        return new CreateCarFiles(FileImgCar,FileTechnicalSheet);
    }

    public String saveFileColorCar(CreateColorCarRequest createColorCarRequest) throws Exception {
        return uploadFiles.uploadFile(createColorCarRequest.urlImgColor());
    }

}
