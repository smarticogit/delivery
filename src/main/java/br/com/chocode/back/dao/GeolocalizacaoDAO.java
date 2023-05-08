package br.com.chocode.back.dao;
import br.com.chocode.back.model.Geolocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GeolocalizacaoDAO extends JpaRepository<Geolocalizacao, Long> {
    List<Geolocalizacao> findByPedidoId(Long pedidoId);

}
