package br.com.chocode.back.services;

import java.util.List;

import br.com.chocode.back.DTO.EntregadorDTO;
import br.com.chocode.back.model.Entregador;
import br.com.chocode.back.security.Token;

public interface IEntregadorService {

	public EntregadorDTO save(Entregador entregador);

	public List<EntregadorDTO> findAll();

	public EntregadorDTO findById(Long id);

	public Entregador findByIdModel(Long id);

	public Token gerarTokenDeUsuarioLogado(Entregador dadosLogin);
}