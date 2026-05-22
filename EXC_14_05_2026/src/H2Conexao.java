public class H2Conexao implements Conexao {
    @Override
    public void executarQuery(String sql) {
        System.out.println("Executando SQL para o H2: " + sql);
    }

    @Override
    public void conectar() {
        System.out.println("Conectando...");
    }

    @Override
    public void fechar() {
        System.out.println("Fechando...");
    }

    @Override
    public String getProvedor() {
        return "Retornando provedor... [H2]";
    }
}
