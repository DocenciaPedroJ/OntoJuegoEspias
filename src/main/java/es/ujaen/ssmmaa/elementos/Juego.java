package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.ModoJuego;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

public class Juego implements Concept {
    private String idJuego;
    private ModoJuego modo;

    public Juego() {
    }

    public Juego(String idJuego, ModoJuego modo) {
        this.idJuego = idJuego;
        this.modo = modo;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory = true)
    public ModoJuego getModo() {
        return modo;
    }

    public void setModo(ModoJuego modo) {
        this.modo = modo;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "idJuego='" + idJuego + '\'' +
                ", modo=" + modo +
                '}';
    }
}
