package es.ujaen.ssmmaa;

import es.ujaen.ssmmaa.Vocabulario.TipoAgente;

public class Pago {
    private final int pagoEspia;
    private final int pagoSeguridad;

    public Pago(int pagoEspia, int pagoSeguridad) {
        this.pagoEspia = pagoEspia;
        this.pagoSeguridad = pagoSeguridad;
    }

    public int getPago(TipoAgente tipo) {
        return switch (tipo) {
            case ESPIA -> pagoEspia;
            case SEGURIDAD -> pagoSeguridad;
            default -> throw new IllegalStateException("No hay pago definido para: " + tipo);
        };
    }

    @Override
    public String toString() {
        return "("+pagoEspia+","+pagoSeguridad+")";
    }
}
