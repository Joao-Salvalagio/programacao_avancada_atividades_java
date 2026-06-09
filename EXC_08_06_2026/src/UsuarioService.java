import java.time.LocalDateTime;
import java.util.Random;

public class UsuarioService {

    private final CadastroEventPublisher publisher;

    public UsuarioService(CadastroEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void cadastrar(String nome, String email, String cpf) {
        System.out.println("Salvando usuário no banco de dados...");
        Long idSimulado = new Random().nextLong(1000);

        UsuarioCadastradoEvento evento = new UsuarioCadastradoEvento(
                idSimulado, nome, email, cpf, LocalDateTime.now()
        );

        publisher.publicar(evento);
    }
}