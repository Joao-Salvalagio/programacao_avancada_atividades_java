import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Consulta {

    private String tabela;
    private List<String> campos;
    private String condicao;
    private String ordenacao;
    private int limite;
    private int offset;
    private boolean apenasDistintos;

    private Consulta(builder builder){
        this.tabela=builder.tabela;
        this.campos=builder.campos;
        this.condicao=builder.condicao;
        this.ordenacao=builder.ordenacao;
        this.limite=builder.limite;
        this.offset=builder.offset;
        this.apenasDistintos=builder.apenasDistintos;
    }

    public String toSQL(){
        return "SELECT "
                + this.campos.stream().collect(Collectors.joining(", ")) +
                " FROM "
                + this.tabela
                + Optional.ofNullable(this.condicao).map(condicao -> " WHERE " + condicao).orElse("")
                + Optional.ofNullable(this.ordenacao).map(ordenacao -> " ORDEY BY " + ordenacao).orElse("")
                + " LIMIT " + this.limite;
    }

    public static class builder{

        private String tabela;
        private List<String> campos;
        private String condicao;
        private String ordenacao;
        private int limite;
        private int offset;
        private boolean apenasDistintos;


        public builder(String tabela, List<String> campos){

            this.tabela=tabela;

            if (campos.isEmpty()){
                throw new IllegalArgumentException("Informe ao menos 1 campo.");
            }

            this.campos=campos;

        }

        public builder tabela(String tabela){
            this.tabela=tabela;
            return this;
        }

        public builder campos(List<String> campos){
            this.campos=campos;
            return this;
        }

        public builder condicao(String condicao){
            this.condicao=condicao;
            return this;
        }

        public builder ordenacao(String ordenacao){
            this.ordenacao=ordenacao;
            return this;
        }

        public builder limite(int limite){
            this.limite=limite;
            return this;
        }

        public builder offset(int offset){
            this.offset=offset;
            return this;
        }

        public builder apenasDistintos(boolean apenasDistintos){
            this.apenasDistintos=apenasDistintos;
            return this;
        }

        public Consulta build(){

            if (this.limite == 0){
                this.limite=100;
            }

            return new Consulta(this);
        }

    }

}