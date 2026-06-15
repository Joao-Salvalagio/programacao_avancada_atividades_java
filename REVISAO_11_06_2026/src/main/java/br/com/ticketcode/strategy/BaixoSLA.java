package br.com.ticketcode.strategy;

import java.time.LocalDateTime;

class BaixoSLA implements CalculadoraDeSLA {

    @Override
    public LocalDateTime calcularPrazo(LocalDateTime abertura) {
        return abertura.plusHours(72);
    }

    @Override
    public String getNivelDescricao() {
        return "BAIXO, Atendimento em até 72 horas";
    }
}
