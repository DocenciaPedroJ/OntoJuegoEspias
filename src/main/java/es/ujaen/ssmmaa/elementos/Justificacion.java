package es.ujaen.ssmmaa.elementos;

import es.ujaen.ssmmaa.Vocabulario.Motivacion;
import jade.content.Predicate;
import jade.content.onto.annotations.Slot;

public class Justificacion implements Predicate {
    private String idJuego;
    private Motivacion motivacion;

    public Justificacion() {
    }

    public Justificacion(String idJuego, Motivacion motivacion) {
        this.idJuego = idJuego;
        this.motivacion = motivacion;
    }

    @Slot(mandatory = true)
    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Slot(mandatory = true)
    public Motivacion getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(Motivacion motivacion) {
        this.motivacion = motivacion;
    }
}
