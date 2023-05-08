package br.com.chocode.back.controller;

import br.com.chocode.back.DTO.GeolocalizacaoDTO;
import br.com.chocode.back.model.Geolocalizacao;
import br.com.chocode.back.services.IGeolocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/geolocalizacoes")
public class GeolocalizacaoController {
	
	@Autowired
	private IGeolocalizacaoService service;

	@PostMapping
	public ResponseEntity<GeolocalizacaoDTO> save(@RequestBody GeolocalizacaoDTO geolocalizacaoDTO) {
		GeolocalizacaoDTO geolocalizacao = service.save(geolocalizacaoDTO);
		if (geolocalizacao == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(201).body(geolocalizacao);
	}

	@GetMapping
	public ResponseEntity<List<GeolocalizacaoDTO>> findAll() {
		return ResponseEntity.status(200).body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Geolocalizacao> findById(@PathVariable Long id) {
		Geolocalizacao geolocalizacao = service.findById(id);
		if (geolocalizacao == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(geolocalizacao);
	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<List<GeolocalizacaoDTO>> findAllGeo(@PathVariable Long id) {
		List<GeolocalizacaoDTO> geoPedido = service.findByPedidoId(id);
		if (geoPedido == null) {
			return ResponseEntity.status(404).body(null);
		}
		return ResponseEntity.status(200).body(geoPedido);
	}

}
