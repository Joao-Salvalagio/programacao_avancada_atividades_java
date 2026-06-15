package br.com.ticketcode.factory;

public class CategoriaTicketFactory {

//    private CategoriaTicketFactory() {
//    }

    public static CategoriaTicket criar(TipoCategoria tipo) throws Exception {
        if (tipo == null) {
            throw new Exception("Tipo de categoria não pode ser nulo");
        }

        return switch (tipo) {
            case BUG -> new BugCategoria();
            case MELHORIA -> new MelhoriaCategoria();
            case DUVIDA -> new DuvidaCategoria();
            case ACESSO -> new AcessoCategoria();
            case INFRAESTRUTURA -> new InfraestruturaCategoria();
        };
    }
}
