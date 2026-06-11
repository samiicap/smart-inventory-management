package com.ex.smart_inventory_management.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockDto,Long>
{


}
