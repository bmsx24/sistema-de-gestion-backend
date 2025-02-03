package cj.sistema.de.gestion.repositorio;

import cj.sistema.de.gestion.modelo.Caso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasoRepositorio extends JpaRepository<Caso, Integer> {
}
