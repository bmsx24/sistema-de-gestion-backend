package cj.sistema.de.gestion.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CasoNoEncontradoException extends RuntimeException {
    public CasoNoEncontradoException(String message) {
        super(message);
    }
}
