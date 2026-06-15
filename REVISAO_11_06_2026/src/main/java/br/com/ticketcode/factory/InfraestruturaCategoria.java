package br.com.ticketcode.factory;

class InfraestruturaCategoria implements CategoriaTicket {

    @Override
    public String getNome() {
        return "Infraestrutura";
    }

    @Override
    public String getDescricao() {
        return "Problemas em servidores, rede ou ambiente de execução";
    }

    @Override
    public int getPeso() {
        return 4;
    }
}
