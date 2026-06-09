public class NotificacaoImediata implements NotificacaoStrategy {
    @Override
    public void enviar(String email, String nome) {
        System.out.println("[NOTIFICAÇÃO IMEDIATA] Enviando e-mail agora para " + email);
    }
}