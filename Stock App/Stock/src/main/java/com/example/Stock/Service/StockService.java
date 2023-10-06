package com.example.Stock.Service;

import com.example.Stock.Model.StockModel;
import com.example.Stock.Model.Type;
import com.example.Stock.Repo.IStockRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    IStockRepo stockRepo;


    public List<StockModel> getAllStocks() {
        return stockRepo.findAll();
    }

    public StockModel getByStockId(Integer Id) {
        return stockRepo.findById(Id).orElseThrow();
    }

    public String addStocks(StockModel stocks) {
        stockRepo.save(stocks);
        return "Stocks added";
    }

    public String addNoOfStocks(List<StockModel> stocks) {
        stockRepo.saveAll(stocks);
        return "No. of Stocks ";
    }

    public String updateStockNameById(Integer id, String stockname) {
        StockModel curStock = stockRepo.findById(id).orElse(null);
        if(curStock!=null){
            curStock.setStockName(stockname);
            stockRepo.save(curStock);
            return "Stock name updated ..........";
        }
        else{
            return "id not found";
        }
    }

    public List<StockModel> getStockNameByPrice(Double price) {
        return stockRepo.findByStockPriceLessThanEqual(price);
    }

    public List<StockModel> getStocksByTypeGreaterThanPrice(Type type, Double price) {
        return stockRepo.findByStockTypeAndStockPriceGreaterThan(type,price);
    }

    public List<StockModel> getStocksByStartTimeAfterAndStartTimeBefore(LocalDateTime from, LocalDateTime till) {
        return stockRepo.findByStockTimeStampAfterAndStockTimeStampBefore(from, till);
    }


    public List<StockModel> getStocksByLessPriceLessTime(Double price, LocalDateTime time) {
        return stockRepo.findByStockPriceLessThanAndStockTimeStampLessThanOrderByStockNameDesc(price,time);
    }

    @Transactional
    public String updateStockByType(float hike, Type stockType) {
        stockRepo.updateStockByType(hike,stockType.name());
        return "updated";
    }

//    public String deleteById(Integer id) {
//       stockRepo.deleteById(id);
//       return "deleted";
//    }

    public String removeEventById(Integer id){
        StockModel s = stockRepo.findById(id).orElse(null);

        if(s==null){
            return "Id not found";
        }

        stockRepo.delete(s);

        return "stock is removed !!!";
    }

    @Transactional
    public String countLessThan(Integer count) {
       stockRepo.countLessThan(count);
       return "Stock Owner removed....";
    }
}

