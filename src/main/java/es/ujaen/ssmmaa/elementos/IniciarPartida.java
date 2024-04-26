package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class IniciarPartida implements AgentAction {
    private Partida partida;

    public IniciarPartida() {
    }

    public IniciarPartida(Partida partida) {
        this.partida = partida;
    }

    @Slot(mandatory = true)
    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    @Override
    public String toString() {
        return "IniciarPartida{" +
                "partida=" + partida +
                '}';
    }
}
