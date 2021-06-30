package com.example.carspring.dto;

public class CarDto {
    private Long id;
    private String name;
    private String description;
    private float price;

    private CategoryDto category;

    public CarDto() {
    }

    public CarDto(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public CarDto(Long id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }
}
