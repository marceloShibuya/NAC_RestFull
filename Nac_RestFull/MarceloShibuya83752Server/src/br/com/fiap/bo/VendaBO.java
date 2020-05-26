package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.VendaDAO;
import br.com.fiap.to.VendaTO;

public class VendaBO {
	
	private VendaDAO dao = null;
	
	public List<VendaTO> listagem(){
		dao = new VendaDAO();
		return dao.select();
	}
	
	public VendaTO listagem(int cod) {
		dao = new VendaDAO();
		return dao.select(cod);
	}
	
	public boolean cadastrarVenda(VendaTO venda) {
		dao = new VendaDAO();
		return dao.insert(venda);
	}
	
	public boolean atualizarVenda(VendaTO venda) {
		dao = new VendaDAO();
		return dao.update(venda);
	}
	
	public void excluir(int cod) {
		dao = new VendaDAO();
		dao.delete(cod);
	}

}