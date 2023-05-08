package br.com.chocode.back.security;

import javax.persistence.Column;

public class Token {

	private String token;
	private Long id;
	private String nome;
	private String urlImage;

	public Token(String token, Long id, String nome, String urlImage) {
		this.token = token;
		this.id = id;
		this.nome = nome;
		this.urlImage = urlImage;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
