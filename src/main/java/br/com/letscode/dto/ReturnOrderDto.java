package br.com.letscode.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class ReturnOrderDto {
    private String product;
    private BigDecimal value;
    private String description;
    private LocalDate deliveryDate;

    public List<ReturnOrderDto> getAll(){
        return null;
    }
}
