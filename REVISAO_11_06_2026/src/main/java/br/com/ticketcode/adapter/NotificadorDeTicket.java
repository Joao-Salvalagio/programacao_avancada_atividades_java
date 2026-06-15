package br.com.ticketcode.adapter;

import br.com.ticketcode.model.Ticket;

public interface NotificadorDeTicket {

    void notificarAbertura(Ticket ticket, String prazoFormatado);

    void notificarEncerramento(int numeroTicket, String resolucao);
}
