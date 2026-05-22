public class MySQLConexao implements Conexao {
    @Override
    public void executarQuery(String sql) {
        System.out.println("Executando SQL para o MySQL: " + sql);
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
        return "Retornando provedor... [MySQL]";
    }
}
