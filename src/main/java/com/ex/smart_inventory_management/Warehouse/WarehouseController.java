package com.ex.smart_inventory_management.Warehouse;
import java.util.List;


import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor


public class WarehouseController {
    private final WarehouseService service;



    @PostMapping
    public WarehouseDto add(
        @RequestBody WarehouseDto
                warehouse){

    return service.addWarehouse(warehouse);

}



@GetMapping
public List<WarehouseDto> get(){

    return service.getAll();

}



@PutMapping("/{id}")
public WarehouseDto update(
        @PathVariable Long id,
        @RequestBody WarehouseDto warehouse){

    return service.updateWarehouse(id,warehouse);

}



@DeleteMapping("/{id}")
public String delete(
        @PathVariable Long id){

    service.deleteWarehouse(id);

    return "Warehouse Deleted";

}


}
