package com.example.carspring.controller;

import com.example.carspring.dto.CreateCar;
import com.example.carspring.model.Car;
import com.example.carspring.model.Category;
import com.example.carspring.service.CarService;
import com.example.carspring.service.CategoryService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/auth/add-car")
    public String displayAddCar(Model model) {
        List<Category> categoryList = categoryService.fetchAllCategory();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("createCar", new CreateCar());

        return "auth/addcar";
    }

    @PostMapping("/auth/add-car")
    public String addCar(@Valid CreateCar createCar, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/auth/addcar";
        }
        Category category = categoryService.fetchSpecificCategory(createCar.getCategoryId());
        Car newCar = new Car(createCar.getName(), createCar.getDescription(), createCar.getPrice());
        newCar.setCategory(category);
        carService.createCar(newCar);
        return "redirect:/list-car";
    }

    @PostMapping("/auth/delete-car")
    public String deleteCar(@RequestParam("id") Long idParam) {
        carService.removeCar(idParam);
        return "redirect:/list-car";
    }

    @GetMapping({"/", "/list-car"})
    public String displayHomePage(Model model, @RequestParam(value = "search", required = false) String searchValue) {
        List<Car> carList;
        if (Strings.isNotBlank(searchValue)) {
            carList = carService.searchCarsByNameOrDescription(searchValue);
        } else {
            carList = carService.fetchAllCars();
        }
        model.addAttribute("carList", carList);
        return "carlist";
    }

    @GetMapping("/details-car")
    public String displayDetails(@RequestParam("id") Long idParam, Model model) {
        Car car = carService.fetchSpecificCar(idParam);
        model.addAttribute("car", car);
        return "cardetails";
    }

}
