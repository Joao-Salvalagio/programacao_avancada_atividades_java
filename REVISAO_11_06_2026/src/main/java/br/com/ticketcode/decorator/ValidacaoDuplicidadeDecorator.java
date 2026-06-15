package br.com.ticketcode.decorator;

import br.com.ticketcode.model.Ticket;

import java.util.HashSet;
import java.util.Set;

public class ValidacaoDuplicidadeDecorator implements ServicoDeTicket {

    private final Set<Integer> numerosRegistrados = new HashSet<>();
    private final ServicoDeTicket servicoDeTicket;

    public ValidacaoDuplicidadeDecorator(ServicoDeTicket servicoDeTicket) {
        this.servicoDeTicket = servicoDeTicket;
    }


    @Override
    public String registrar(Ticket ticket){
        if(numerosRegistrados.contains(ticket.getNumeroTicket())) {
            throw new IllegalStateException("Ticket #" + ticket.getNumeroTicket() + " já existe no sistema");
        }

        numerosRegistrados.add(ticket.getNumeroTicket());

        return servicoDeTicket.registrar(ticket);
    }
}
