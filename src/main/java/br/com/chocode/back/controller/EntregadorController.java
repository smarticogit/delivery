package br.com.chocode.back.controller;

import br.com.chocode.back.DTO.EntregadorDTO;
import br.com.chocode.back.model.Entregador;
import br.com.chocode.back.security.Token;
import br.com.chocode.back.services.IEntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/entregadores")
public class EntregadorController {
	
	@Autowired
	private IEntregadorService service;

	@PostMapping
	public ResponseEntity<EntregadorDTO> save(@RequestBody Entregador entregador) {
		return ResponseEntity.status(201).body(service.save(entregador));
	}

	@GetMapping
	public ResponseEntity<List<EntregadorDTO>> findAll() {
		return ResponseEntity.status(200).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntregadorDTO> findById(@PathVariable Long id) {
		EntregadorDTO entregador = service.findById(id);
		if (entregador == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(entregador);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Token> realizarLogin(@RequestBody Entregador dadosLogin) {
		Token token = service.gerarTokenDeUsuarioLogado(dadosLogin);

		if (token == null) {
			return ResponseEntity.status(401).body(null);
		}
		return ResponseEntity.status(200).body(token);

	}
}
