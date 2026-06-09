public class CarrinhoService {

    public double calcularTotal(double subtotal, CalculadoraDeDesconto desconto) {
        double valorDesconto = desconto.calcular(subtotal);
        return subtotal - valorDesconto;
    }
}