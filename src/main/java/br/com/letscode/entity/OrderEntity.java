package br.com.letscode.entity;

import br.com.letscode.dto.OrderDTO;
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

/*    public OrderEntity(OrderDTO orderDTO) {
        this.product = orderDTO.getProduct();
        this.value = orderDTO.getValue();
        this.description = orderDTO.getDescription();

    }*/

    public OrderEntity(){

    }


}
