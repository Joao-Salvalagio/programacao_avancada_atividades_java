public class VerificacaoCpfObserver implements UsuarioCadastradoObserver {

    @Override
    public void aoReceberNovoCadastro(UsuarioCadastradoEvento evento) {
        System.out.println("[CPF] Verificando CPF " + evento.getCpf() + " no Serasa...");

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.err.println("Erro durante a verificação do CPF: " + e.getMessage());
        }
    }
}