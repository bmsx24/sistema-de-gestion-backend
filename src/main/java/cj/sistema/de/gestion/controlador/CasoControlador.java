package cj.sistema.de.gestion.controlador;

import cj.sistema.de.gestion.excepcion.CasoNoEncontradoException;
import cj.sistema.de.gestion.modelo.Caso;
import cj.sistema.de.gestion.servicio.CasoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/sistema_de_gestion_app
@RequestMapping("sistema-de-gestion-app")
@CrossOrigin(value = "http://localhost:4200" )

public class CasoControlador {

    private static final Logger logger=
            LoggerFactory.getLogger(CasoControlador.class);

    @Autowired
    private CasoServicio casoServicio;

    //http://localhost:8080/sistema_de_gestion_app/casos
    @GetMapping("/casos")
    public List<Caso> obtenerCasos(){
        List<Caso> casos = this.casoServicio.listarCasos();
        logger.info("Casos obtenidos:");
        casos.forEach((caso -> logger.info(caso.toString())));
        return casos;
    }

    @PostMapping("/casos")
    public Caso agregarCaso(@RequestBody Caso caso){
        logger.info("Caso a registrar: "+ caso);
        return this.casoServicio.guardarCaso(caso);

    }

    @GetMapping("/casos/{id}")
    public ResponseEntity<Caso> obtenerCasoPorID(
            @PathVariable int id) {
        Caso caso =
                this.casoServicio.buscarCasoPorId(id);
        if(caso !=null)
            return ResponseEntity.ok(caso);
        else
            throw new CasoNoEncontradoException("No se encontro el id:" + id);
    }

    @PutMapping("/casos/{id}")
    public ResponseEntity<Caso> actualizarCaso(
            @PathVariable int id,
            @RequestBody Caso casoRecibido){
        Caso caso = this.casoServicio.buscarCasoPorId(id);
        if(caso == null)
            throw new CasoNoEncontradoException("No se encontro el id: " + id);
        caso.setDescripcion(casoRecibido.getDescripcion());
        caso.setTipo(casoRecibido.getTipo());
        caso.setEstado(casoRecibido.getEstado());
        caso.setEstudianteAsignado(casoRecibido.getEstudianteAsignado());
        this.casoServicio.guardarCaso(caso);
        return ResponseEntity.ok(caso);
    }

    @DeleteMapping("/casos/{id}")
    public ResponseEntity<Map<String, Boolean>>
    eliminarCaso(@PathVariable int id){
        Caso caso = casoServicio.buscarCasoPorId(id);
        if(caso == null)
            throw new CasoNoEncontradoException("No se encontro el id: " + id);
        this.casoServicio.eliminarCasoPorId(caso.getIdCaso());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);

    }


}
