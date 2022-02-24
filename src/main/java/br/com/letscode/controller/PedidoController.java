package br.com.letscode.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.letscode.entity.PedidoEntidade;
import br.com.letscode.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping("/listar")
    public String listar(Model model) {
        PedidoRepository repository = new PedidoRepository();

        List<PedidoEntidade> todosPedidos = repository.getAll();

        model.addAttribute("pedidos", todosPedidos);

        return "listar-pedidos";
    }


}
