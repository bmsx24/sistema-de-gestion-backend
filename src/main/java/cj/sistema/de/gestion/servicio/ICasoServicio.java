package cj.sistema.de.gestion.servicio;

import cj.sistema.de.gestion.modelo.Caso;
import java.util.List;

public interface ICasoServicio {
    public List<Caso> listarCasos();

    public Caso buscarCasoPorId(Integer idCaso);

    public Caso guardarCaso(Caso caso);

    public void eliminarCasoPorId(Integer idCaso);
}
