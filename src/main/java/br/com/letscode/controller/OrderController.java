package br.com.letscode.controller;

import br.com.letscode.dto.OrderDTO;
import br.com.letscode.entity.OrderEntity;
import br.com.letscode.repository.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping
    public String onInit() {
        return "index";
    }

    @GetMapping("/form")
    public String getForm() {
        return "order-form";
    }

    @GetMapping("/list")
    public String list() {
        return "orders-list";
    }

    @PostMapping("/new-order")
    public RedirectView order(OrderDTO orderDTO, RedirectAttributes redirectAttributes) {

        OrderRepository repository = new OrderRepository();

        OrderEntity entity = new OrderEntity(orderDTO);

        repository.persist(entity);

        redirectAttributes.addFlashAttribute("orders", repository.getAll());

        return new RedirectView("/orders/list", true);

    }

}
