package com.example.carspring.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateCar {

    @NotNull
    @NotEmpty(message = "name cannot be empty.")
    private String name;

    @NotNull
    @NotEmpty(message = "description cannot be empty.")
    private String description;

    @NotNull
    @Min(value = 1, message = "price must not be below minimum")
    private float price;

    @NotNull
    @Min(value = 1, message = "category cannot be empty.")
    private Long categoryId;

    public CreateCar() {
    }

    public CreateCar(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
