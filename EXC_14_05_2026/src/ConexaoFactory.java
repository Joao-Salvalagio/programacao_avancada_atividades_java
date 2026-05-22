public class ConexaoFactory {
    public static Conexao criar(Ambiente ambiente){
        return switch (ambiente){
           case DESENVOLVIMENTO -> new H2Conexao();
           case TESTE -> new PostgreSQLConexao();
           case PRODUCAO -> new MySQLConexao();
           default -> throw new RuntimeException("Ambiente não existe");
       };
    }
}
