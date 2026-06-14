package com.ex.smart_inventory_management.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

	private final AlertService service;

	@GetMapping
	public List<AlertResponseDto> getAlerts(){
		return service.getAlerts();
	}

}
