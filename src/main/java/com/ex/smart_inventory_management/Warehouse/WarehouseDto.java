package com.ex.smart_inventory_management.Warehouse;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data

public class WarehouseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String warehouseName;


    private String location;
}
