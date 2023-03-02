package edu.eci.ieti.proyecto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservas")
public class Reserva {
    @Id
    private String id;
    private String idUsuario;
    private String idEspacio;
    private String fechaInicio;
    private String fechaFin;
    private String estado;

    public Reserva(String id, String idUsuario, String idEspacio, String fechaInicio, String fechaFin, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idEspacio = idEspacio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdEspacio() {
        return this.idEspacio;
    }

    public void setIdEspacio(String idEspacio) {
        this.idEspacio = idEspacio;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", idUsuario='" + getIdUsuario() + "'" +
                ", idEspacio='" + getIdEspacio() + "'" +
                ", fechaInicio='" + getFechaInicio() + "'" +
                ", fechaFin='" + getFechaFin() + "'" +
                ", estado='" + getEstado() + "'" +
                "}";
    }

}
