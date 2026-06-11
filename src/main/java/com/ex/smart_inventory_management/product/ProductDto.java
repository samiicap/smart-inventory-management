package com.ex.smart_inventory_management.product;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductDto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private int minimumStock;

}
