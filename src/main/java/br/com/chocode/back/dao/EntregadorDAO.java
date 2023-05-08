package br.com.chocode.back.dao;

import br.com.chocode.back.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorDAO extends JpaRepository<Entregador, Long> {
	Entregador findByEmail(String email);
}
