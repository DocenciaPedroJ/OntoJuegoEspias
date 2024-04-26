package es.ujaen.ssmmaa;

import es.ujaen.ssmmaa.elementos.AgenteOrganizador;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.BeanOntologyException;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.*;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.proto.AchieveREResponder;
import jade.util.Logger;

import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;

import static es.ujaen.ssmmaa.Vocabulario.*;

public class AgenteTest extends Agent {
    // Para trabajar con la ontología
    private final ContentManager manager = getContentManager();

    // El lenguaje utilizado por el agente para la comunicación es SL
    private final Codec codec = new SLCodec();

    // La ontología que utilizará el agente
    private Ontology ontology;

    @Override
    protected void setup() {
        //Registro en Página Amarillas
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType(TipoAgenteOrganizador.ORGANIZADOR.name());
        sd.setName(NOMBRE_SERVICIO);
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }

        //Registro de la Ontología
        try {
            ontology = OntoJuegoEspias.getInstance();
        } catch (BeanOntologyException ex) {
            Logger.getLogger(AgenteTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        manager.registerLanguage(codec);
        manager.registerOntology(ontology);

        System.out.println("El agente: " + this.getName() + " se ha iniciado");

        MessageTemplate msgTemplate = MessageTemplate.and(
                MessageTemplate.MatchProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST),
                MessageTemplate.MatchPerformative(ACLMessage.REQUEST) );
        addBehaviour(new TestRequestParticipant(this,msgTemplate));

        testMensaje();
    }

    @Override
    protected void takeDown() {
        //Desregistro de las Páginas Amarillas
        try {
            DFService.deregister(this);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }

        //Se liberan los recuros y se despide
        System.out.println("El agente: " + this.getName() + " finaliza su ejecución");
    }

    private void testMensaje() {
//        SolicitarAsignacion asignacion = new SolicitarAsignacion("partida-1");
//        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
//        msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
//        msg.addReceiver(this.getAID());
//        msg.setLanguage(codec.getName());
//        msg.setOntology(ontology.getName());
//        try {
//           Action ac = new Action(this.getAID(),asignacion);
//            manager.fillContent(msg,ac);
//        } catch (Codec.CodecException e) {
//            throw new RuntimeException(e);
//        } catch (OntologyException e) {
//            throw new RuntimeException(e);
//        }

        AgenteOrganizador organizador;

        organizador = new AgenteOrganizador();

        organizador.setApodo("Apodo");
        organizador.setAgentePlataforma(this.getAID());
        organizador.setTipoOrganizador(TipoAgenteOrganizador.ORGANIZADOR);

        System.out.println("^^^^^^^ " + organizador);

        //System.out.println(">>>>>>>>>>>>>\n"+msg);

        //addBehaviour(new TestRequestIniciador(this,msg));
    }


    class TestRequestIniciador extends AchieveREInitiator {

        public TestRequestIniciador(Agent a, ACLMessage msg) {
            super(a, msg);
        }

        @Override
        protected void handleAllResponses(Vector responses) {
            Iterator it = responses.iterator();

            while ( it.hasNext() ) {
                ACLMessage msg = (ACLMessage) it.next();
                System.out.println("++++\n" + msg);
            }
        }

        @Override
        protected void handleAllResultNotifications(Vector resultNotifications) {
            Iterator it = resultNotifications.iterator();

            while ( it.hasNext() ) {
                ACLMessage msg = (ACLMessage) it.next();
                System.out.println("++++\n" + msg);
            }
        }
    }

    class TestRequestParticipant extends AchieveREResponder {
        public TestRequestParticipant(Agent a, MessageTemplate mt) {
            super(a, mt);
        }

        @Override
        protected ACLMessage handleRequest(ACLMessage request) throws NotUnderstoodException, RefuseException {
            //SolicitarAsignacion asignacion;
            Action ac;

            ACLMessage respuesta = request.createReply();

            try{
                ac = (Action) manager.extractContent(request);
                System.out.println("***\n"+ac);
                respuesta.setPerformative(ACLMessage.AGREE);
            } catch (OntologyException e) {
                throw new RuntimeException(e);
            } catch (Codec.CodecException e) {
                throw new RuntimeException(e);
            }

            try {
                manager.fillContent(respuesta,ac);
            } catch (Codec.CodecException e) {
                throw new RuntimeException(e);
            } catch (OntologyException e) {
                throw new RuntimeException(e);
            }

            return respuesta;
        }

        @Override
        protected ACLMessage prepareResultNotification(ACLMessage request, ACLMessage response) throws FailureException {
            //SolicitarAsignacion asignacion;
            Action ac;

            ACLMessage respuesta = request.createReply();

            try{
                ac = (Action) manager.extractContent(request);
                System.out.println("***\n"+ac);
                respuesta.setPerformative(ACLMessage.INFORM);
            } catch (OntologyException e) {
                throw new RuntimeException(e);
            } catch (Codec.CodecException e) {
                throw new RuntimeException(e);
            }

            try {
                manager.fillContent(respuesta,ac);
            } catch (Codec.CodecException e) {
                throw new RuntimeException(e);
            } catch (OntologyException e) {
                throw new RuntimeException(e);
            }

            return respuesta;
        }
    }
}
