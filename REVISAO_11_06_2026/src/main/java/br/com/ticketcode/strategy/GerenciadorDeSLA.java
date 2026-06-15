package br.com.ticketcode.strategy;

import br.com.ticketcode.model.Ticket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerenciadorDeSLA {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void exibirPrazo(Ticket ticket, CalculadoraDeSLA estrategia) {
        LocalDateTime abertura = LocalDateTime.now();
        LocalDateTime prazo = estrategia.calcularPrazo(abertura);

        System.out.println("Ticket #" + ticket.getNumeroTicket());
        System.out.println("Nível: " + estrategia.getNivelDescricao());
        System.out.println("Abertura: " + abertura.format(FORMATADOR));
        System.out.println("Prazo limite: " + prazo.format(FORMATADOR));
        System.out.println();
    }
}
