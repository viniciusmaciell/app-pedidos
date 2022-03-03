package br.com.letscode.repository;

import br.com.letscode.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class OrderRepository {

    private static List<OrderEntity> list = new ArrayList<>();

    public OrderEntity save(OrderEntity product) {

        String id = UUID.randomUUID().toString();
        product.setId(id);
        list.add(product);

        return product;

    }

    public List<OrderEntity> getAll() {
        return OrderRepository.list;

    }

}
