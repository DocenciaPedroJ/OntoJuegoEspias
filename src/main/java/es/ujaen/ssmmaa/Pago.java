package es.ujaen.ssmmaa;

import es.ujaen.ssmmaa.Vocabulario.TipoAgente;

public class Pago {
    private int pagoEspia;
    private int pagoSeguridad;

    public Pago(int pagoEspia, int pagoSeguridad) {
        this.pagoEspia = pagoEspia;
        this.pagoSeguridad = pagoSeguridad;
    }

    public int getPago(TipoAgente tipo) {
        int pago;
        
        switch ( tipo ) {
            case ESPIA:
                pago = pagoEspia;
                break;
            case SEGURIDAD:
                pago = pagoSeguridad;
                break;
            default:
                throw new IllegalStateException("No hay pago definido para: " + tipo);
        }

        return pago;
    }

    @Override
    public String toString() {
        return "("+pagoEspia+","+pagoSeguridad+")";
    }
}
