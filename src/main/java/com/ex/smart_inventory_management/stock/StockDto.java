package com.ex.smart_inventory_management.stock;

import com.ex.smart_inventory_management.Warehouse.WarehouseDto;
import com.ex.smart_inventory_management.product.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StockDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductDto product;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private WarehouseDto warehouse;

    private int availableStock;

    private int reservedStock;


}
