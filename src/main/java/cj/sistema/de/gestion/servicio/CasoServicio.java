package cj.sistema.de.gestion.servicio;

import cj.sistema.de.gestion.modelo.Caso;
import cj.sistema.de.gestion.repositorio.CasoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CasoServicio implements ICasoServicio{

    @Autowired
    private CasoRepositorio casoRepositorio;

    @Override
    public List<Caso> listarCasos() {
        return this.casoRepositorio.findAll();
    }

    @Override
    public Caso buscarCasoPorId(Integer idCaso) {
        Caso caso =
                this.casoRepositorio.findById(idCaso).orElse(null);
        return caso;
    }

    @Override
    public Caso guardarCaso(Caso caso) {
        return this.casoRepositorio.save(caso);
    }

    @Override
    public void eliminarCasoPorId(Integer idCaso) {
        this.casoRepositorio.deleteById(idCaso);
    }
}

