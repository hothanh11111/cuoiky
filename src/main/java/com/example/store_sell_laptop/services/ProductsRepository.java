package com.example.store_sell_laptop.services;

import com.example.store_sell_laptop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductsRepository extends JpaRepository<Product, Integer> {


}
