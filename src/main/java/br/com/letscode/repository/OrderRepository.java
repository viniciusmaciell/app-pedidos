package br.com.letscode.repository;

import java.time.LocalDate;
import java.util.*;

import br.com.letscode.entity.OrderEntity;

public class OrderRepository {

    private static List<OrderEntity> list = new ArrayList<>();

    public OrderEntity persist(OrderEntity product) {

        String id = UUID.randomUUID().toString();
        product.setId(id);
        list.add(product);

        LocalDate deliveryDate = LocalDate.now().plusDays(10);
        product.setDeliveryDate(deliveryDate);

        return product;

    }

    public List<OrderEntity> getAll() {
        return OrderRepository.list;

    }

}
