public class ConversorServiceImpl implements ServicoDeConversao {

    private ConsultorDeCambio consultor;

    public ConversorServiceImpl(ConsultorDeCambio consultor) {
        this.consultor = consultor;
    }

    @Override
    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        Cotacao cotacao = consultor.buscar(moedaOrigem, moedaDestino);
        return valor * cotacao.getTaxa();
    }
}