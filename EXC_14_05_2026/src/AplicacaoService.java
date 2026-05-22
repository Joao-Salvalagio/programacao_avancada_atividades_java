import java.util.List;

public class AplicacaoService {
    static void main() {
        Conexao conexao = ConexaoFactory.criar(Ambiente.PRODUCAO);

        conexao.conectar();

        System.out.println(conexao.getProvedor());

        Consulta consultaNome = new Consulta.builder("Pessoa", List.of("Nome", "CPF"))
                .condicao("nome LIKE '%joão%")
                .limite(3)
                .ordenacao("nome desc")
                .build();

        System.out.println(consultaNome.toSQL());
    }
}
