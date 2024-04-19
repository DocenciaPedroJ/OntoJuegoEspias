package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class SolicitarAsignacion implements AgentAction {
    private String idPartida;

    public SolicitarAsignacion() {
    }

    public SolicitarAsignacion(String idPartida) {
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
        return "SolicitarAsignacion{" +
                "idPartida='" + idPartida + '\'' +
                '}';
    }
}
