package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private Long cliente;
	private Long empleado;
	private List<CarritoItem> items;

	public Carrito() {
		items = new ArrayList<CarritoItem>();
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}



	public List<CarritoItem> getItems() {
		return items;
	}

	public void add(CarritoItem item) {
		if (item == null) {
			return;
		}
		boolean encontro = false;
		for (CarritoItem i : items) {
			if( i.getId() == item.getId() ){
				i.setCant( i.getCant() + item.getCant());
				i.setSubtotal( i.getSubtotal() + item.getSubtotal());
				encontro = true;
			}
		}
		if (!encontro) {
			items.add(item);
		}
		int k = 0;
		while( k < items.size() ){
			if( items.get(k).getCant() <= 0 ){
				items.remove(k);
			} else {
				k++;
			}
		}
	}

	public Double getTotal() {
		Double t = 0.0;
		for (CarritoItem i : items) {
			t += i.getSubtotal();
		}
		return t;
	}

	public Double getImporte() {
		Double i;
		i = getTotal() / 1.18;
		return i;
	}

	public Double getImpuesto() {
		Double imp;
		imp = getTotal() - getImporte();
		return imp;
	}

	public void remove( Long id ) {
		for (CarritoItem i : items) {
			if( i.getId() == id ){
				items.remove(i);
				break;
			}
		}
	}

	public void clear() {
		items.clear();
	}
}
