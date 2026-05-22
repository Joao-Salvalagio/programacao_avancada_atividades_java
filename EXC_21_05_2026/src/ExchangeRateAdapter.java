import java.time.LocalDateTime;

public class ExchangeRateAdapter implements ConsultorDeCambio {

    @Override
    public Cotacao buscar(String moedaOrigem, String moedaDestino) {
        ExchangeRateResponseDTO dto = new ExchangeRateResponseDTO(
                moedaOrigem,
                moedaDestino,
                0.18,
                "2023-10-27T10:00:00Z"
        );

        return new Cotacao(
                dto.getBase_code(),
                dto.getTarget_code(),
                dto.getConversion_rate(),
                LocalDateTime.now()
        );
    }
}