package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

class MedioSLA implements CalculadoraDeSLA {

    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        return abertura.plusHours(24);
    }

    @Override
    public String getNivelDescricao() {
        return "MÉDIO, Atendimento em até 24 horas";
    }
}
