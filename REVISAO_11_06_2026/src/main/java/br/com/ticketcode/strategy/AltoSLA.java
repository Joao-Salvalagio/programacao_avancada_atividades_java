package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

class AltoSLA implements CalculadoraDeSLA {

    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        return abertura.plusHours(8);
    }

    @Override
    public String getNivelDescricao() {
        return "ALTO, Atendimento em até 8 horas";
    }
}
