package br.com.ticketcode.factory;

class BugCategoria implements CategoriaTicket {

    @Override
    public String getNome() {
        return "Bug";
    }

    @Override
    public String getDescricao() {
        return "Erro ou falha no funcionamento do sistema";
    }

    @Override
    public int getPeso() {
        return 5;
    }
}
