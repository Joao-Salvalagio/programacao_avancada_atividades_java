public class DescontoStrategyFactory {

    public static CalculadoraDeDesconto criar(PerfilCliente perfil) {
        switch (perfil) {
            case COMUM:
                return new DescontoComum();
            case FIDELIDADE:
                return new DescontoFidelidade();
            case VIP:
                return new DescontoVip();
            case CORPORATIVO:
                return new DescontoCorporativo();
            default:
                throw new IllegalArgumentException("Perfil inválido");
        }
    }
}