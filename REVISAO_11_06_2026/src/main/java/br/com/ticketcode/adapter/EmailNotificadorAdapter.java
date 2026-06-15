package br.com.ticketcode.adapter;

import br.com.ticketcode.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class EmailNotificadorAdapter implements NotificadorDeTicket {

    private final SistemaEmailFornecedor sistemaEmail;
    private final Map<Integer, String> emailsPorTicket = new HashMap<>();

    public EmailNotificadorAdapter() {
        this.sistemaEmail = new SistemaEmailFornecedor();
    }

    @Override
    public void notificarAbertura(Ticket ticket, String prazoFormatado) {
        emailsPorTicket.put(ticket.getNumeroTicket(), ticket.getEmailSolicitante());

        String assunto = "Ticket #" + ticket.getNumeroTicket() + " aberto";
        String corpo = ticket.getTitulo() + " — Prazo: " + prazoFormatado;

        sistemaEmail.enviarMensagem(ticket.getEmailSolicitante(), assunto, corpo);
    }

    @Override
    public void notificarEncerramento(int numeroTicket, String resolucao) {
        String destinatario = emailsPorTicket.get(numeroTicket);
        String detalhe = "Ticket #" + numeroTicket + " — " + resolucao;

        sistemaEmail.enviarAlerta(destinatario, "TICKET_FECHADO", detalhe);
    }
}
