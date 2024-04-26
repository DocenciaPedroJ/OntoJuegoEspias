package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.TipoAgenteOrganizador;
import jade.content.onto.annotations.Slot;
import jade.core.AID;

public class AgenteOrganizador extends Agente {
    private TipoAgenteOrganizador tipoOrganizador;

    public AgenteOrganizador() {
    }

    public AgenteOrganizador(String apodo, AID agentePlataforma, TipoAgenteOrganizador tipoOrganizador) {
        super(apodo, agentePlataforma);
        this.tipoOrganizador = tipoOrganizador;
    }

    @Slot(mandatory = true)
    public TipoAgenteOrganizador getTipoOrganizador() {
        return tipoOrganizador;
    }

    public void setTipoOrganizador(TipoAgenteOrganizador tipoOrganizador) {
        this.tipoOrganizador = tipoOrganizador;
    }

    @Override
    public String toString() {
        return "AgenteOrganizador{" +
                "\n\t Apodo " + getApodo() +
                "\n\t Tipo organizador " + getTipoOrganizador() +
                "\n\t AID " + getAgentePlataforma() + "\n}";
    }
}
