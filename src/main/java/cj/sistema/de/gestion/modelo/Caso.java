package cj.sistema.de.gestion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Caso {

    @Id


    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer idCaso;
    private Integer idUsuario;
    private String tipo;
    private String descripcion;
    private String estado;
    private LocalDate fechaCreacion;
    private String estudianteAsignado;


    public Integer getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstudianteAsignado() {
        return estudianteAsignado;
    }

    public void setEstudianteAsignado(String estudianteAsignado) {
        this.estudianteAsignado = estudianteAsignado;
    }
}