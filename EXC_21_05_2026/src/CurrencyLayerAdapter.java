import java.time.LocalDateTime;

public class CurrencyLayerAdapter implements ConsultorDeCambio {

    @Override
    public Cotacao buscar(String moedaOrigem, String moedaDestino) {
        CurrencyLayerResponseDTO dto = new CurrencyLayerResponseDTO(
                moedaOrigem,
                moedaDestino,
                0.18,
                1698400000L
        );

        return new Cotacao(
                dto.getSource(),
                dto.getCurrency(),
                dto.getRate(),
                LocalDateTime.now()
        );
    }
}