public class ConversorService {

    private ConsultorDeCambio consultor;

    public ConversorService(ConsultorDeCambio consultor) {
        this.consultor = consultor;
    }

    public double converter(double valor, String moedaOrigem, String moedaDestino) {
        Cotacao cotacao = consultor.buscar(moedaOrigem, moedaDestino);

        return valor * cotacao.getTaxa();
    }
}