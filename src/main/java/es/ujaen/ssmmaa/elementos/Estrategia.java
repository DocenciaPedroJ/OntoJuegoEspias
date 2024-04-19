package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.TipoAgente;
import jade.content.Concept;
import jade.content.onto.annotations.Slot;

public class Estrategia implements Concept {
    private String estrategia;
    private TipoAgente tipoAgente;

    public Estrategia() {
    }

    public Estrategia(String estrategia, TipoAgente tipoAgente) {
        this.estrategia = estrategia;
        this.tipoAgente = tipoAgente;
    }

    @Slot(mandatory = true)
    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    @Slot(mandatory = true)
    public TipoAgente getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(TipoAgente tipoAgente) {
        this.tipoAgente = tipoAgente;
    }

    @Override
    public String toString() {
        return "Estrategia{" +
                "nombre='" + estrategia + '\'' +
                ", tipoAgente=" + tipoAgente +
                '}';
    }
}
