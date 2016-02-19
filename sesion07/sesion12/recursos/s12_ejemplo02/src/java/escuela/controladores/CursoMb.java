package escuela.controladores;

import escuela.daos.CursoJpaDao;
import escuela.entidades.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CursoMb {
    private Curso curso;
    private List<Curso> lista;
    private CursoJpaDao dao;
    
    public CursoMb(){
        curso= new Curso();
        lista = new ArrayList<Curso>();
        dao = new CursoJpaDao(Curso.class);
    }
    
    public void grabar(){
        dao.create(curso);
        //return "ok";
    }
    
    public void eliminar(String id){
        Curso c = dao.find(id);
        dao.remove(c);
    }
    
    public void actualizar(Curso c){
        dao.edit(c);
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getLista() {
        lista = dao.findAll();
        return lista;
    }

    public void setLista(List<Curso> lista) {
        this.lista = lista;
    }
    
    
}
