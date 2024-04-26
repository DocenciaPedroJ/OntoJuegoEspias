package es.ujaen.ssmmaa;

import es.ujaen.ssmmaa.Vocabulario.TipoAgenteJugador;

public class Pago {
    private final int pagoEspia;
    private final int pagoSeguridad;

    public Pago(int pagoEspia, int pagoSeguridad) {
        this.pagoEspia = pagoEspia;
        this.pagoSeguridad = pagoSeguridad;
    }

    public int getPago(TipoAgenteJugador jugador) {
        return switch (jugador) {
            case ESPIA -> pagoEspia;
            case SEGURIDAD -> pagoSeguridad;
            default -> throw new IllegalStateException("No hay pago definido para: " + jugador);
        };
    }

    @Override
    public String toString() {
        return "("+pagoEspia+","+pagoSeguridad+")";
    }
}
