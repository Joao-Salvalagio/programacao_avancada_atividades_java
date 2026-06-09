import java.util.ArrayList;
import java.util.List;

public class CadastroEventPublisher {

    private final List<UsuarioCadastradoObserver> observers = new ArrayList<>();

    public void adicionarObserver(UsuarioCadastradoObserver observer) {
        this.observers.add(observer);
    }

    public void publicar(UsuarioCadastradoEvento evento) {
        for (UsuarioCadastradoObserver observer : observers) {
            try {
                observer.aoReceberNovoCadastro(evento);
            } catch (Exception e) {
                System.err.println("Erro ao executar observer: " + e.getMessage());
            }
        }
    }
}