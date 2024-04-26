package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.TipoIncidencia;
import jade.content.AgentAction;
import jade.content.onto.annotations.Slot;

public class RegistrarIncidencia implements AgentAction {
    private TipoIncidencia tipoIncidencia;

    public RegistrarIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    @Slot(mandatory = true)
    public TipoIncidencia getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    @Override
    public String toString() {
        return "RegistrarIncidencia{" +
                "tipoIncidencia=" + tipoIncidencia +
                '}';
    }
}
