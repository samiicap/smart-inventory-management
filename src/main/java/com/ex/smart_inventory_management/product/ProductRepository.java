package com.ex.smart_inventory_management.product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductDto, Long>
{


}
