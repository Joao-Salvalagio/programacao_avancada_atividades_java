package br.com.ticketcode.strategy;

public class SLAStrategyFactory {

//    private SLAStrategyFactory() {
//    }

    public static CalculadoraDeSLA criar(NivelUrgencia nivel) throws Exception {
        if (nivel == null) {
            throw new Exception("Nível de urgência não pode ser nulo");
        }

        return switch (nivel) {
            case CRITICO -> new CriticoSLA();
            case ALTO -> new AltoSLA();
            case MEDIO -> new MedioSLA();
            case BAIXO -> new BaixoSLA();
            case PLANEJADO -> new PlanejadoSLA();
        };
    }
}
