package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.TipoAgenteJugador;
import jade.content.onto.annotations.Slot;
import jade.core.AID;

public class AgenteJugador extends Agente {
    private TipoAgenteJugador tipoJugador;

    public AgenteJugador() {
    }

    public AgenteJugador(String apodo, AID agentePlataforma, TipoAgenteJugador tipoJugador) {
        super(apodo, agentePlataforma);
        this.tipoJugador = tipoJugador;
    }

    @Slot(mandatory = true)
    public TipoAgenteJugador getTipoJugador() {
        return tipoJugador;
    }

    public void setTipoJugador(TipoAgenteJugador tipoJugador) {
        this.tipoJugador = tipoJugador;
    }

    @Override
    public String toString() {
        return "AgenteJugador{" +
                "\n\t Apodo " + getApodo() +
                "\n\t Tipo jugador " + getTipoJugador() +
                "\n\t AID " + getAgentePlataforma() + "\n}";
    }
}
