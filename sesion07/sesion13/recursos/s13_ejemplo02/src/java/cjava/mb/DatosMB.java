package cjava.mb;

import java.util.ArrayList;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

public class DatosMB {

    private String seleccion="peru";
    private String pais;
    private ArrayList<SelectItem> paises;

    private String departamento;
    private String provincia;

    private ArrayList<SelectItem>  listaDepartamentos = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listaProvincias = new ArrayList<SelectItem>(); 

    public ArrayList<SelectItem> getListaDepartamentos() {
         listaDepartamentos = new ArrayList<SelectItem>();
        listaDepartamentos.add(new SelectItem("d1","Lima"));
        listaDepartamentos.add(new SelectItem("d2","La Libertad"));
        return listaDepartamentos;
    }

    public void setListaDepartamentos(ArrayList<SelectItem> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public ArrayList<SelectItem> getPaises() {
        paises = new ArrayList<SelectItem>();
        paises.add(new SelectItem("peru","Peru"));
        paises.add(new SelectItem("ecuador","Ecuador"));
        paises.add(new SelectItem("bolivia","Bolivia"));
        return paises;
    }

    public void setPaises(ArrayList<SelectItem> paises) {
        this.paises = paises;
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

      public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    

    public ArrayList<SelectItem> getListaProvincias() {
        return listaProvincias;
    }

    public void setListaProvincias(ArrayList<SelectItem> listaProvincias) {
        this.listaProvincias = listaProvincias;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public void cambioSeleccion(ValueChangeEvent evento){
        if(evento.getComponent().getId().equals("combo")){
            setSeleccion(evento.getNewValue().toString());
        }
         if(evento.getComponent().getId().equals("departamento")){
                listaProvincias = new ArrayList<SelectItem>();
                if(evento.getNewValue().toString().equals("d1")){
                     listaProvincias.add(new SelectItem("p1","Lima"));
                     listaProvincias.add(new SelectItem("p2","Huacho"));
                }
                if(evento.getNewValue().toString().equals("d2")){
                     listaProvincias.add(new SelectItem("p3","Trujillo"));
                     listaProvincias.add(new SelectItem("p4","xxxx"));
                }
         }
    }
    

}
