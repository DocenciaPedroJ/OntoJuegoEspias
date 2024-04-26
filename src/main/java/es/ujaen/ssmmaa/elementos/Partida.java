package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario;
import jade.content.Concept;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Slot;
import jade.util.leap.List;

public class Partida implements Concept {
    private String idPartida;
    private String idJuego;
    private InfoPartida configuracion;
    private List numObjetivos;

    public Partida() {
    }

    public Partida(String idPartida, String idJuego, InfoPartida configuracion, List numObjetivos) {
        this.idPartida = idPartida;
        this.idJuego = idJuego;
        this.configuracion = configuracion;
        this.numObjetivos = numObjetivos;
    }

    @Slot(mandatory = true)
    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory = true)
    public InfoPartida getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(InfoPartida configuracion) {
        this.configuracion = configuracion;
    }

    @AggregateSlot(cardMin = 4, cardMax = 4, type = Integer.class)
    public List getNumObjetivos() {
        return numObjetivos;
    }

    public void setNumObjetivos(List numObjetivos) {
        this.numObjetivos = numObjetivos;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "idPartida='" + idPartida + '\'' +
                ", idJuego='" + idJuego + '\'' +
                ", configuracion=" + configuracion +
                ", numObjetivos=" + numObjetivos +
                '}';
    }
}
