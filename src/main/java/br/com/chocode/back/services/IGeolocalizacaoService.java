package br.com.chocode.back.services;

import br.com.chocode.back.DTO.GeolocalizacaoDTO;
import br.com.chocode.back.model.Geolocalizacao;

import java.util.List;

public interface IGeolocalizacaoService {
    public GeolocalizacaoDTO save(GeolocalizacaoDTO geolocalizacaoDTO);

    public List<GeolocalizacaoDTO> findAll();

    public Geolocalizacao findById(Long id);

    public List<GeolocalizacaoDTO> findByPedidoId(Long id);

}
