package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.Incidencia;
import jade.content.onto.annotations.Slot;

public class IncidenciaJuego extends SubInform {
    private String idJuego;
    private Incidencia detalle;

    public IncidenciaJuego() {
    }

    public IncidenciaJuego(String idJuego, Incidencia detalle) {
        this.idJuego = idJuego;
        this.detalle = detalle;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory = true)
    public Incidencia getDetalle() {
        return detalle;
    }

    public void setDetalle(Incidencia detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "IncidenciaJuego{" +
                "idJuego='" + idJuego + '\'' +
                ", detalle=" + detalle +
                '}';
    }
}
