package br.com.chocode.back.services;

import java.util.ArrayList;
import java.util.List;

import br.com.chocode.back.DTO.EntregadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.chocode.back.dao.EntregadorDAO;
import br.com.chocode.back.model.Entregador;
import br.com.chocode.back.security.ChocodeCrypto;
import br.com.chocode.back.security.Token;
import br.com.chocode.back.security.TokenUtil;

@Component
public class EntregadorServiceImpl implements IEntregadorService {
	private final EntregadorDAO dao;

	@Autowired
	public EntregadorServiceImpl(EntregadorDAO dao) {
		this.dao = dao;
	}

	@Override
	public EntregadorDTO save(Entregador entregador) {
		String senhaLogin;
		System.out.println("Aqui" + entregador);
		try {
			senhaLogin = ChocodeCrypto.encrypt(entregador.getSenha());
			entregador.setSenha(senhaLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new EntregadorDTO(dao.saveAndFlush(entregador));
	}

	@Override
	public List<EntregadorDTO> findAll() {
		List<Entregador> listaEntregadores = dao.findAll();
		List<EntregadorDTO> listaEntregadoresDTO = new ArrayList<>();
		for (Entregador entregador : listaEntregadores)
			listaEntregadoresDTO.add(new EntregadorDTO(entregador));
		return listaEntregadoresDTO;
	}
	@Override
	public EntregadorDTO findById(Long id) {
		return new EntregadorDTO(dao.findById(id).get());
	}
	@Override
	public Entregador findByIdModel(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public Token gerarTokenDeUsuarioLogado(Entregador dadosLogin) {
		Entregador user = dao.findByEmail(dadosLogin.getEmail());

		try {
			if (user != null) {

				String senhaLogin = ChocodeCrypto.encrypt(dadosLogin.getSenha());

				if (senhaLogin.equals(user.getSenha())) {
					return new Token(TokenUtil.createToken(user), user.getId(), user.getNome(), user.getUrlImage());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
