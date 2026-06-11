package com.ex.smart_inventory_management.product;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor

public class ProductService {

    private final ProductRepository repo;


// Add Product

    public ProductDto addProduct(ProductDto product){

        return repo.save(product);

    }


// Get Products

    public List<ProductDto> getProducts(){

        return repo.findAll();

    }



// Update Product

    public ProductDto updateProduct(
            Long id, ProductDto newProduct){


        ProductDto oldProduct =
                repo.findById(id).orElseThrow();


        oldProduct.setName(
                newProduct.getName());


        oldProduct.setCategory(
                newProduct.getCategory());


        oldProduct.setQuantity(
                newProduct.getQuantity());


        oldProduct.setMinimumStock(
                newProduct.getMinimumStock());


        return repo.save(oldProduct);

    }


// Delete Product

    public void deleteProduct(Long id){

        repo.deleteById(id);

    }

}
