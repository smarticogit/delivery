package br.com.chocode.back.DTO;

import br.com.chocode.back.model.Geolocalizacao;
import java.time.LocalDateTime;

public class GeolocalizacaoDTO {
    private Long id;

    private String latitude;

    private String longitude;

    private LocalDateTime data;

    private Long idEntregador;

    private Long idPedido;

    public GeolocalizacaoDTO() {
    }

    public GeolocalizacaoDTO(Long id, String latitude, String longitude, LocalDateTime data, Long idEntregador, Long idPedido) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.idEntregador = idEntregador;
        this.idPedido = idPedido;
    }

    public GeolocalizacaoDTO(Geolocalizacao geolocalizacao) {
        this.id = geolocalizacao.getId();
        this.latitude = geolocalizacao.getLatitude();
        this.longitude = geolocalizacao.getLongitude();
        this.data = geolocalizacao.getData();
        this.idEntregador = geolocalizacao.getEntregador().getId();
        this.idPedido = geolocalizacao.getPedido().getId();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Long idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
