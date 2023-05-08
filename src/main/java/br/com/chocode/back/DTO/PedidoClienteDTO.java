package br.com.chocode.back.DTO;

import br.com.chocode.back.model.Cliente;
import br.com.chocode.back.model.Pedido;

public class PedidoClienteDTO {
    private Long id;

    private String nomeRestaurante;

    private String produto;

    private String status;

    private Long idEntregador;

    private Cliente cliente;

    public PedidoClienteDTO() {
    }

    public PedidoClienteDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.nomeRestaurante = pedido.getNomeRestaurante();
        this.produto = pedido.getProduto();
        this.status = pedido.getStatus();
        if (pedido.getEntregador() != null)
            this.idEntregador = pedido.getEntregador().getId();
        this.cliente = pedido.getCliente();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(Long idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
