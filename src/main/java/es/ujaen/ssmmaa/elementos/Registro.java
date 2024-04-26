package es.ujaen.ssmmaa.elementos;

import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class Registro implements Predicate {
    private String idJuego;
    private Agente agenteJuego;

    public Registro() {
    }

    public Registro(String idJuego, Agente agenteJuego) {
        this.idJuego = idJuego;
        this.agenteJuego = agenteJuego;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory = true)
    public Agente getAgenteJuego() {
        return agenteJuego;
    }

    public void setAgenteJuego(Agente agenteJuego) {
        this.agenteJuego = agenteJuego;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "idJuego='" + idJuego + '\'' +
                ", agenteJueg=" + agenteJuego +
                '}';
    }
}
