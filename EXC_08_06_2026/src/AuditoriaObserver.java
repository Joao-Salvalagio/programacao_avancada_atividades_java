public class AuditoriaObserver implements UsuarioCadastradoObserver {

    @Override
    public void aoReceberNovoCadastro(UsuarioCadastradoEvento evento) {
        System.out.println("[AUDITORIA] " + evento.getCadastradoEm() + " - Novo cadastro: " + evento.getNome() + " (" + evento.getCpf() + ")");
    }
}