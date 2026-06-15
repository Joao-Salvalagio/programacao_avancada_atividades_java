package br.com.ticketcode.factory;

class DuvidaCategoria implements CategoriaTicket {

    @Override
    public String getNome() {
        return "Dúvida";
    }

    @Override
    public String getDescricao() {
        return "Dúvida ou orientação sobre o uso do sistema";
    }

    @Override
    public int getPeso() {
        return 1;
    }
}
