package com.ex.smart_inventory_management.dashboard;

import com.ex.smart_inventory_management.Warehouse.WarehouseRepository;
import com.ex.smart_inventory_management.product.ProductRepository;
import com.ex.smart_inventory_management.stock.StockDto;
import com.ex.smart_inventory_management.stock.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

	private final ProductRepository productRepository;
	private final StockRepository stockRepository;
	private final WarehouseRepository warehouseRepository;

	public DashboardResponseDto getDashboard(){

		DashboardResponseDto dto = new DashboardResponseDto();

		dto.setTotalProducts(productRepository.count());
		dto.setTotalWarehouses(warehouseRepository.count());

		List<StockDto> stocks = stockRepository.findAll();
		long totalStock = 0L;
		long totalAvailable = 0L;
		for(StockDto s: stocks){
			if(s != null){
				totalAvailable += s.getAvailableStock();
				totalStock += (long)s.getAvailableStock() + (long)s.getReservedStock();
			}
		}

		dto.setTotalAvailableStock(totalAvailable);
		dto.setTotalStock(totalStock);

		long lowStockCount = productRepository.findAll()
				.stream()
				.filter(p -> p.getQuantity() <= p.getMinimumStock())
				.count();

		dto.setLowStockProducts(lowStockCount);

		return dto;

	}

}
