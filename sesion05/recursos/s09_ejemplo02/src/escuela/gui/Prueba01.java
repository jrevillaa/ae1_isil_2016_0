package escuela.gui;

import escuela.daos.CursoJpaDao;
import escuela.entidades.Curso;


public class Prueba01 {
    public static void main(String[] args){
        Curso cur = new Curso();
        cur.setChrCurCodigo("c06");
        cur.setVchCurNombre("nuevo curso");
        cur.setIntCurCreditos(4);
        //new CursoJpaDao().create(cur);
        new CursoJpaDao().delete("c06");
    }
}
