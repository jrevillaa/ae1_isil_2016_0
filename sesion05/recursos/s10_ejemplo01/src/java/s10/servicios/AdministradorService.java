package s10.servicios;

import s10.entidades.Administrador;

public interface AdministradorService {
    public Administrador validar(String user, String password);
}
