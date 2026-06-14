package com.ex.smart_inventory_management.dashboard;

import lombok.Data;

@Data
public class DashboardResponseDto {

	private long totalProducts;
	private long totalWarehouses;
	private long totalStock;
	private long totalAvailableStock;
	private long lowStockProducts;

}
