package ae1.service;

import ae1.beans.DistritoTO;
import java.util.List;

public interface DistritoService {
    public int crearDistrito(DistritoTO distrito);
    public int eliminarDistrito(String codigo);
    public int actualizarDistrito(DistritoTO distrito);
    public List<DistritoTO> obtenerDistritos();
    public DistritoTO buscarDistrito(String codigo);
}
