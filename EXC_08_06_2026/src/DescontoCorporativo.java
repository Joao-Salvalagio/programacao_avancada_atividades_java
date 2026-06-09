public class DescontoCorporativo implements CalculadoraDeDesconto{
    @Override
    public double calcular(double valorOriginal) {
        if (valorOriginal > 500){
            return valorOriginal * 0.15;
        }else {
            return valorOriginal * 0.05;
        }
    }

    @Override
    public String getPerfil() {
        return "CORPORATIVO";
    }
}
