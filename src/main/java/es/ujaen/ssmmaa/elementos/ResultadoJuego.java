package es.ujaen.ssmmaa.elementos;

import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class ResultadoJuego extends SubInform {
    private String idJuego;
    private List listaJugadores;
    private List puntosJugadores;

    public ResultadoJuego() {
    }

    public ResultadoJuego(String idJuego, List listaJugadores, List puntosJugadores) {
        this.idJuego = idJuego;
        this.listaJugadores = listaJugadores;
        this.puntosJugadores = puntosJugadores;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @AggregateSlot(cardMin=2, type=AgenteJugador.class)
    public List getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @AggregateSlot(cardMin=2, type=Integer.class)
    public List getPuntosJugadores() {
        return puntosJugadores;
    }

    public void setPuntosJugadores(List puntosJugadores) {
        this.puntosJugadores = puntosJugadores;
    }

    @Override
    public String toString() {
        return "ResultadoJuego{" +
                "idJuego='" + idJuego + '\'' +
                ", listaJugadores=" + listaJugadores +
                ", puntosJugadores=" + puntosJugadores +
                '}';
    }
}
