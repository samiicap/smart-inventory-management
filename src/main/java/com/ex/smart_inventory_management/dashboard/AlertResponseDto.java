package com.ex.smart_inventory_management.dashboard;

import lombok.Data;

@Data
public class AlertResponseDto {

	private Long productId;
	private String productName;
	private int quantity;
	private int minimumStock;
	private String message;

}
