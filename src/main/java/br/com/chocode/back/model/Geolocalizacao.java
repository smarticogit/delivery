package br.com.chocode.back.model;

import br.com.chocode.back.DTO.GeolocalizacaoDTO;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Geolocalizacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "latitude", nullable = false)
	private String latitude;

	@Column(name = "longitude", nullable = false)
	private String longitude;

	@Column(name = "data", nullable = false)
	private LocalDateTime data;

	@ManyToOne
	@JoinColumn(name = "entregador_id")
	private Entregador entregador;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	public Geolocalizacao() {
	}

	public Geolocalizacao(GeolocalizacaoDTO geolocalizacaoDTO) {
		super();
		this.id = geolocalizacaoDTO.getId();
		this.latitude = geolocalizacaoDTO.getLatitude();
		this.longitude = geolocalizacaoDTO.getLongitude();
		this.data = geolocalizacaoDTO.getData();
	}

	public Geolocalizacao(Long id, String latitude, String longitude, LocalDateTime data, Entregador entregador,
			Pedido pedido) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.data = data;
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

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
