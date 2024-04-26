package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.TipoAgenteJugador;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

public class Estrategia implements Concept {
    private String estrategia;
    private TipoAgenteJugador jugador;

    public Estrategia() {
    }

    public Estrategia(String estrategia, TipoAgenteJugador jugador) {
        this.estrategia = estrategia;
        this.jugador = jugador;
    }

    @Slot(mandatory = true)
    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    @Slot(mandatory = true)
    public TipoAgenteJugador getJugador() {
        return jugador;
    }

    public void setJugador(TipoAgenteJugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public String toString() {
        return "Estrategia{" +
                "estrategia='" + estrategia + '\'' +
                ", jugador=" + jugador +
                '}';
    }
}
