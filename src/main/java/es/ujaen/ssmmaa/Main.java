package es.ujaen.ssmmaa;

import es.ujaen.ssmmaa.elementos.Agente;
import es.ujaen.ssmmaa.elementos.AgenteOrganizador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static es.ujaen.ssmmaa.Vocabulario.*;
import static es.ujaen.ssmmaa.Vocabulario.EstrategiaEspia.EO;
import static es.ujaen.ssmmaa.Vocabulario.EstrategiaSeguridad.DI;
import static es.ujaen.ssmmaa.Vocabulario.EstrategiaSeguridad.IC;

public class Main {
    public static void main(String[] args) {
        List<String> presentacion = new ArrayList<>();

        System.out.println("Estrategias Espia " + Arrays.toString(EstrategiaEspia.values()));
        System.out.println("Estrategias Espia " + Arrays.toString(EstrategiaSeguridad.values()));

        for (EstrategiaEspia espia : EstrategiaEspia.values()) {
            String linea = "\n";
            for (Vocabulario.EstrategiaSeguridad seguridad : EstrategiaSeguridad.values()) {
                Pago pago = obtenerPago.apply(espia, seguridad);
                linea += "["+ espia + "," + seguridad + "] = " + pago + " ";
            }

            presentacion.add(linea);
        }

        for (int i = 0; i < matrizPagos.length; i++) {
            System.out.println(Arrays.toString(matrizPagos[i]));
        }

        System.out.println("["+EO.ordinal()+","+IC.ordinal()+"] = " + obtenerPago.apply(EO,IC));
        System.out.println("["+EO.ordinal()+","+IC.ordinal()+"] = " + matrizPagos[0][1]);

        System.out.println(presentacion);
    }
}