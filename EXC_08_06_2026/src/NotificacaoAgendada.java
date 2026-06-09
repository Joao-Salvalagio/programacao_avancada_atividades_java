public class NotificacaoAgendada implements NotificacaoStrategy {
    @Override
    public void enviar(String email, String nome) {
        System.out.println("[NOTIFICAÇÃO AGENDADA] E-mail para " + email + " colocado na fila para envio noturno.");
    }
}