package es.ujaen.ssmmaa.elementos;

import jade.content.Concept;
import jade.content.onto.annotations.Slot;
import jade.core.AID;

public abstract class Agente implements Concept {
    private String apodo;
    private AID agentePlataforma;

    public Agente() {
    }

    public Agente(String apodo, AID agentePlataforma) {
        this.apodo = apodo;
        this.agentePlataforma = agentePlataforma;
    }

    @Slot(mandatory = true)
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Slot(mandatory = true)
    public AID getAgentePlataforma() {
        return agentePlataforma;
    }

    public void setAgentePlataforma(AID agentePlataforma) {
        this.agentePlataforma = agentePlataforma;
    }
}
