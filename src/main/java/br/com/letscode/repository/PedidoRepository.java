package br.com.letscode.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import br.com.letscode.entity.PedidoEntidade;

public class PedidoRepository {


    public List<PedidoEntidade> getAll() {
        return Arrays.asList(new PedidoEntidade(1L, "Celular", BigDecimal.valueOf(799.0), LocalDate.now(), "iphone"),
            new PedidoEntidade(2L, "Computador", BigDecimal.valueOf(1200), LocalDate.now(), "Positivo"),
            new PedidoEntidade(3L, "Cadeira gamer", BigDecimal.valueOf(1000), LocalDate.now(), "razr"));
    }

}
