package es.ujaen.ssmmaa;

import java.util.Random;

public interface Vocabulario {
    Random aleatorio = new Random();

    enum TipoAgente { ESPIA, SEGURIDAD, TABLERO}

    enum EstrategiaEspia {
        EO("Evaluar Objativos",2), PI("Planificar Infiltración",3), EE("Ejecutar Espionaje",4),
        EI("Extraer Información",5), DE("Desinformación",3);

        private String nombre;
        private int puntosAccion;

        EstrategiaEspia(String nombre, int puntosAccion) {
            this.nombre = nombre;
            this.puntosAccion = puntosAccion;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPuntosAccion() {
            return puntosAccion;
        }
    }

    enum EstrategiaSeguridad {
        DI("Detectar Infiltración",2), IC("Interceptar Comunicaciones",3), NE("Neutralizar Espías",4),
        FD("FortalecerDefensas",3), CI("Contrainteligencia",5);

        private String nombre;
        private int puntosAccion;

        EstrategiaSeguridad(String nombre, int puntosAccion) {
            this.nombre = nombre;
            this.puntosAccion = puntosAccion;
        }

        public String getNombre() {
            return nombre;
        }

        public int getPuntosAccion() {
            return puntosAccion;
        }
    }

    enum Objetivo{
        BAJA_PRIORIDAD(20,1), PRIORIDAD_NORMAL(60,2), ALTA_PRIORIDAD(15,3), MAXIMA_PRIORIAD(5,5);

        int peso;
        int valor;

        Objetivo(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        /**
         * Genera un objetivo aleatorio atendiendo a su peso específico
         * @return el tipo de objetivo
         */
        static public Objetivo getObjetivo() {
            Objetivo resultado = null;
            int tiradaDado = aleatorio.nextInt(D100);
            int suma = 0;
            int indice = 0;

            Objetivo[] posiblesObjetivos = Objetivo.values();

            while ( (indice < posiblesObjetivos.length) && (resultado == null)) {
                suma += posiblesObjetivos[indice].peso;

                if ( suma > tiradaDado )
                    resultado = posiblesObjetivos[indice];

                indice++;
            }


            return resultado;
        }
    }

    Pago[][] matrizPagos = {
            {new Pago(1,-1), new Pago(0,0), new Pago(-1,1), new Pago(2,-2), new Pago(1,-1)},
            {new Pago(0,0), new Pago(1,-1), new Pago(-2,2), new Pago(1,-1), new Pago(0,0)},
            {new Pago(-2,2), new Pago(2,-2), new Pago(0,0), new Pago(-1,1), new Pago(-1,1)},
            {new Pago(-1,1), new Pago(3,-3), new Pago(-3,3), new Pago(0,0), new Pago(2,-2)},
            {new Pago(2,-2), new Pago(-1,1), new Pago(1,-1), new Pago(2,-2), new Pago(-2,2)}
    };

    int MAX_PAGO = 3;
    int PUNTOS_ACCION = 30;
    int BONUS = 10; // 10% de aumento en la puntuación por una zona sin disputa
    int D100 = 100; // Dado de 100 caras
    int NUM_ZONAS = 9;
    String TipoServicio = "JUGADOR";

}
