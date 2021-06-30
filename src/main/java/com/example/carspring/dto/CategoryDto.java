package com.example.carspring.dto;

import java.util.List;

public class CategoryDto {

    private Long id;
    private String name;
    private List<CarDto> carList;

    public CategoryDto(Long id, String name, List<CarDto> carList) {
        this.id = id;
        this.name = name;
        this.carList = carList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }
}
