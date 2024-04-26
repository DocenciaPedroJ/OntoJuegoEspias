package es.ujaen.ssmmaa.elementos;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class Exploracion implements Predicate {
    private String idPartida;
    private int puntosAccion;
    private int numZona;

    public Exploracion() {
    }

    public Exploracion(String idPartida, int puntosAccion, int numZona) {
        this.idPartida = idPartida;
        this.puntosAccion = puntosAccion;
        this.numZona = numZona;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @Slot(mandatory = true)
    public int getPuntosAccion() {
        return puntosAccion;
    }

    public void setPuntosAccion(int puntosAccion) {
        this.puntosAccion = puntosAccion;
    }

    @Slot(mandatory = true)
    public int getNumZona() {
        return numZona;
    }

    public void setNumZona(int numZona) {
        this.numZona = numZona;
    }

    @Override
    public String toString() {
        return "Exploracion{" +
                "idPartida='" + idPartida + '\'' +
                ", puntosAccion=" + puntosAccion +
                ", numZona=" + numZona +
                '}';
    }
}
