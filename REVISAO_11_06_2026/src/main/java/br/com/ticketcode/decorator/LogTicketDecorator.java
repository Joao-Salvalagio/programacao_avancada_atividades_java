package br.com.ticketcode.decorator;

import br.com.ticketcode.model.Ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogTicketDecorator implements ServicoDeTicket {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final ServicoDeTicket servicoInterno;

    public LogTicketDecorator(ServicoDeTicket servicoInterno) {
        this.servicoInterno = servicoInterno;
    }

    @Override
    public String registrar(Ticket ticket) {
        String dataHora = LocalDateTime.now().format(FORMATADOR);

        System.out.println("[LOG] " + dataHora + " — Registrando ticket #"
                + ticket.getNumeroTicket() + " — Solicitante: " + ticket.getEmailSolicitante());

        String resultado = servicoInterno.registrar(ticket);

        dataHora = LocalDateTime.now().format(FORMATADOR);
        System.out.println("[LOG] " + dataHora + " — Ticket #"
                + ticket.getNumeroTicket() + " processado");

        return resultado;
    }
}
