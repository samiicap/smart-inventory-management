package com.ex.smart_inventory_management.stock;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor

public class StockController {
    private final StockService service;
    @PostMapping("/add")
    public StockDto
    add(
            @RequestBody StockDto stock){


        return service.addStock(stock);

    }
//get stock
    @GetMapping
    public List<StockDto> get(){


        return service.getStock();

    }
    // Reduce Stock

    @PutMapping("/reduce")
    public StockDto reduce(
            @RequestParam Long id,
            @RequestParam int quantity){

        return service.reduceStock(
                id,quantity);

    }
    // Allocate Stock

    @PutMapping("/allocate")
    public StockDto allocate(
            @RequestParam Long id,
            @RequestParam int quantity){


        return service.allocateStock(
                id,quantity);

    }


}


