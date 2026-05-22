public class ValidacaoConversaoDecorator implements ServicoDeConversao {

    private ServicoDeConversao servicoInterno;

    public ValidacaoConversaoDecorator(ServicoDeConversao servicoInterno) {
        this.servicoInterno = servicoInterno;
    }

    @Override
    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor de conversão deve ser positivo");
        }

        return servicoInterno.converter(valor, moedaOrigem, moedaDestino);
    }
}