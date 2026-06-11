package com.ex.smart_inventory_management.stock;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StockService {


    private final StockRepository repo;



// Add Stock

    public StockDto addStock(StockDto stock){


        return repo.save(stock);

    }



// View Stock

    public List<StockDto> getStock(){


        return repo.findAll();

    }

// Reduce Stock

    public StockDto reduceStock(
            Long id,int quantity){



        StockDto stock =
                repo.findById(id)
                        .orElseThrow();



        if(stock.getAvailableStock() >= quantity){


            stock.setAvailableStock(
                    stock.getAvailableStock()-quantity
            );


        }
        else{

            throw new RuntimeException(
                    "Not enough stock");

        }

        return repo.save(stock);

    }

// Allocate / Reserve Stock

    public StockDto allocateStock(
            Long id,int quantity){


        StockDto stock =
                repo.findById(id)
                        .orElseThrow();


        if(stock.getAvailableStock() >= quantity){


            stock.setAvailableStock(
                    stock.getAvailableStock()-quantity);


            stock.setReservedStock(
                    stock.getReservedStock()+quantity);


        }
        else{

            throw new RuntimeException(
                    "Stock not available");

        }

        return repo.save(stock);

    }

}
