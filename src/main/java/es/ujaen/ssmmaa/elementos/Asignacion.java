package es.ujaen.ssmmaa.elementos;

import jade.content.Concept;

public class Asignacion implements Concept {
    private int zona;
    private Estrategia estrategia;

    public Asignacion() {
    }

    public Asignacion(int zona, Estrategia estrategia) {
        this.zona = zona;
        this.estrategia = estrategia;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    @Override
    public String toString() {
        return "Asignacion{" +
                "zona=" + zona +
                ", estrategia=" + estrategia +
                '}';
    }
}
