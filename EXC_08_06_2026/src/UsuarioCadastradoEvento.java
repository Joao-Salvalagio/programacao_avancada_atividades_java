import java.time.LocalDateTime;

public class UsuarioCadastradoEvento {

    private final Long usuarioId;
    private final String nome;
    private final String email;
    private final String cpf;
    private final LocalDateTime cadastradoEm;

    public UsuarioCadastradoEvento(Long usuarioId, String nome, String email, String cpf, LocalDateTime cadastradoEm) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cadastradoEm = cadastradoEm;
    }

    public Long getUsuarioId() { return usuarioId; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getCpf() { return cpf; }
    public LocalDateTime getCadastradoEm() { return cadastradoEm; }
}