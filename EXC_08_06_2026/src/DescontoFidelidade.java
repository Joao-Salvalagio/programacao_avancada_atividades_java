public class DescontoFidelidade implements CalculadoraDeDesconto{
    @Override
    public double calcular(double valorOriginal) {
        return valorOriginal * 0.05;
    }

    @Override
    public String getPerfil() {
        return "FIDELIDADE";
    }
}
