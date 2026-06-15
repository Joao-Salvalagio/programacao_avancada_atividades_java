package br.com.ticketcode.observer;

import br.com.ticketcode.factory.CategoriaTicket;
import br.com.ticketcode.model.Ticket;
import br.com.ticketcode.strategy.CalculadoraDeSLA;
import br.com.ticketcode.strategy.NivelUrgencia;
import br.com.ticketcode.strategy.SLAStrategyFactory;

import java.time.LocalDateTime;

public class TicketFacade {

    private final TicketEventPublisher publisher;

    public TicketFacade(TicketEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void abrirTicket(Ticket ticket, NivelUrgencia nivel, CategoriaTicket categoria) throws Exception {
        CalculadoraDeSLA estrategia = SLAStrategyFactory.criar(nivel);
        LocalDateTime abertura = LocalDateTime.now();
        LocalDateTime prazo = estrategia.calcularPrazo(abertura);

        TicketAbertoEvento evento = new TicketAbertoEvento(
                ticket.getNumeroTicket(),
                ticket.getEmailSolicitante(),
                ticket.getTitulo(),
                categoria.getNome(),
                nivel,
                prazo
        );

        publisher.publicarTicketAberto(evento);
    }
}
