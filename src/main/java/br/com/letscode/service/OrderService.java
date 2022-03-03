package br.com.letscode.service;


import br.com.letscode.dto.OrderDTO;
import br.com.letscode.dto.ReturnOrderDto;
import br.com.letscode.entity.OrderEntity;
import br.com.letscode.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    public OrderEntity save(OrderEntity product) {
//
//        String id = UUID.randomUUID().toString();
//        product.setId(id);
//
//        orderRepository.save(product);
//
//        return product;
//
//    }

    public void save(OrderDTO orderDTO) {
        OrderRepository repository = new OrderRepository();


        OrderEntity entity = new OrderEntity();

        entity.setProduct(orderDTO.getProduct());
        entity.setProduct(orderDTO.getDescription());
        entity.setValue(orderDTO.getValue());

        LocalDate date = calcDeliveryDate(orderDTO.getState());
        entity.setDeliveryDate(date);

        repository.save(entity);
    }

    public List<ReturnOrderDto> getAll() {
        OrderRepository repository = new OrderRepository();

        List<OrderEntity> entities = repository.getAll();

        return entities.stream()
                .map(entity -> {
                    ReturnOrderDto orderDto = new ReturnOrderDto();

//                    orderDto.setProduct(entity.getProduct());
//                    orderDto.setDeliveryDate(entity.getDeliveryDate());
//                    orderDto.setDescription(entity.getDescription());
//                    orderDto.setValue(entity.getValue());

                    BeanUtils.copyProperties(entity, orderDto);

                    return orderDto;
                })
                .collect(Collectors.toList());
    }

    private LocalDate calcDeliveryDate(String state) {
        Map<String, Integer> deadLine = new HashMap<>();
        deadLine.put("SP", 5);
        deadLine.put("RJ", 7);
        deadLine.put("BA", 7);
        deadLine.put("MG", 10);
        deadLine.put("DF", 4);

        return LocalDate.now().plusDays(deadLine.get(state));
    }
}