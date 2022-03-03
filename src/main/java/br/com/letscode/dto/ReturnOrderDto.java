package br.com.letscode.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReturnOrderDto {
    private String product;
    private BigDecimal value;
    private String description;
    private LocalDate deliveryDate;

}
