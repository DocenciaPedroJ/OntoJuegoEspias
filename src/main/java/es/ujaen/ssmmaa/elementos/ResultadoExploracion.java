package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.Objetivo;
import jade.content.Predicate;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class ResultadoExploracion implements Predicate {
    private String idPartida;
    private int numZona;
    private List resultado;

    public ResultadoExploracion() {
    }

    public ResultadoExploracion(String idPartida, int numZona, List resultado) {
        this.idPartida = idPartida;
        this.numZona = numZona;
        this.resultado = resultado;
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

    @AggregateSlot(cardMin = 2, cardMax = 2, type = Objetivo.class)
    public List getResultado() {
        return resultado;
    }

    public void setResultado(List resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ResultadoExploracion{" +
                "idPartida='" + idPartida + '\'' +
                ", numZona=" + numZona +
                ", resultado=" + resultado +
                '}';
    }
}
