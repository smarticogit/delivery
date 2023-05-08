package br.com.chocode.back.DTO;

import br.com.chocode.back.model.Entregador;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EntregadorDTO {
    private Long id;
    private String nome;
    private String email;
    private String urlImage;

    public EntregadorDTO() {
    }

    public EntregadorDTO(Entregador entregador) {
        this.id = entregador.getId();
        this.nome = entregador.getNome();
        this.email = entregador.getEmail();
        this.urlImage = entregador.getUrlImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
