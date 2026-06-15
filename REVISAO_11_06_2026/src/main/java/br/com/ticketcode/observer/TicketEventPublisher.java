package br.com.ticketcode.observer;

import java.util.ArrayList;
import java.util.List;

public class TicketEventPublisher {

    private final List<TicketAbertoObserver> observers = new ArrayList<>();

    public void registrar(TicketAbertoObserver observer) {
        observers.add(observer);
    }

    public void publicarTicketAberto(TicketAbertoEvento evento) {
        for (TicketAbertoObserver observer : observers) {
            try {
                observer.aoAbrirTicket(evento);
            } catch (Exception e) {
                System.out.println("[PUBLISHER] Observer falhou, continuando: " + e.getMessage());
            }
        }
    }
}
