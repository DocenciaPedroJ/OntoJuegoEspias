package es.ujaen.ssmmaa;

import jade.content.onto.BeanOntology;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;

public class OntoJuegoEspias extends BeanOntology {
    private static final long serialVersionUID = 1L;

    // Nombre de la ontología
    public static final String ONTOLOGY_NAME = "Ontología_Juego_Espías";

    // Única instancia para la ontología
    private static Ontology INSTANCE;

    public synchronized final static Ontology getInstance() throws BeanOntologyException {
        if (INSTANCE == null) {
            INSTANCE = new OntoJuegoEspias(ONTOLOGY_NAME);
        }

        return INSTANCE;
    }

    public OntoJuegoEspias(String name) throws BeanOntologyException {
        super(name);

        add("es.ujaen.ssmmaa.elementos");
    }
}
