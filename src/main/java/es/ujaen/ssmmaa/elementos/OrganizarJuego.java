package es.ujaen.ssmmaa.elementos;

import jade.content.AgentAction;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class OrganizarJuego implements AgentAction {
    private Juego juego;
    private InfoPartida configuracion;
    private List listaJugadores;

    public OrganizarJuego() {
    }

    public OrganizarJuego(Juego juego, InfoPartida configuracion, List listaJugadores) {
        this.juego = juego;
        this.configuracion = configuracion;
        this.listaJugadores = listaJugadores;
    }

    @Slot(mandatory = true)
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Slot(mandatory = true)
    public InfoPartida getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(InfoPartida configuracion) {
        this.configuracion = configuracion;
    }

    @AggregateSlot(cardMin = 2, type = AgenteJugador.class)
    public List getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @Override
    public String toString() {
        return "OrganizarJuego{" +
                "juego=" + juego +
                ", configuracion=" + configuracion +
                ", listaJugadores=" + listaJugadores +
                '}';
    }
}
