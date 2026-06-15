package br.com.ticketcode.observer;

import br.com.ticketcode.strategy.NivelUrgencia;

import java.time.LocalDateTime;

public class TicketAbertoEvento {

    private final int numeroTicket;
    private final String emailSolicitante;
    private final String tituloTicket;
    private final String nomeCategoria;
    private final NivelUrgencia nivelUrgencia;
    private final LocalDateTime prazoAtendimento;
    private final LocalDateTime aberturaEm;

    public TicketAbertoEvento(int numeroTicket, String emailSolicitante, String tituloTicket,
                              String nomeCategoria, NivelUrgencia nivelUrgencia,
                              LocalDateTime prazoAtendimento) {
        this.numeroTicket = numeroTicket;
        this.emailSolicitante = emailSolicitante;
        this.tituloTicket = tituloTicket;
        this.nomeCategoria = nomeCategoria;
        this.nivelUrgencia = nivelUrgencia;
        this.prazoAtendimento = prazoAtendimento;
        this.aberturaEm = LocalDateTime.now();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public String getTituloTicket() {
        return tituloTicket;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public NivelUrgencia getNivelUrgencia() {
        return nivelUrgencia;
    }

    public LocalDateTime getPrazoAtendimento() {
        return prazoAtendimento;
    }

    public LocalDateTime getAberturaEm() {
        return aberturaEm;
    }
}
