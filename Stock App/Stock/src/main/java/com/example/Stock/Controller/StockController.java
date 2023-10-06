package com.example.Stock.Controller;

import com.example.Stock.Model.StockModel;
import com.example.Stock.Model.Type;
import com.example.Stock.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @GetMapping("stock")
    public List<StockModel> getAllStocks(){
        return stockService.getAllStocks();
    }

    @GetMapping("Stock/{Id}")
    public StockModel getByStockId(@PathVariable Integer Id){
        return stockService.getByStockId(Id);
    }

    @PostMapping("Stocks")
    public String addStocks(@RequestBody StockModel stocks){
        return stockService.addStocks(stocks);
    }

    @PostMapping("StocksList")
    public String addNoOfStocks(@RequestBody List<StockModel> stocks){
        return stockService.addNoOfStocks(stocks);
    }

    @PutMapping("update/{id}/stockname")
    public String updateStockNameById(@PathVariable Integer id, @RequestBody String stockname){
        return stockService.updateStockNameById(id, stockname);
    }

    @GetMapping("stockName/{price}")
    public List<StockModel> getStockNameByPrice(@PathVariable Double price){
        return stockService.getStockNameByPrice(price);
    }

    @GetMapping("stock/type/{type}/TypeGreaterThanPrice/{price}")
    public List<StockModel> getStocksByTypeGreaterThanPrice(@PathVariable Type type, @PathVariable Double price){
        return stockService.getStocksByTypeGreaterThanPrice(type,price);
    }

    @GetMapping("stocks/{from}/starting/{till}")
    public List<StockModel> getStocksByStartTimeAfterAndStartTineBefore(@PathVariable LocalDateTime from , @PathVariable LocalDateTime till){
        return stockService.getStocksByStartTimeAfterAndStartTimeBefore(from,till);
    }

    @GetMapping("stocks/{price}/{time}")
    public List<StockModel> getStocksByLessPriceLessTime(@PathVariable Double price, @PathVariable LocalDateTime time){
        return stockService.getStocksByLessPriceLessTime(price,time);
    }

    @PutMapping("stock/price/type")
    public String updateStockByType(@RequestParam float hike,@RequestParam Type stockType)
    {
        return stockService.updateStockByType(hike,stockType);
    }
//
//    @DeleteMapping("stocks/id/{id}")
//    public String deleteById(@PathVariable Integer id){
//        return stockService.deleteById(id);
//    }

    @DeleteMapping("stock/stockOwnerCountLessThan/{count}")
    public String countLessThan(@PathVariable Integer count){
        return stockService.countLessThan(count);
    }

    @DeleteMapping("stock/{id}")
    public String removeEventById(@PathVariable Integer id){
        return stockService.removeEventById(id);
    }

}
