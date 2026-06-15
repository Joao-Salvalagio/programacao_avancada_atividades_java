package br.com.ticketcode.factory;

class MelhoriaCategoria implements CategoriaTicket {

    @Override
    public String getNome() {
        return "Melhoria";
    }

    @Override
    public String getDescricao() {
        return "Sugestão de melhoria ou nova funcionalidade";
    }

    @Override
    public int getPeso() {
        return 2;
    }
}
