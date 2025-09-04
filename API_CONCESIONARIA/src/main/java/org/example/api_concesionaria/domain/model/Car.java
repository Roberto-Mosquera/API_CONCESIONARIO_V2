package org.example.api_concesionaria.domain.model;

import org.example.api_concesionaria.exception.DomainException;

import java.util.UUID;

public class Car{
    private UUID id;
    private String nameCar;
    private String urlImgCar;
    private Double price;
    private Integer stock;
    private String brand;
    private String model;
    private String engine;
    private String traction;
    private String transmission;
    private String torque;
    private String speed;
    private String urlTechnicalSheet;
    private Boolean enabled;
    private CategoryCar categoryCar;

    public Car(UUID id, String nameCar, String urlImgCar, Double price, Integer stock, String brand, String model, String engine, String traction, String transmission, String torque, String speed, String urlTechnicalSheet, Boolean enabled) {
        this.id = id;
        validation(nameCar,urlImgCar,price,stock,brand,model,engine,traction,transmission,torque,speed,urlTechnicalSheet);
        this.nameCar = nameCar;
        this.urlImgCar = urlImgCar;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.traction = traction;
        this.transmission = transmission;
        this.torque = torque;
        this.speed = speed;
        this.urlTechnicalSheet = urlTechnicalSheet;
        this.enabled = enabled;
    }

    public Car(UUID id, String nameCar, String urlImgCar, Double price, Integer stock, String brand, String model, String engine, String traction, String transmission, String torque, String speed, String urlTechnicalSheet, Boolean enabled, CategoryCar categoryCar) {
        this.id = id;

        validation(nameCar,urlImgCar,price,stock,brand,model,engine,traction,transmission,torque,speed,urlTechnicalSheet);

        this.nameCar = nameCar;
        this.urlImgCar = urlImgCar;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.traction = traction;
        this.transmission = transmission;
        this.torque = torque;
        this.speed = speed;
        this.urlTechnicalSheet = urlTechnicalSheet;
        this.enabled = enabled;
        this.categoryCar = categoryCar;
    }

    public Car(String nameCar, String urlImgCar, Double price, Integer stock, String brand, String model, String engine, String traction, String transmission, String torque, String speed, String urlTechnicalSheet, CategoryCar categoryCar) {

        validation(nameCar,urlImgCar,price,stock,brand,model,engine,traction,transmission,torque,speed,urlTechnicalSheet);

        this.nameCar = nameCar;
        this.urlImgCar = urlImgCar;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.traction = traction;
        this.transmission = transmission;
        this.torque = torque;
        this.speed = speed;
        this.urlTechnicalSheet = urlTechnicalSheet;
        this.categoryCar = categoryCar;
    }



    private void validation(String nameCar, String urlImgCar, Double price, Integer stock, String brand, String model, String engine, String traction, String transmission, String torque, String speed, String urlTechnicalSheet){
        requireNonBlank(nameCar, "nameCar");
        requireNonBlank(urlImgCar, "urlImgCar");
        requireNonNull(price, "price");
        requireNonNull(stock, "stock");
        requireNonBlank(brand, "brand");
        requireNonBlank(model, "model");
        requireNonBlank(engine, "engine");
        requireNonBlank(traction, "traction");
        requireNonBlank(transmission, "transmission");
        requireNonBlank(torque, "torque");
        requireNonBlank(speed, "speed");
        requireNonBlank(urlTechnicalSheet, "urlTechnicalSheet");
    }

    private void requireNonBlank(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new DomainException("El campo '" + fieldName + "' es obligatorio y no puede estar vacío.");
        }
    }

    private void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new DomainException("El campo '" + fieldName + "' es obligatorio y no puede ser null.");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNameCar() {
        return nameCar;
    }

    public String getUrlImgCar() {
        return urlImgCar;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getTraction() {
        return traction;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getTorque() {
        return torque;
    }

    public String getSpeed() {
        return speed;
    }

    public String getUrlTechnicalSheet() {
        return urlTechnicalSheet;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public CategoryCar getCategoryCar() {
        return categoryCar;
    }
}
