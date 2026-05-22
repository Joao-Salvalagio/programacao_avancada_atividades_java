import java.time.LocalDateTime;

public class AuditoriaConversaoDecorator implements ServicoDeConversao {

    private ServicoDeConversao servicoInterno;

    public AuditoriaConversaoDecorator(ServicoDeConversao servicoInterno) {
        this.servicoInterno = servicoInterno;
    }

    @Override
    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        double resultado = servicoInterno.converter(valor, moedaOrigem, moedaDestino);

        System.out.println("[AUDITORIA] valor=" + valor +
                " moedaOrigem=" + moedaOrigem +
                " moedaDestino=" + moedaDestino +
                " resultado=" + resultado +
                " dataHora=" + LocalDateTime.now());

        return resultado;
    }
}