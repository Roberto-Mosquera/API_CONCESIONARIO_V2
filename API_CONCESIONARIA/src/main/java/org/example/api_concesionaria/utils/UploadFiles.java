package org.example.api_concesionaria.utils;

import org.example.api_concesionaria.exception.FileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

@Component
public class UploadFiles {

    @Value("${upload.max-mb}")
    private long maxMb;

    private String [] allowed = {".jpg",".png",".jpeg",".xlsx",".xls",".docx"};

    private String [] files = {".xlsx",".xls",".docx"};

    @Value("${upload.path}")
    private String upload;

    public String uploadFile(MultipartFile file) throws Exception {
        try {

            String fileName = UUID.randomUUID().toString();

            byte [] bytes = file.getBytes();

            String fileOriginalName = file.getOriginalFilename();

            long fileSize = file.getSize();

            long maxFileSize = getMaxMb() * 1024 * 1024;

            sizeValidation(fileSize, maxFileSize);

            extensionValidation(fileOriginalName);

            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));

            String newFileName = fileName + fileExtension;

            File folder = getFile(fileOriginalName);

            if(!folder.exists()){
                folder.mkdirs();
            }

            String relativePath = folder.getName() + "/" + newFileName;

            Path path = Paths.get(upload).resolve(relativePath);

            Files.write(path, bytes);

            return relativePath;

        }catch (Exception e) {
            throw new FileException("Error al subir el archivo :"+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public File getFile(String fileName){
        boolean isFile = Arrays.stream(files).anyMatch( file -> fileName.endsWith(file) );
        String folder = isFile ? "file":"img";
        return new File(upload + "/" + folder);
    }

    public Long getMaxMb() {
        return maxMb ;
    }

    public void extensionValidation(String fileOriginalName) {
        boolean valid = false;
        for (String extension : allowed) {
            if (fileOriginalName.toLowerCase().endsWith(extension)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            throw new FileException("El tipo de archivo no es permitido", HttpStatus.BAD_REQUEST);
        }
    }

    public void sizeValidation(long fileSize,long maxFileSize){
        if(fileSize > maxFileSize){
            throw new MaxUploadSizeExceededException(maxFileSize);
        }
    }
}
