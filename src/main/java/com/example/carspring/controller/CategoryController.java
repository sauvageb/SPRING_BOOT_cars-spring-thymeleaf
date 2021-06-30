package com.example.carspring.controller;

import com.example.carspring.dto.CreateCategory;
import com.example.carspring.model.Category;
import com.example.carspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/auth/add-category")
    public String displayAddCategory(Model model) {
        model.addAttribute("createCategory", new CreateCategory());
        return "auth/addcategory";
    }

    @GetMapping({"/list-category"})
    public String displayHomePage(Model model) {
        List<Category> categoryList = categoryService.fetchAllCategory();
        model.addAttribute("categoryList", categoryList);
        return "categorylist";
    }

    @PostMapping("/auth/add-category")
    public String addCategory(CreateCategory createCategory) {
        try {
            Category newCategory = new Category(createCategory.getName());
            categoryService.createCategory(newCategory);

        } catch (NumberFormatException e) {
            // TODO : handle error
        }
        return "redirect:/list-category";
    }

    @PostMapping("/auth/delete-category")
    public String deleteCar(@RequestParam("id") Long idParam) {
        categoryService.removeCategory(idParam);
        return "redirect:/list-category";
    }
}
