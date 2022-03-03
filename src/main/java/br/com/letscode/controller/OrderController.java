package br.com.letscode.controller;

import br.com.letscode.dto.OrderDTO;
import br.com.letscode.dto.ReturnOrderDto;
import br.com.letscode.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @GetMapping
    public String onInit() {
        return "index";
    }

    @GetMapping("/form")
    public String getForm() {
        return "order-form";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<ReturnOrderDto> returnDto = service.getAll();
        model.addAttribute("orders", returnDto);
        return "orders-list";
    }

    @PostMapping("/new-order")
    public RedirectView order(OrderDTO orderDTO, RedirectAttributes redirectAttributes) {
        service.save(orderDTO);

        redirectAttributes.addFlashAttribute("orders", this.service.getAll());

        return new RedirectView("/orders/list", true);

    }

}
