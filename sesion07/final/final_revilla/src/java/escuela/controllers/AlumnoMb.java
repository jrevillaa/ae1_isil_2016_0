/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.controllers;

import escuela.daos.AlumnoJpaDao;
import escuela.entidades.Alumno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Alumno-CT
 */
@ManagedBean
@SessionScoped
public class AlumnoMb {
    private Alumno curso;
    private List<Alumno> lista;
    private AlumnoJpaDao dao;
    SimpleDateFormat formatter;
    
    public AlumnoMb(){
        curso= new Alumno();
        lista = new ArrayList<Alumno>();
        dao = new AlumnoJpaDao(Alumno.class);
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
    }
    
    public void grabar(){
        dao.create(curso);
        //return "ok";
    }
    
    public void eliminar(String id){
        Alumno c = dao.find(id);
        dao.remove(c);
    }
    
    public void actualizar(Alumno c){
        dao.edit(c);
    }
    
    public Alumno getCurso() {
        return curso;
    }

    public void setCurso(Alumno curso) {
        this.curso = curso;
    }

    public List<Alumno> getLista() {
        lista = dao.findAll();
        return lista;
    }

    public void setLista(List<Alumno> lista) {
        this.lista = lista;
    }
}
