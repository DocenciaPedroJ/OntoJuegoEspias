package es.ujaen.ssmmaa.elementos;

import jade.content.Predicate;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class RealizadaAsignacion implements Predicate {
    private String idPartida;
    private List asignacion;

    public RealizadaAsignacion() {
    }

    public RealizadaAsignacion(String idPartida, List asignacion) {
        this.idPartida = idPartida;
        this.asignacion = asignacion;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @AggregateSlot(type = Asignacion.class, cardMin = 1, cardMax = 9)
    public List getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(List asignacion) {
        this.asignacion = asignacion;
    }

    @Override
    public String toString() {
        return "RealizadaAsignacion{" +
                "idPartida='" + idPartida + '\'' +
                ", asignacion=" + asignacion +
                '}';
    }
}
