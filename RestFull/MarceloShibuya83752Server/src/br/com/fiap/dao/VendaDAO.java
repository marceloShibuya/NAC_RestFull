package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.to.VendaTO;

public class VendaDAO {

	public static List<VendaTO> listaVendas = null;

	public VendaDAO() {

		if (listaVendas == null) {
			listaVendas = new ArrayList<VendaTO>();

			VendaTO vto = new VendaTO(1, "Pedro", new GregorianCalendar(2019, Calendar.DECEMBER, 25), "Arvore de Natal",
					1000.00, "sim");
			listaVendas.add(vto);

			vto = new VendaTO(2, "Gustavo", new GregorianCalendar(2018, Calendar.JANUARY, 02), "Celular", 1500.00,
					"sim");
			listaVendas.add(vto);

			vto = new VendaTO(3, "Marcelo", new GregorianCalendar(2020, Calendar.MARCH, 21), "Caixa de Som", 1990.00,
					"não");
			listaVendas.add(vto);

			vto = new VendaTO(4, "Felipe", new GregorianCalendar(2020, Calendar.APRIL, 01), "Microfone", 2099.00,
					"sim");
			listaVendas.add(vto);

			vto = new VendaTO(5, "Luiz", new GregorianCalendar(2020, Calendar.MARCH, 10), "Notebook", 3990.00, "não");
			listaVendas.add(vto);

			vto = new VendaTO(6, "Josefina", new GregorianCalendar(2020, Calendar.APRIL, 20), "Estojo de Maquiagem",
					3100.00, "sim");
			listaVendas.add(vto);

			vto = new VendaTO(7, "Gabriel", new GregorianCalendar(2019, Calendar.NOVEMBER, 30), "Capa de Celular",
					1000.00, "sim");
			listaVendas.add(vto);

			vto = new VendaTO(8, "Rafael", new GregorianCalendar(2020, Calendar.FEBRUARY, 15), "TV 50'", 2590.00,
					"não");
			listaVendas.add(vto);

			vto = new VendaTO(9, "Emanuel", new GregorianCalendar(2019, Calendar.OCTOBER, 03), "Fone de Ouvido",
					1699.00, "não");
			listaVendas.add(vto);

			vto = new VendaTO(10, "Maria", new GregorianCalendar(2019, Calendar.JULY, 19), "Impressora", 2599.00,
					"sim");
			listaVendas.add(vto);

		}

	}

	public List<VendaTO> select() {
		return listaVendas;
	}

	public VendaTO select(int cod) {
		for (int x = 0; x < listaVendas.size(); x++) {
			if (listaVendas.get(x).getCodigo() == cod) {
				return listaVendas.get(x);
			}
		}
		return null;
	}

	public boolean insert(VendaTO venda) {

		if (venda != null) {
			venda.setCodigo((listaVendas.get(listaVendas.size() - 1).getCodigo() + 1));
			return listaVendas.add(venda);
		}
		return false;
	}

	public boolean update(VendaTO venda) {

		if (venda != null) {
			for (int x = 0; x < listaVendas.size(); x++) {
				if (listaVendas.get(x).getCodigo() == venda.getCodigo()) {
					listaVendas.set(x, venda);
					return true;
				}
			}
		}
		return false;
	}

	public void delete(int cod) {
		for (int x = 0; x < listaVendas.size(); x++) {
			if (listaVendas.get(x).getCodigo() == cod) {
				listaVendas.remove(x);
			}
		}
	}

}
