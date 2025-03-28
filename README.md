# Juego de Espías
## Contexto del Juego [![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0) [![](https://jitpack.io/v/DocenciaPedroJ/OntoJuegoEspias.svg)](https://jitpack.io/#DocenciaPedroJ/OntoJuegoEspias)
Dos potencias enfrentadas, cada una buscando expandir su influencia mientras limita la del otro. Los jugadores representan las agencias de inteligencia de estas potencias, dedicadas al espionaje para ganar ventaja estratégica y al contraespionaje para proteger sus propios secretos.

### Objetivos

-   Ganar puntos de influencia realizando exitosas operaciones de espionaje.
-   Prevenir la pérdida de puntos protegiendo la información propia de ser espiada por el adversario.

### Mecánicas Básicas

-   **Operaciones de Espionaje:**  Los agentes pueden intentar infiltrarse en el “territorio” del otro para robar información, cada operación exitosa gana puntos.
-   **Operaciones de Contraespionaje:**  Los agentes pueden proteger su territorio detectando y deteniendo espías, cada operación exitosa previene la pérdida de puntos y posiblemente gane puntos al capturar un espía.
-   **Recursos Limitados:**  Ambos jugadores deben gestionar cuidadosamente sus recursos (agentes, tecnología, información), ya que cada acción consume recursos.

### Normas para el Juego

-   Los agentes que formarán parte del juego son los siguientes:
	- **Agente** : Concepto abstracto que representa a los agentes en el juego.
		- **AgenteJugador**
    		- _AgenteEspia_. Es uno de los dos tipos de jugadores que formarán parte de la partida.
    		- _AgenteSeguridad_. Es el otro tipo de jugador y que será el oponente del agente espía.
		- **AgenteOrganizador**
			- _AgenteMonitor_. Es el encargado de crear todos los agentes que comprondrán el juego y tendrá a su cargo la organización de un número de juegos.
			- _AgenteOrganizador_. Es el encargado de crear las partidas para los juegos asociados según la disponibilidad de jugadores para cada juego.
    		- _AgenteTablero_. Es el encargado de controlar el desarrollo de una partida con los dos jugadores asignados.
-   El tablero de juego será una cuadrícula 3x3 que definen un total de 9 zonas donde se ubicarán los objetivos por los que competirán los agentes de la partida:
    -   Los tipos de objetivos serán: BajaPrioridad(20%), PrioridadNormal(60%), AltaPrioridad(15%), MaximaPrioridad(5%). Los puntos asociados serán de 1, 2, 3, 5 puntos cada uno de los tipos.
    -   El calculo de puntos para una zona en el juego corresponde a los puntos obtenidos de la tabla de pagos para la estrategias enfrentadas que los agentes han asignado a esa zona multiplicado por los puntos del objetivo. Si el objetivo no está en disputa por uno de los agentes el ganador obtiene un bono del 10% suponiendo que ha aplicado la estrategia más favorable, según la tabla de pagos.
    -   Las zonas se numerarán de izquierda a derecha y de arriba a abajo en el tablero de juego.
-   Modos de juego. Hay dos modos de juego:
    -   1 vs 1 donde un agente de cada tipo compite por los los puntos de un tablero y gana el que mas puntos consigue en el juego según la asignación de estrategias disponibles.
    -   Equipo vs Equipo. Se forma dos equipos de entre 3 a 6 agentes de cada tipo de entre los disponibles en el sistema. La partida corresponde a enfrentamientos 1 vs 1 entre cada uno de los componentes del equipo. La suma de los puntos obtenidos por cada miembro del equipo conforma la puntuación total del equipo. El que obtiene más puntos es el ganador.
-   Los agentes jugadores deben aplicar correctamente las normas del juego. El AgenteTablero solo debe comprobar que se solicitan correctamente zonas del tablero no que los jugadores cumplen las normas.

### Desarrollo de una partida

1.  Se buscan los agentes que formarán parte de la partida.
2.  Una vez que ya hay un agente de cada tipo dispuesto a jugar se generan los objetivos de forma secreta por parte del AgenteTablero y comunica a los participantes la cantidad de cada tipo de objetivo presente en el tablero. Los dos jugadores dispondrán de una cantidad de puntos de acción para realizar movimientos en el juego. Esta cantidad de puntos de acción será una constante presente en el vocabulario de la ontología del juego.
3.  Turno Exploración. Antes de asignar las estrategias a las zonas del tablero los agentes participantes tienen que invertir un mínimo del 30% de los puntos de acción para realizar acciones de exploración:
    1.  El agente tablero pide a cada uno de los agentes su inversión en puntos de acción para realizar operaciones de exploración a una zona del tablero. Un punto de acción tiene un 20% para obtener el objetivo presente en la zona. Cada punto adicional sumará otro 20% hasta un máximo de 80%.
    2.  El tablero informa a cada agente la zona que está explorando su rival.
    3.  Esta fase termina cuando ambos agentes pasan en invertir más puntos a la exploración.
4.  Turno Acción. El tablero solicita a ambos jugadores que suministren sus estrategias a cada una de las zonas del juego. Cada estrategia tiene un coste en puntos de acción posibles. Se pueden asignar más de una vez una estrategia a una zona del tablero diferente si se dispone de suficientes puntos de acción.
5.  Calculo del resultado. El AgenteTablero realiza el cálculo de los puntos para cada una de las zonas revisado la tabla de pagos para las estrategias que cada uno de los agentes ha elegido asignar a cada zona. El resultado se comunicará a los jugadores participantes así como las estrategias que el rival ha elegido para cada una de las zonas del juego.

### Estrategias para los jugadores

Para el  **Agente Espía**:

-   **Evaluar Objetivos (EO):**  Seleccionar los objetivos más valiosos para el espionaje.
-   **Planificar Infiltración (PI):**  Desarrollar un plan detallado para infiltrarse en un objetivo.
-   **Ejecutar Espionaje (EE):**  Realizar la operación de espionaje para obtener información.
-   **Extraer Información (EI):**  Asegurar y transmitir información obtenida de vuelta a la base.
-   **Desinformación (DE):**  Crear y diseminar información falsa para confundir al Agente de Seguridad.

Para el  **Agente de Seguridad**:

-   **Detectar Infiltraciones (DI):**  Identificar y localizar posibles espías en el área.
-   **Interceptar Comunicaciones (IC):**  Capturar y analizar comunicaciones para identificar operaciones de espionaje.
-   **Neutralizar Espías (NE):**  Detener a los espías detectados y prevenir la fuga de información.
-   **Fortalecer Defensas (FD):**  Mejorar la seguridad para prevenir futuras infiltraciones.
-   **Contrainteligencia (CI):**  Identificar y contrarrestar la desinformación.

La matriz de pagos que refleja las interacciones entre las 5 estrategias de cada agente. Cada celda muestra el resultado de la confrontación entre la estrategia del **Agente Espía**  (filas) y la estrategia del  **Agente de Seguridad**  (columnas), expresado como (Puntos para Agente Espía, Puntos para Agente de Seguridad).

| Agente Espía \ Agente Seguridad |   DI   |   IC   |   NE   |   FD   |   CI   |
|:-------------------------------:|:------:|:------:|:------:|:------:|:------:|
|              **EO**              | (1, -1)| (0, 0) | (-1, 1)| (2, -2)| (1, -1)|
|              **PI**              | (0, 0) | (1, -1)| (-2, 2)| (1, -1)| (0, 0) |
|              **EE**              | (-2, 2)| (2, -2)| (0, 0) | (-1, 1)| (-1, 1)|
|              **EI**              | (-1, 1)| (3, -3)| (-3, 3)| (0, 0) | (2, -2)|
|              **DE**              | (2, -2)| (-1, 1)| (1, -1)| (2, -2)| (-2, 2)|

**Explicación de la Matriz:**

-   **(EO, DI), (PI, IC), etc.:**  Estas combinaciones reflejan cómo ciertas estrategias se enfrentan de manera más efectiva a otras, basado en los roles de espionaje y contraespionaje.
-   **(EI, IC), (DE, CI):**  Estrategias más sofisticadas como "Extraer Información" y "Desinformación" tienen interacciones únicas con estrategias defensivas como "Interceptar Comunicaciones" y "Contrainteligencia", respectivamente, reflejando el juego de gato y ratón entre el espionaje y la contraespionaje.
-   **(EE, NE), (EI, NE):**  Operaciones en el campo como "Ejecutar Espionaje" y "Extraer Información" son particularmente vulnerables a la "Neutralización de Espías", mostrando el riesgo inherente de estas acciones.
-   **(DE, DI), (DE, FD):**  La "Desinformación" resulta especialmente efectiva contra "Detectar Infiltraciones" y "Fortalecer Defensas", ya que puede desviar recursos y atención de los verdaderos riesgos.

**Costes para Estrategias del Agente Espía:**

1.  **Evaluar Objetivos (EO):**  2 puntos. Requiere menos recursos ya que es más una actividad de planificación y análisis.
2.  **Planificar Infiltración (PI):**  3 puntos. Requiere un esfuerzo moderado para elaborar un plan efectivo.
3.  **Ejecutar Espionaje (EE):**  4 puntos. Es costosa debido a la necesidad de recursos operativos en el terreno.
4.  **Extraer Información (EI):**  5 puntos. Altamente costosa debido al riesgo y la necesidad de operaciones seguras para extraer la información obtenida.
5.  **Desinformación (DE):**  3 puntos. Requiere recursos para crear y diseminar la información falsa pero es menos costosa que una operación en campo.

**Costes para Estrategias del Agente de Seguridad:**

1.  **Detectar Infiltraciones (DI):**  2 puntos. Actividad de vigilancia y monitoreo que requiere menos recursos.
2.  **Interceptar Comunicaciones (IC):**  3 puntos. Involucra la tecnología y el personal para monitorear y analizar las comunicaciones.
3.  **Neutralizar Espías (NE):**  4 puntos. Requiere una acción directa y posiblemente el uso de fuerza o tácticas avanzadas.
4.  **Fortalecer Defensas (FD):**  3 puntos. Implica mejoras en las infraestructuras de seguridad, pero es una inversión a largo plazo.
5.  **Contrainteligencia (CI):**  5 puntos. La más costosa, dado que requiere una combinación de análisis, operaciones en campo y medidas para contrarrestar la desinformación.

# Ontología
En este documento se presenta el análisis, diseño para las ontologías que se utilizarán en el desarrollo de prácticas para el juego de espías de la práctica final de la asignatura. El diseño de las ontologías estará pensado para resolver las necesidades de comunicación de los agentes implicados en las prácticas. Estos agentes estarán diseñados para responder a los eventos necesarios para:

- Localizar a los agentes especializados:
	 - Agentes jugadores que podrán participar en un juego de espías. Los jugadores conocen las reglas y no podrán *hacer trampas*.
	 - Agentes organizadores que crearán las partidas entre los jugadores para poder completar los juegos a su cargo.
- Realizar las tareas necesarias para los diferentes juegos:
	 - Conocer la disponibilidad de los agentes jugadores para participar en un juego.
	 - Iniciar las partidas que componen los juegos. 
	 - Completar los turnos necesarios para una partida individual entre dos agentes jugadores.
	 - Comunicar el resultado de las diferentes partidas para completar el resultado de un juego.

Como el diseño de las ontologías estará enfocado en resolver las necesidades de comunicación entre los agentes se incluirán los diagramas AUML para los diferentes protocolos de comunicación entre **agentes-FIPA** que las resuelven.

## 1 Análisis de la Ontología

Se exponen las preguntas de competencia para conocer si nuestra ontología resuelve apropiadamente las necesidades para el juego de espías que los alumnos deben desarrollar:

1. ¿Cómo diferenciar a los diferentes agentes especializado?
2. ¿Cómo conocer la disponibilidad de los jugadores para participar en un juego?
3. ¿Cómo debe completarse un juego?
4. ¿Cómo obtener el resultado del juego propuesto?
5. ¿Cómo generar las partidas que componen un juego?
6. ¿Cómo iniciar la partida? ¿Cómo completar un turno de una partida? ¿Cómo completar la partida?
7. ¿Cómo informar del resultado final de la partida?

Estas preguntas van a necesitar que se intercambie información entre los agentes de la plataforma. Para resolver las diferentes preguntas se presentan los diagramas AUML para la secuencia de mensajes que deben intercambiarse entre los agentes implicados.

### 1.1 ¿Cómo diferenciar a los diferentes agentes especializado?
Para resolver esta pregunta utilizaremos la utilidad del servicio de páginas amarillas que nos proporciona la plataforma de **agentes-FIPA**. De esta forma no será necesario tener elementos en la ontología para poder resolver el problema de comunicación pero sí será necesario un elemento en el vocabulario para que los agentes puedan subscribirse en el servicio de páginas amarillas de forma homogénea:

- `NOMBRE_SERVICIO` : Esta constante contiene la cadena necesaria para registrar los agentes en el servicio de página amarillas. Todos los agentes que deban ser localizados deberán registrar un servicio con este nombre.
- `TipoAgenteJugador` : Los agentes jugadores deberán completar el registro de las páginas amarillas con el tipo correspondiente a su tipo de jugador. Los valores posibles son:
	- `ESPIA` : Representa a los jugadores espías que tendrán a su disposición estrategias propias para el juego.
	- `SEGURIDAD` : Representa a los jugadores que se enfrentan a los espías utilizando para ellos también sus propias estrategias.
- `TipoAgenteOrganizador` : No juegan las partidas pero tendrán la responsabilidad de coordinar diferentes acciones necesarias para el desarrollo de los juegos y partidas entre los agentes jugadores. Para completar el registro en las páginas amarillas utilizarán el tipo correspondiente. Los valores posibles son:
	- `ORGANIZADOR` : Este agente se encargará de completar los juegos que tenga asociados generando las partidas necesarias para ello con los jugadores que componen esas partidas. También será el encargado de almacenar los resultados de los juegos por si se requiere una reproducción posterior.
	- `TABLERO` : Este agente será el encargado del desarrollo de un enfrentamiento individual entre dos jugadores. Además registrará los movimientos y resultado para que el agente organizador al cargo de la partida pueda reproducirla.
	- `MONITOR` : Es el agente encargado de recopilar la disponibilidad de los jugadores para participar en juegos que posteriormente distribuirá entre los agentes organizadores para que que puedan completarse.

Solo deberán registrarse en el servicio de páginas amarillas aquellos agentes que deban ser localizados por otros agentes para completar las tareas que tengan a su cargo.

### 1.2 ¿Cómo conocer la disponibilidad de los jugadores para participar en un juego?
Un `AgenteOrganizador` propondrá un juego, con una configuración establecida, a diferentes `AgenteJugador` . Será responsabilidad del `AgenteOrganizador` seleccionar un conjunto suficiente de `AgenteJugador` para que posteriormente se puedan desarrollar las partidas necesarias para completar el juego. El AgenteJugador solo puede rechazar participar si ya está jugando activamente un número de partidas. El mínimo necesario estará expresado en el vocabulario de la ontología.

![][ProponerJuego]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `ProponerJuego` : Esta acción contiene la información necesaria para que los jugadores indiquen su disponibilidad para participar en un juego atendiendo a la modalidad propuesta.
	- `Juego` : Representa la información asociada a un juego para que el jugador pueda conocerla.
		- `idJuego` : Es un identificador único para que el agente pueda utilizarlo en su gestión interna de la información asociada a un juego.
		- `ModoJuego` : Indica el tipo de juego que se puede desarrollar. Los valores disponibles están contenidos en el vocabulario de la ontología y son los siguientes:
			- `INDIVIDUAL` : Para partidas de 1 vs 1.
			- `EQUIPO` : Corresponde a enfrentamientos individuales entre cada uno de los miembros de un equipo.
			- `TORNEO` : Corresponde a un enfrentamiento individual contra todos los miembros del equipo rival.
- `Registro` : Es un predicado que indica la disponibilidad de un jugador a participar en el juego propuesto.
	- `idJuego` : Corresponde a un identificador válido para el juego anteriormente propuesto.
	- `Agente` : Corresponde a la representación del agente en el juego.
- `Justificacion` : Es un predicado que comunica el motivo por el que el agente jugador no tiene disponibilidad para participar en el juego propuesto.
	- `idJuego` : Corresponde a un identificador válido para el juego anteriormente propuesto.
	- `Motivacion` : Es un enumerado definido en el vocabulario para indicar la no disponibilidad.

### 1.3 ¿Cómo debe completarse un juego?
La responsabilidad en la organización de un juego puede dividirse entre varios agentes organizadores. Si el agente organizador que ha localizado agentes jugadores no es el encargado de desarrollar las partidas necesarias para completar un juego se debe encargar esta tarea al agente correspondiente. Para ello se seguirá el siguiente protocolo:

![][OrganizarJuego]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `OrganizarJuego` : Es la acción con la información necesaria para que el agente organizador pueda generar las partidas necesarias para completar el juego.
	- `Juego` : Contiene la información del juego para el que el agente organizador pueda crear las partidas necesarias.
	- `InfoPartida` : Es la configuración establecida para el desarrollo de todos las partidas que componen un juego.
		- `puntosAccion` : Corresponde a los puntos de acción disponibles para que un jugador realice las acciones necesarias en la partida.
		- `numZonasJuego` : El número total de zonas de juego donde se desarrolla la partida.
	- `List` : Una lista de los agentes jugadores que podrán formar parte de las partidas. La lista puedes ser mayor que la cantidad de jugadores necesaria para las partidas por si alguno de ellos falla antes de que la partida comience de forma efectiva. 

El resto de elementos de la ontología ya han sido presentado previamente.

### 1.4 ¿Cómo obtener el resultado del juego propuesto?
Si se ha dividido la responsabilidad de localizar a los jugadores para un juego y la organización del juego entre dos `AgenteOrganizacion` el primero deberá conocer si alguno de los juegos que ha delegado su organización no ha podido iniciarse porque los jugadores no estaban disponibles en el momento de establecer todas las partidas necesarias para completar el juego. Para ello se utiliza el siguiente protocolo:

![][RegistrarIncidencias]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `RegistrarIncidencia` : La suscripción se puede realizar para recibir información sobre los juegos que no se han podido iniciar y/o el resultado del juego una vez ha finalizado su organización
	- `TipoIncidencia` : Los valores posibles están representados por un enumerado en el vocabulario.
- `ResultadoJuego` : Contiene la información del resultado del juego cuando ha finalizado
	- `idJuego` : Es el identificador del juego para el que se recibe su resultado
	- `List` : La lista de jugadores que han participado de forma activa en el juego.
	- `List` : La puntuación obtenida por cada jugador en el juego. Las puntuaciones estarán en el mismo orden en el que están los jugadores en la lista previa.
- `IncidenciaJuego` : Información relativa para conocer el problema que ha surgido durante la organización del juego
	- `idJuego` : El identificador del juego asociado a la incidencia
	- `Incidencia` : Las posibles incidencias están agrupadas mediante un enumerado en el vocabulario de la ontología.

Tanto `ResultadoJuego` como `IncidenciaJuego` heredan de un predicado abstracto `SubInform` al tratarse de dos predicados que pueden enviarse atendiendo al tipo de suscripción que previamente haya registrado el AgenteOrganizador, del tipo MONITOR, con el encargado en organizar el juego.

### 1.5 ¿Cómo generar las partidas que componen un juego?
El `AgenteOrganizador` encargado para organizar un juego será el responsable para la generación de las partidas que componen un juego. Según los modos:

 1. `INDIVIDUAL` : Se genera una única partida para el juego donde se enfrentan un jugador de cada tipo (`ESPIA`, `SEGURIDAD`). La lista inicial de jugadores para el juego permitirá al AgenteOrganizador realizar la selección que estime oportuna para la partida pero deberá distribuir justamente los enfrentamientos para que no siempre jueguen entre sí los mismos jugadores.
 2. `EQUIPO` : En esta modalidad hay un número de jugadores de cada tipo, en el vocabulario estará definido el número máximo y mínimo, y se genera un número de partidas igual a la cantidad de jugadores para que cada jugador de un equipo se enfrente con un único jugador del equipo contrario. Como en el caso anterior la lista de jugadores será la que permita generar los equipos que formarán parte del juego.
 3. `TORNEO` : Es similar al caso anterior pero ahora cada jugador de un equipo deberá enfrentarse a todos los jugadores del equipo contrario, es decir, cada jugador jugará un número de partidas igual al número de jugadores de un equipo.

El `AgenteOrganizador` deberá tener una interfaz gráfica asociada a cada juego donde se muestra la representación de las distintas etapas del juego. Se valorará especialmente que la interfaz sea clara y que el desarrollo de la partida se visualice correctamente. Además deberá permitirse la reproducción de cualquier juego previamente resuelto por el `AgenteOrganizador`. Para el desarrollo de las partidas individuales se recomienda que se cree un `AgenteOrganizador` de tipo `TABLERO`.

La información que deben intercambiarse será la siguiente:

- El `AgenteOrganizador` deberá indicar al `AgenteTablero` el elemento de ontología `Partida` donde se detalla toda la información necesaria para el desarrollo de una partida:
	- `idPartida` : El identificador de la partida
	- `idJuego` : El identificador del juego asociado a esta partida
	- `InfoPartida` : La configuración de la partida para que los jugadores conozcan el estado inicial.
		- `puntosAccion` : Los puntos de acción para las acciones a realizar en la partida.
		- `numZonas` : Número de zonas donde habrá objetivos de la partida.
	- `List` : Una lista donde está la cantidad de objetivos que hay de cada tipo. Los tipos de objetivos forman parte del vocabulario de la ontología.

	Además deberá suministrar una lista con dos `AgenteJugador` que son los jugadores de la partida.

- El `AgenteTablero` deberá indicar al `AgenteOrganizador` el archivo donde almacena los movimientos de la partida así como el resultado final de la misma. 

### 1.6 ¿Cómo iniciar la partida? ¿Cómo completar un turno de una partida? ¿Cómo completar la partida?
#### Iniciar la Partida
El `AgenteOrganizador` tiene la lista de los posibles jugadores para todas las partidas que tenga que crear para un juego. Para ello deberá completar el siguiente protocolo:

![][IniciarPartida]

Hay que tener un jugador de cada tipo para que una partida pueda dar comienzo y que un `AgenteTablero` se haga cargo del desarrollo de la misma.

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía a los agentes. Los elementos de la ontología tendrán los siguientes atributos:

- `IniciarPartida` : Contiene la información necesaria para que los agentes jugadores conozcan el estado inicial de la partida.
	- `Partida` : este elemento se presentó en el punto anterior.
- `AccionPartida` : El agente jugador deberá escoger uno de los estados posibles de acción para una partida. Vienen definidos en el vocabulario pero en este momento podrán ser `INICIO` o `ABANDONAR`. 

#### Desarrollo de la partida
Cuando el AgenteTablero se hace cargo de una partida deberá completar dos etapas:

 1. `Explotación` : Corresponde a diferentes turno hasta que los jugadores deciden dar por concluida esta etapa.
 2. `Asignación` : Asignan estrategias a las diferentes zonas de juego según los puntos de acción disponibles.

#### Turnos de exploración 
Para completar esta etapa hay que ir generando los turnos necesarios hasta que los dos jugadores hayan decidido dar por finalizada la explotación. Para ello se utiliza el siguiente protocolo:

![][SolicitarExploracion]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `SolicitarExploracion` : Solicita a los jugadores que realcen una nueva exploración para una partida en curso
	- `idPartida` : El identificador de la partida
- `Exploración` : La información necesaria para realizar la exploración solicitada por un jugador
	- `idPartida` : El identificador de la partida.
	- `puntosAccion` : La cantidad de puntos de acción invertidos.
	- `numZona` : El número de la zona que se desea explorar. 
- `ResultadoExploracion` : Se le comunica al jugador el resultado que ha obtenido de su exploración
	- `idPartida` : El identificador de la partida.
    - `List` : Es una colección de `OperacionExploracion`, el primero indica el resultado de la exploración del jugador y el segundo para informar de la zona que ha explorado el rival.
      - `OperacionExploracion` : Contiene la información de un objetivo para una zona de juego.
        - `numZona` : Número de la zona que se ha explorado.
        - `Objetivo` : Si la operación de exploración ha sido un éxito se indica el objetivo de la zona. `DESCONOCIDO` si no ha sido así y también para comunicar solo la zona que ha explorado el rival.
 

#### Asignación de estrategias
Cuando los dos jugadores de una partida han completado sus turnos de exploración se pasa a la siguiente etapa de la partida y para ello se utiliza el siguiente protocolo:

![][AsignarEstrategias]

En el diagrama se presentan los elementos de la ontología que deberán formar parte del contenido del mensaje que se envía al agente. Los elementos de la ontología tendrán los siguientes atributos:

- `AsignarEstrategias` : Solicita a los jugadores que den su asignación de estrategias
	- `idPartida` : El identificador de la partida para el que se solicita la asignación
- `AsignacionEstrategias` : Representa el movimiento del jugador para las zonas de juego y los puntos de acción que dispone.
	- `idPartida` : El identificador de la partida donde se está haciendo el movimiento.
	- `List` : Es la lista de `Asignacion` que realiza el jugador para las zonas de juego. 
		- `Asignacion` : Contiene la `Estrategia` asignada a una zona de juego.
			- `numZona` : El número de la zona de juego para el que se asigna una Estrategia.
			- `Estrategia` : Representa la información relacionada con la estrategia seleccionada.
				- `estrategia` : Es la cadena que representa la estrategia seleccionada. Las estrategias disponibles se encuentran en el vocabulario de la ontología para los valores posibles de esta propiedad.
				- `TipoAgenteJugador` : Identifica la selección de la estrategia para obtener el valor en la matriz de pagos. Los valores posibles se encuentran en el vocabulario de la ontología.

Como al finalizar el protocolo los jugadores han sido informados de la asignación de estrategias que ha hecho su rival pueden calcular el resultado del enfrentamiento y no será necesario que el `AgenteTablero` comunique ninguna información adicional al `AgenteJugador`.

### 1.7 ¿Cómo informar del resultado final de la partida?
Como el `AgenteTablero` es creado por un `AgenteOrganizador` esta comunicación es propia y estará asociada al diseño que cada grupo desee hacer para sus agentes y no será necesario que esta información esté presente en la ontología. Pero el `AgenteOrganizador` tiene que tener conocimiento de los movimientos y resultado que se ha registrado en la partida para que pueda realizar la visualización de la misma. Además que las partidas ya finalizadas se deben poder reproducir a petición del usuario y no solo cuando se están jugando.

## 2. Diseño de la ontología
En la sección anterior se han presentado todos los elementos y relaciones que se presentan en la ontología necesaria para completar los juegos propuesto. Para el diseño de la ontología se tendrá presente su implementación con las capacidades que nos proporciona la biblioteca de agentes [Jade](https://jade.tilab.com/doc/api/jade/content/package-frame.html). Las clases que representan los diferentes elementos de la ontología se dividirán en:

-   `Concept` : Elementos que representan la información necesaria para el intercambio entre los agentes y que puedan alcanzar sus objetivos relacionados con el juego de espías.
    
-   `AgentAction` : Elementos para el contenido de los mensajes en el inicio de los protocolos para completar los juegos de espías en los que los agentes estén implicados. Cuando se genere el contenido del mensaje utilizando uno de estos elemento de la ontología hay que incluirlo como parte en un objeto [`Action`](https://jade.tilab.com/doc/api/jade/content/onto/basic/Action.html) presente en el API de la biblioteca. Este será el objeto con el que se genera el contenido del mensaje y el objeto que se recupera cuando se recupera el contenido del mensaje. Es muy importante hacerlo así ya que de otro modo se produce una excepción en la ontología cuando se intenta recuperar el contenido del mensaje asociado.
    
-   `Predicate` : Elementos que forman el contenido de las respuestas en los protocolos para completar los juegos de espías en donde los agentes participan.

El diseño de la ontología incluye la siguiente estructura de paquetes:

-   `es.ujaen.ssmmaa` : paquete principal de la ontología
    -   `OntoJuegoEspias` : clase que representa la ontología para la práctica.
    -   `Vocabulario` : interface Java donde se encuentran los elementos de vocabulario utilizados en el diseño de los elementos de la ontología.
-   `es.ujaen.ssmmaa.elementos` : paquete donde se encuentran todos los elementos propios de la ontología.
    -   `Agente` : destaco este elemento porque es un elemento abstracto que sirve para identificar cualquier agente que forma parte del juego. Tienen asociado un apodo por el que serán identificados dentro del juego. Por comodidad también tendrán su `AID` que los representa dentro de la plataforma de agentes.
        -   `AgenteJugador` : identifica a los jugadores que realizarán los movimientos en el juego de espías y tienen asociado un `TipoAgenteJugador` para diferenciar los dos tipos de jugadores que participan.
        -   `Organizador` : identifica a los agentes que se encargan de todo lo relacionado con la organización del juego para que los jugadores puedan completar las partidas. Tiene asociado un `TipoOrganizador` que permite identificarlos para un reparto de las responsabilidades de organización dentro del jugo.
    -   `SubInform` : es otro elemento abstracto para poder identificar cualquier mensaje que se comunique en una suscripción relacionada con el diseño de la práctica.
        -   `IncidenciaJuego` : para comunicar cualquier incidencia que se deba conocer en la organización de un juego.
        -   `ResultadoJuego` : representa el resultado del juego con la lista de jugadores que participaron así como la lista con los puntos obtenidos por cada jugador.

### Axiomas
Para el uso de la ontología los axiomas serán:

- **Numeración de las zonas de juego** : La numeración de las zonas de juego para una representación gráfica será siempre de izquierda a derecha y de arriba a abajo.
- **Reglas del juego** : Los agentes jugadores conocen las reglas del juego y asegurarán que todos los movimientos que realicen en el juego son correctos y no van a necesitar supervisión por parte de un `AgenteOrganizador`.

## 3 Uso de la ontología para el desarrollo de la práctica
Para utilizar la ontología necesitamos acceder a las definiciones que se encuentran en la biblioteca de la ontología. Como en las prácticas estamos utilizando el gestor de dependencias [**Maven**](https://es.wikipedia.org/wiki/Maven) para nuestros proyectos Java debemos hacer las siguientes modificaciones en el fichero `pom.xml`:
Dependencias asociadas a la biblioteca de la ontología.
```xml
<repositories>
    <repository>
        <id>tilab</id>
        <url>https://jade.tilab.com/maven/</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>com.tilab.jade</groupId>
        <artifactId>jade</artifactId>
        <version>4.6.0</version>
    </dependency>
    <dependency>
        <groupId>es.ujaen.ssmmaa</groupId>
        <artifactId>OntoJuegoEspias</artifactId>
        <version>1.0</version>
    </dependency>
</dependencies>
```
Para que tener acceso a las dependencias de la ontología se instalará manualmente en el ordenador del alumno. Para ello debemos descargar el fichero [`OntoJuegoEspias-1.0.jar`](https://platea.ujaen.es/pluginfile.php/413253/mod_resource/content/1/OntoJuegoEspias-1.0.jar) que se encuentra asociado a la actividad en Platea. Posteriormente hay que ejecutar la sentencia maven:
```
mvn install:install-file -Dfile=DIRECTORIO_DE_LA_DESCARGA/OntoJuegoEspias-1.0.jar -DgroupId=es.ujaen.ssmmaa -DartifactId=OntoJuegoEspias -Dversion=1.0 -Dpackaging=jar
```
Si hay actualizaciones en el proyecto de ontología se avisará a los alumnos para que hagan la actualización de la referencia de la ontología que se indicará en este documento siguiendo las instrucciones que se han presentado en los párrafos anteriores.

[ProponerJuego]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/ProponerJuego.png?ref_type=heads
[OrganizarJuego]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/OrganizarJuego.png?ref_type=heads
[RegistrarIncidencias]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/RegistrarIncidencias.png?ref_type=heads
[IniciarPartida]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/IniciarPartida.png?ref_type=heads
[SolicitarExploracion]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/SolicitarExplotacion.png?ref_type=heads
[AsignarEstrategias]:https://gitlab.com/ssmmaa/curso2023-24/ontojuegoespias/-/raw/master/img/AsignarEstrategias.png?ref_type=heads
