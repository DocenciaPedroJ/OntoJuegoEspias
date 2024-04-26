package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.EstadoPartida;
import jade.content.Predicate;

public class AccionPartida implements Predicate {
    private String idPartida;
    private EstadoPartida accion;

    public AccionPartida() {
    }


    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public EstadoPartida getAccion() {
        return accion;
    }

    public void setAccion(EstadoPartida accion) {
        this.accion = accion;
    }
}
