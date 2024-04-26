package es.ujaen.ssmmaa.elementos;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;

import static es.ujaen.ssmmaa.Vocabulario.NUM_ZONAS;
import static es.ujaen.ssmmaa.Vocabulario.PUNTOS_ACCION;

public class InfoPartida implements Concept {
    private int puntosAccion;
    private int numZonas;

    public InfoPartida() {
        this.puntosAccion = PUNTOS_ACCION;
        this.numZonas = NUM_ZONAS;
    }

    public InfoPartida(int puntosAccion, int numZonas) {
        this.puntosAccion = puntosAccion;
        this.numZonas = numZonas;
    }

    @Slot(mandatory = true)
    public int getPuntosAccion() {
        return puntosAccion;
    }

    public void setPuntosAccion(int puntosAccion) {
        this.puntosAccion = puntosAccion;
    }

    @Slot(mandatory = true)
    public int getNumZonas() {
        return numZonas;
    }

    public void setNumZonas(int numZonas) {
        this.numZonas = numZonas;
    }

    @Override
    public String toString() {
        return "InfoPartida{" +
                "puntosAccion=" + puntosAccion +
                ", numZonas=" + numZonas +
                '}';
    }
}
