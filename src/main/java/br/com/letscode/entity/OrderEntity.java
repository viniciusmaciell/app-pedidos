package br.com.letscode.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderEntity {
    private String id;
    private String product;
    private BigDecimal value;
    private LocalDate deliveryDate;
    private String description;

    public OrderEntity(){

    }


}
