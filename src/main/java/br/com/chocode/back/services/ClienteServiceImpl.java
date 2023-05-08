package br.com.chocode.back.services;

import br.com.chocode.back.dao.ClienteDAO;
import br.com.chocode.back.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService{
    private ClienteDAO dao;

    @Autowired
    public ClienteServiceImpl(ClienteDAO dao) {
        this.dao = dao;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return dao.saveAndFlush(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listaClientes = dao.findAll();
        return listaClientes;
    }

    @Override
    public Cliente findById(Long id) {
        return dao.findById(id).get();
    }
}
