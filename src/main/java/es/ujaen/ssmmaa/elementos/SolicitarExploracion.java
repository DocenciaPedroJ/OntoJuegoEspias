package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class SolicitarExploracion implements AgentAction {
    private String idPartida;

    public SolicitarExploracion() {
    }

    public SolicitarExploracion(String idPartida) {
        this.idPartida = idPartida;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @Override
    public String toString() {
        return "SolicitarExploracion{" +
                "idPartida='" + idPartida + '\'' +
                '}';
    }
}
