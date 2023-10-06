package com.example.Stock.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StockModel {

    @Id
    @NotNull
    private Integer stockId;

    @NotBlank
    private String stockName;

    @NotNull
    private Double stockPrice;


    private Integer stockOwnerCount;

    @Enumerated(EnumType.STRING)
    private Type stockType;
    private LocalDateTime stockTimeStamp;

}
