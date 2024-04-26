package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class ProponerJuego implements AgentAction {
    private Juego juego;

    public ProponerJuego() {
    }

    public ProponerJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory = true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    public String toString() {
        return "ProponerJuego{" +
                "juego=" + juego +
                '}';
    }
}
