package br.com.letscode.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {
    private String product;
    private BigDecimal value;
    private String description;

}
