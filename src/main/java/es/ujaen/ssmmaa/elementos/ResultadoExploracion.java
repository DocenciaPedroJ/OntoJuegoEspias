package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.Objetivo;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class ResultadoExploracion implements Predicate {
    private String idPartida;
    private int numZona;
    private Objetivo objetivo;

    public ResultadoExploracion() {
    }

    public ResultadoExploracion(String idPartida, int numZona, Objetivo objetivo) {
        this.idPartida = idPartida;
        this.numZona = numZona;
        this.objetivo = objetivo;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
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
        return "ResultadoExploracion{" +
                "idPartida='" + idPartida + '\'' +
                ", numZona=" + numZona +
                ", objetivo=" + objetivo +
                '}';
    }
}
