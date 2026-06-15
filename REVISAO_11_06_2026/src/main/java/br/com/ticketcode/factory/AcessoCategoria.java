package br.com.ticketcode.factory;

class AcessoCategoria implements CategoriaTicket {

    @Override
    public String getNome() {
        return "Acesso";
    }

    @Override
    public String getDescricao() {
        return "Solicitação de permissões, credenciais ou liberação de acesso";
    }

    @Override
    public int getPeso() {
        return 3;
    }
}
