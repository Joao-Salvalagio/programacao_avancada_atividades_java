public class Main {
    public static void main(String[] args) {

        System.out.println("=== MÓDULO 1: TESTANDO STRATEGY (CARRINHO DE COMPRAS) ===");

        CarrinhoService carrinhoService = new CarrinhoService();
        double valorDaCompra = 600.00;

        CalculadoraDeDesconto calculoComum = DescontoStrategyFactory.criar(PerfilCliente.COMUM);
        CalculadoraDeDesconto calculoFidelidade = DescontoStrategyFactory.criar(PerfilCliente.FIDELIDADE);
        CalculadoraDeDesconto calculoVip = DescontoStrategyFactory.criar(PerfilCliente.VIP);
        CalculadoraDeDesconto calculoCorporativo = DescontoStrategyFactory.criar(PerfilCliente.CORPORATIVO);

        System.out.println("Valor do pedido: R$ " + valorDaCompra);
        System.out.println("Total para COMUM: R$ " + carrinhoService.calcularTotal(valorDaCompra, calculoComum));
        System.out.println("Total para FIDELIDADE: R$ " + carrinhoService.calcularTotal(valorDaCompra, calculoFidelidade));
        System.out.println("Total para VIP: R$ " + carrinhoService.calcularTotal(valorDaCompra, calculoVip));
        System.out.println("Total para CORPORATIVO: R$ " + carrinhoService.calcularTotal(valorDaCompra, calculoCorporativo));

        System.out.println("\n=== MÓDULO 2: TESTANDO OBSERVER + STRATEGY EXTRA (CADASTRO DE USUÁRIO) ===");

        CadastroEventPublisher publisher = new CadastroEventPublisher();

        NotificacaoStrategy estrategiaDeEnvio = new NotificacaoImediata();

        UsuarioCadastradoObserver emailObserver = new EmailBoasVindasObserver(estrategiaDeEnvio);
        UsuarioCadastradoObserver auditoriaObserver = new AuditoriaObserver();
        UsuarioCadastradoObserver cpfObserver = new VerificacaoCpfObserver();

        publisher.adicionarObserver(emailObserver);
        publisher.adicionarObserver(auditoriaObserver);
        publisher.adicionarObserver(cpfObserver);

        UsuarioService usuarioService = new UsuarioService(publisher);

        System.out.println("Ação: O usuário clicou em 'Cadastrar' no site...");
        usuarioService.cadastrar("João Silva", "joao.silva@email.com", "123.456.789-00");
    }
}