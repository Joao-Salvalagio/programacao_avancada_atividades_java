package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

public interface CalculadoraDeSLA {

    LocalDateTime calcularPrazo(LocalDateTime abertura);

    String getNivelDescricao();
}
