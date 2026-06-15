package br.com.ticketcode.observer;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FilaAtendimentoObserver implements TicketAbertoObserver {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final List<String> fila = new ArrayList<>();

    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        String prazo = evento.getPrazoAtendimento().format(FORMATADOR);
        String entrada = "#" + evento.getNumeroTicket()
                + " | " + evento.getTituloTicket()
                + " | " + evento.getNivelUrgencia()
                + " | Prazo: " + prazo;

        fila.add(entrada);

        System.out.println("[FILA] Ticket #" + evento.getNumeroTicket()
                + " adicionado. Total na fila: " + fila.size() + " ticket(s)");
    }

    public void exibirFila() {
        System.out.println("\n--- Fila de Atendimento ---");
        if (fila.isEmpty()) {
            System.out.println("(vazia)");
        } else {
            for (String ticket : fila) {
                System.out.println(ticket);
            }
        }
        System.out.println();
    }
}
