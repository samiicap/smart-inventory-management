package com.ex.smart_inventory_management.dashboard;

import com.ex.smart_inventory_management.product.ProductDto;
import com.ex.smart_inventory_management.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertService {

	private final ProductRepository productRepository;

	public List<AlertResponseDto> getAlerts(){

		List<ProductDto> products = productRepository.findAll();

		return products.stream()
				.filter(p -> p.getQuantity() <= p.getMinimumStock())
				.map(p -> {
					AlertResponseDto a = new AlertResponseDto();
					a.setProductId(p.getId());
					a.setProductName(p.getName());
					a.setQuantity(p.getQuantity());
					a.setMinimumStock(p.getMinimumStock());
					a.setMessage("Product stock is low");
					return a;
				})
				.collect(Collectors.toList());

	}

}
