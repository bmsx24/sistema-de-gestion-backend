package cj.sistema.de.gestion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Comentario {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idComentario;
    private Integer idCaso;
    private Integer idUsuario;
    private String contenido;
    private LocalDateTime fecha;


    public Integer getidComentario() {
        return idComentario;
    }

    public void setidComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }
    public Integer getidCaso() {
        return idCaso;
    }

    public void setidCaso(Integer idCaso) {
        this.idCaso = idCaso;
    }

    public Integer getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}