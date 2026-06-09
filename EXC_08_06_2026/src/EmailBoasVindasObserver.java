public class EmailBoasVindasObserver implements UsuarioCadastradoObserver {

    private final NotificacaoStrategy estrategiaEnvio;

    public EmailBoasVindasObserver(NotificacaoStrategy estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    @Override
    public void aoReceberNovoCadastro(UsuarioCadastradoEvento evento) {
        System.out.println("[EMAIL] Preparando e-mail de boas-vindas...");
        estrategiaEnvio.enviar(evento.getEmail(), evento.getNome());
    }
}