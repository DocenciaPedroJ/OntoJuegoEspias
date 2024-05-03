package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.Objetivo;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

public class OperacionExploracion implements Concept {
    private int numZona;
    private Objetivo objetivo;

    public OperacionExploracion() {
    }

    public OperacionExploracion(int numZona, Objetivo objetivo) {
        this.numZona = numZona;
        this.objetivo = objetivo;
    }

    @Slot(mandatory = true)
    public int getNumZona() {
        return numZona;
    }

    public void setNumZona(int numZona) {
        this.numZona = numZona;
    }

    @Slot(mandatory = true)
    public Objetivo getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "OperacionExploracion{" +
                "numZona=" + numZona +
                ", objetivo=" + objetivo +
                '}';
    }
}
