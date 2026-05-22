public interface Conexao {
    void conectar();
    void executarQuery(String sql);
    void fechar();
    String getProvedor();
}