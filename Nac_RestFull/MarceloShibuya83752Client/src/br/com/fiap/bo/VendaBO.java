package br.com.fiap.bo;

import br.com.fiap.repository.Servico;
import br.com.fiap.to.VendaTO;

public class VendaBO {

	private Servico servico = null;

	public VendaTO[] listagem() {
		servico = new Servico();
		return servico.getService();
	}

	public VendaTO listagem(int cod) {
		servico = new Servico();
		return servico.getService(cod);
	}

	public void excluir(int cod) {
		servico = new Servico();
		servico.deleteService(cod);
	}

	public void atualizar(VendaTO venda) {
		servico = new Servico();
		servico.putService(venda, venda.getCodigo());
	}

	public void cadastrar(VendaTO venda) {
		servico = new Servico();
		servico.postService(venda);
	}
}
