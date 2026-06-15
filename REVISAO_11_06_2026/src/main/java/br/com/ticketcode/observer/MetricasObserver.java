package br.com.ticketcode.observer;

import java.util.HashMap;
import java.util.Map;

public class MetricasObserver implements TicketAbertoObserver {

    private final Map<String, Integer> contagemPorCategoria = new HashMap<>();

    @Override
    public void aoAbrirTicket(TicketAbertoEvento evento) {
        String categoria = evento.getNomeCategoria();
        int total = contagemPorCategoria.getOrDefault(categoria, 0) + 1;
        contagemPorCategoria.put(categoria, total);

        System.out.println("[MÉTRICAS] Categoria '" + categoria + "': "
                + total + " ticket(s) aberto(s) no total");
    }
}
