package com.ex.smart_inventory_management.Warehouse;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor

public class WarehouseService {
    private final WarehouseRepository repo;



    public WarehouseDto addWarehouse(
            WarehouseDto warehouse){

        return repo.save(warehouse);

    }



    public List<WarehouseDto> getAll(){

        return repo.findAll();

    }



    public WarehouseDto updateWarehouse(
            Long id, WarehouseDto newData){


        WarehouseDto old =
                repo.findById(id).orElseThrow();



        old.setWarehouseName(
                newData.getWarehouseName());


        old.setLocation(
                newData.getLocation());


        return repo.save(old);

    }



    public void deleteWarehouse(Long id){

        repo.deleteById(id);

    }


}





