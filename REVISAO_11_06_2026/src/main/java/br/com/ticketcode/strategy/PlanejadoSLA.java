package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

class PlanejadoSLA implements CalculadoraDeSLA {

    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        return abertura.plusHours(168);
    }

    @Override
    public String getNivelDescricao() {
        return "PLANEJADO, Atendimento em até 168 horas (7 dias)";
    }
}
