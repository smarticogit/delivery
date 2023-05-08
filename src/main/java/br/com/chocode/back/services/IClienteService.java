package br.com.chocode.back.services;

import br.com.chocode.back.model.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente save(Cliente cliente);

    public List<Cliente> findAll();

    public Cliente findById(Long id);
}
