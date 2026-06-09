public class DescontoComum implements CalculadoraDeDesconto{
    @Override
    public double calcular(double valorOriginal) {
        return 0.0;
    }

    @Override
    public String getPerfil() {
        return "COMUM";
    }
}
