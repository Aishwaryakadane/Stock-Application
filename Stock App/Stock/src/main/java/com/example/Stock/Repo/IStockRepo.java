package com.example.Stock.Repo;

import com.example.Stock.Model.StockModel;
import com.example.Stock.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IStockRepo extends JpaRepository<StockModel,Integer> {
   // List<StockModel> findStockNameLessThenAndEqualToPrice(Double price);

    List<StockModel> findByStockPriceLessThanEqual(Double price);

    List<StockModel> findByStockTypeAndStockPriceGreaterThan(Type type, Double price);

    List<StockModel> findByStockTimeStampAfterAndStockTimeStampBefore(LocalDateTime from, LocalDateTime till);

    List<StockModel> findByStockPriceLessThanAndStockTimeStampLessThanOrderByStockNameDesc(Double price, LocalDateTime time);



    @Modifying
    @Query(value = "UPDATE STOCK_MODEL SET STOCK_PRICE = (STOCK_PRICE + STOCK_PRICE*(:hike)) WHERE STOCK_TYPE = :stockType",nativeQuery = true)
    void updateStockByType(float hike, String stockType);


    @Modifying
    @Query(value = "DELETE FROM STOCK_MODEL WHERE STOCK_OWNER_COUNT<= :count",nativeQuery = true)
    void countLessThan(Integer count);
}




