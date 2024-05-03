package es.ujaen.ssmmaa.elementos;

import jade.content.Predicate;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class ResultadoExploracion implements Predicate {
    private String idPartida;
    private List operacionExploracion;

    public ResultadoExploracion() {
    }

    public ResultadoExploracion(String idPartida, List operacionExploracion) {
        this.idPartida = idPartida;
        this.operacionExploracion = operacionExploracion;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @AggregateSlot(cardMin = 2, cardMax = 2, type = OperacionExploracion.class)
    public List getOperacionExploracion() {
        return operacionExploracion;
    }

    public void setOperacionExploracion(List operacionExploracion) {
        this.operacionExploracion = operacionExploracion;
    }

    @Override
    public String toString() {
        return "ResultadoExploracion{" +
                "idPartida='" + idPartida + '\'' +
                ", operacionExploracion=" + operacionExploracion +
                '}';
    }
}
