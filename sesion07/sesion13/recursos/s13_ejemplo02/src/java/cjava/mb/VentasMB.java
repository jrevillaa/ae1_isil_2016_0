package cjava.mb;

import cjava.beans.Item;
import java.util.ArrayList;
import java.util.List;

public class VentasMB {
    
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private List<Item> listaItems =new ArrayList<Item>();

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public void agregarItem(){
        Item item = new Item();
        item.setNombre(nombre);
        item.setPrecio(precio);
        item.setCantidad(cantidad);
        listaItems.add(item);
    }
    
}
