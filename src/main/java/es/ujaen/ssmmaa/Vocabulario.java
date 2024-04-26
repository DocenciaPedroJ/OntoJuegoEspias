package es.ujaen.ssmmaa;

import java.util.Random;
import java.util.function.BiFunction;

public interface Vocabulario {
    Random aleatorio = new Random();

    enum TipoAgenteJugador { ESPIA, SEGURIDAD }
    enum TipoAgenteOrganizador { TABLERO, ORGANIZADOR, MONITOR }
    enum EstadoPartida {INICIO, ABANDONAR, SEGUIR_JUGANDO, FIN_EXPLORACION}

    enum Motivacion {
        JUEGOS_ACTIVOS_SUPERADOS, TIPO_JUEGO_DESCONOCIDO, ONTOLOGIA_DESCONOCIDA,
        SUBSCRIPCION_ACEPTADA, FINALIZACION_AGENTE
    }
    enum TipoIncidencia{JUEGO_NO_INICIADO, RESULTADO_JUEGO}
    enum Incidencia {
        CANCELADO, JUGADORES_INSUFICIENTES,
        ERROR_AGENTE, MENSAJE_INCORRECTO, ERROR_CONTENIDO_MENSAJE
    }

    enum ModoJuego {
        INDIVIDUAL(2,2), EQUIPO(6,12),
        TORNEO(6,12);

        private int minJugadores;
        private int maxJugadores;

        ModoJuego(int minJugadores, int maxJugadores) {
            this.minJugadores = minJugadores;
            this.maxJugadores = maxJugadores;
        }

        public int getMinJugadores() {
            return minJugadores;
        }

        public int getMaxJugadores() {
            return maxJugadores;
        }
    }

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
        BAJA_PRIORIDAD(20,1), PRIORIDAD_NORMAL(60,2),
        ALTA_PRIORIDAD(15,3), MAXIMA_PRIORIAD(5,5),
        DESCONOCIDO(0,0);

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

    /**
     * Matriz con los pagos según la estrategia seleccionada por el jugador espía y
     * el jugador de seguridad.
     */
    Pago[][] matrizPagos = {
            {new Pago(1,-1), new Pago(0,0), new Pago(-1,1), new Pago(2,-2), new Pago(1,-1)},
            {new Pago(0,0), new Pago(1,-1), new Pago(-2,2), new Pago(1,-1), new Pago(0,0)},
            {new Pago(-2,2), new Pago(2,-2), new Pago(0,0), new Pago(-1,1), new Pago(-1,1)},
            {new Pago(-1,1), new Pago(3,-3), new Pago(-3,3), new Pago(0,0), new Pago(2,-2)},
            {new Pago(2,-2), new Pago(-1,1), new Pago(1,-1), new Pago(2,-2), new Pago(-2,2)}
    };

    /**
     * Dada una estrategia para el jugador espía y otra para el jugador de seguridad se
     * obtiene el pago correspondiente.
     */
    BiFunction<EstrategiaEspia,EstrategiaSeguridad,Pago> obtenerPago =
            (estrategiaEspia, estrategiaSeguridad) -> matrizPagos[estrategiaEspia.ordinal()][estrategiaSeguridad.ordinal()];

    int MAX_PAGO = 3;
    int PUNTOS_ACCION = 30;
    int BONUS = 10; // 10% de aumento en la puntuación por una zona sin disputa
    int D100 = 100; // Dado de 100 caras
    int NUM_ZONAS = 9;
    int MIN_PARTIDAS = 3; // mínimo de partidas que se deben jugar concurrentemente
    String NOMBRE_SERVICIO = "Juego Espías";
}
