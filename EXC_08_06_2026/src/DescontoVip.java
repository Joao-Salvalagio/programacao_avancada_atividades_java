public class DescontoVip implements CalculadoraDeDesconto{
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal * 0.10;
    }

    @Override
    public String getPerfil() {
        return "VIP";
    }
}
