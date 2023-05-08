package br.com.chocode.back.services;

import br.com.chocode.back.DTO.PedidoClienteDTO;
import br.com.chocode.back.DTO.PedidoDTO;
import br.com.chocode.back.dao.PedidoDAO;
import br.com.chocode.back.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService {
	private final PedidoDAO dao;
	private final IEntregadorService entregadorService;
	private final IClienteService clienteService;

	@Autowired
	public PedidoServiceImpl(PedidoDAO dao, IEntregadorService entregadorService, IClienteService clienteService) {
		this.dao = dao;
		this.entregadorService = entregadorService;
		this.clienteService = clienteService;
	}

	@Override
	public Pedido save(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido(pedidoDTO, clienteService.findById(pedidoDTO.getIdCliente()));
		return dao.saveAndFlush(pedido);
	}

	@Override
	public List<PedidoDTO> findAll() {
		List<Pedido> listaPedidos = dao.findAll(Sort.by(Sort.Direction.ASC, "nomeRestaurante"));
		List<PedidoDTO> listaPedidosDTO = new ArrayList<>();
		for (Pedido pedido : listaPedidos)
			listaPedidosDTO.add(new PedidoDTO(pedido));
		return listaPedidosDTO;
	}

	@Override
	public Pedido findById(Long id) {
		Pedido pedido = dao.findById(id).get();
		return pedido;
	}

	@Override
	public PedidoClienteDTO findByIdCliente(Long id) {
		Pedido pedido = findById(id);
		PedidoClienteDTO pedidoClienteDTO = new PedidoClienteDTO(pedido);
		return pedidoClienteDTO;
	}

	@Override
	public Pedido saveEntregador(Long idPedido, Long idEntregador) {
		Pedido pedido = findById(idPedido);
		pedido.setEntregador(entregadorService.findByIdModel(idEntregador));
		pedido.setStatus("a_caminho");
		return dao.saveAndFlush(pedido);
	}

	@Override
	public Pedido statusCancelado(Long idPedido, Long idEntregador) {
		Pedido pedido = findById(idPedido);
		if (pedido == null || pedido.getEntregador() == null || !pedido.getEntregador().getId().equals(idEntregador))
			return null;
		pedido.setStatus("cancelado");
		return dao.saveAndFlush(pedido);
	}

	@Override
	public Pedido statusEntregue(Long idPedido, Long idEntregador) {
		Pedido pedido = findById(idPedido);
		if (pedido == null || pedido.getEntregador() == null || !pedido.getEntregador().getId().equals(idEntregador))
			return null;
		pedido.setStatus("entregue");
		return dao.saveAndFlush(pedido);
	}

	@Override
	public List<PedidoDTO> findAllStatus(String status) {
		List<Pedido> listaPedidos = dao.findByStatusOrderByNomeRestaurante(status);
		List<PedidoDTO> listaPedidosDTO = new ArrayList<>();
		for (Pedido pedido : listaPedidos){
			if ( pedido.getCliente() != null)
				listaPedidosDTO.add(new PedidoDTO(pedido));
		}
		return listaPedidosDTO;
	}

	@Override
	public List<PedidoDTO> findAllEntregadorStatus(Long id, String status) {
		List<Pedido> listaPedidos = dao.findByEntregadorIdAndStatus(id, status);
		List<PedidoDTO> listaPedidosDTO = new ArrayList<>();
		for (Pedido pedido : listaPedidos){
			if ( pedido.getCliente() != null)
				listaPedidosDTO.add(new PedidoDTO(pedido));
		}
		return listaPedidosDTO;
	}
}
