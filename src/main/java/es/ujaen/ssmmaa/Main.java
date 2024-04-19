package es.ujaen.ssmmaa;

import java.util.Arrays;

import static es.ujaen.ssmmaa.Vocabulario.*;

public class Main {
    public static void main(String[] args) {
        for (Pago[] matrizPago : matrizPagos)
            System.out.println(Arrays.toString(matrizPago));

        for (int i = 0; i < NUM_ZONAS; i++) {
            System.out.println("Objetivo para la zona " + (i+1) + " es: " + Objetivo.getObjetivo());
        }
    }
}