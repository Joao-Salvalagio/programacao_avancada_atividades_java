package br.com.ticketcode.decorator;

import br.com.ticketcode.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements ServicoDeTicket {

    private final List<Ticket> tickets = new ArrayList<>();

    @Override
    public String registrar(Ticket ticket) {
        tickets.add(ticket);
        return "Ticket #" + ticket.getNumeroTicket() + " registrado com sucesso";
    }
}
