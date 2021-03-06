package br.com.fiap.to;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VendaTO {
	
	private int codigo;
	private String nome;
	private Calendar dtVenda;
	private String descricao;
	private double valor;
	private String status;
	
	public VendaTO() {
		super();
	}

	public VendaTO(int codigo, String nome, Calendar dtVenda, String descricao, double valor, String status) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtVenda = dtVenda;
		this.descricao = descricao;
		this.valor = valor;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtVenda() {
		return dtVenda;
	}

	public void setDtVenda(Calendar dtVenda) {
		this.dtVenda = dtVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
