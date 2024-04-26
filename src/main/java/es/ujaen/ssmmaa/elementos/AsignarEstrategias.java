package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class AsignarEstrategias implements AgentAction {
    private String idPartida;

    public AsignarEstrategias(String idPartida) {
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
        return "AsignarEstrategias{" +
                "idPartida='" + idPartida + '\'' +
                '}';
    }
}
