package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

class CriticoSLA implements CalculadoraDeSLA {

    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        return abertura.plusHours(4);
    }

    @Override
    public String getNivelDescricao() {
        return "CRÍTICO, Atendimento em até 4 horas";
    }
}
