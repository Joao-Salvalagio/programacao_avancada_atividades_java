public class Main {
    public static void main(String[] args) {
        ConsultorDeCambio consultor = new ExchangeRateAdapter();

        ServicoDeConversao servicoReal = new ConversorServiceImpl(consultor);

        ServicoDeConversao servicoComAuditoria = new AuditoriaConversaoDecorator(servicoReal);

        ServicoDeConversao servicoFinal = new ValidacaoConversaoDecorator(servicoComAuditoria);


        System.out.println("=== Teste 1: Conversão Válida ===");
        double resultado1 = servicoFinal.converter(100.0, "USD", "BRL");
        System.out.println("Retorno final para o usuário: " + resultado1);

        System.out.println("\n=== Teste 2: Conversão Inválida (Valor Negativo) ===");
        try {
            servicoFinal.converter(-50.0, "USD", "BRL");
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }
    }
}