package es.ujaen.ssmmaa.elementos;

import jade.content.Predicate;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class AsignacionEstrategias implements Predicate {
    private String idPartida;
    private List listaAsignacion;

    public AsignacionEstrategias() {
    }

    public AsignacionEstrategias(String idPartida, List listaAsignacion) {
        this.idPartida = idPartida;
        this.listaAsignacion = listaAsignacion;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @AggregateSlot(cardMin = 1, type = Asignacion.class)
    public List getListaAsignacion() {
        return listaAsignacion;
    }

    public void setListaAsignacion(List listaAsignacion) {
        this.listaAsignacion = listaAsignacion;
    }

    @Override
    public String toString() {
        return "AsignacionEstrategias{" +
                "idPartida='" + idPartida + '\'' +
                ", listaAsignacion=" + listaAsignacion +
                '}';
    }
}
