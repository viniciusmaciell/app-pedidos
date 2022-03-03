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

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;

    }

    public void save(OrderDTO orderDTO) {
        OrderEntity entity = new OrderEntity();

        entity.setProduct(orderDTO.getProduct());
        entity.setDescription(orderDTO.getDescription());
        entity.setValue(orderDTO.getValue());

        LocalDate date = calcDeliveryDate(orderDTO.getState());
        entity.setDeliveryDate(date);

        repository.save(entity);
    }

    public List<ReturnOrderDto> getAll() {

        List<OrderEntity> entities = repository.getAll();

        return entities.stream()
                .map(entity -> {
                    ReturnOrderDto orderDto = new ReturnOrderDto();
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
