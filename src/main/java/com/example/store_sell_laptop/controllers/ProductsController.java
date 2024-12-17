package com.example.store_sell_laptop.controllers;

import com.example.store_sell_laptop.models.Product;
import com.example.store_sell_laptop.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductsController {

    @Autowired
    private ProductsRepository repo;

    @GetMapping("/")
    public String listProductList(Model model) {
        List<Product> products = repo.findAll();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") Product product) {
        repo.save(product);
        return "redirect:/";
    }

    @GetMapping("/products/edit/{id}")
    public String showEditProductForm(@PathVariable("id") int id, Model model) {
        Product product = repo.findById(id).orElse(null);
        if (product == null) {
            return "redirect:/";
        }
        model.addAttribute("product", product);
        return "product-form";
    }

    @PostMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") int id, @ModelAttribute("product") Product updatedProduct) {
        Product existingProduct = repo.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setImage(updatedProduct.getImage());
            existingProduct.setRating(updatedProduct.getRating());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            repo.save(existingProduct);
        }
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        repo.deleteById(id);
        return "redirect:/";
    }
}
