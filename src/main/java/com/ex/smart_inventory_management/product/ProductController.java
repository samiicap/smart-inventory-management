package com.ex.smart_inventory_management.product;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;


    @PostMapping
    public ProductDto add(
            @RequestBody ProductDto product){

        return service.addProduct(product);

    }


    @GetMapping
    public List<ProductDto> get(){

        return service.getProducts();

    }

    @PutMapping("/{id}")
    public ProductDto update(
            @PathVariable Long id,
            @RequestBody ProductDto product){

        return service.updateProduct(id,product);

    }


    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        service.deleteProduct(id);

        return "Product Deleted";

    }

}
