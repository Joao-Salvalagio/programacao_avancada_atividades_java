package br.com.ticketcode.observer;

import java.time.format.DateTimeFormatter;

public class ConfirmacaoSolicitanteObserver implements TicketAbertoObserver {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        String prazo = evento.getPrazoAtendimento().format(FORMATADOR);

        System.out.println("[CONFIRMAÇÃO] E-mail enviado para " + evento.getEmailSolicitante()
                + " — Ticket #" + evento.getNumeroTicket()
                + " recebido. Prazo: " + prazo);
    }
}
