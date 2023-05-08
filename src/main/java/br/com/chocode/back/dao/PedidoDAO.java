package br.com.chocode.back.dao;

import br.com.chocode.back.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatusOrderByNomeRestaurante(String status);
    List<Pedido> findByEntregadorIdAndStatus(Long EntregadorId, String status);

}
