package br.com.ticketcode;

import br.com.ticketcode.adapter.EmailNotificadorAdapter;
import br.com.ticketcode.adapter.NotificadorDeTicket;
import br.com.ticketcode.decorator.LogTicketDecorator;
import br.com.ticketcode.decorator.ServicoDeTicket;
import br.com.ticketcode.decorator.TicketServiceImpl;
import br.com.ticketcode.decorator.ValidacaoDuplicidadeDecorator;
import br.com.ticketcode.factory.CategoriaTicket;
import br.com.ticketcode.factory.CategoriaTicketFactory;
import br.com.ticketcode.factory.TipoCategoria;
import br.com.ticketcode.model.Ticket;
import br.com.ticketcode.observer.ConfirmacaoSolicitanteObserver;
import br.com.ticketcode.observer.FilaAtendimentoObserver;
import br.com.ticketcode.observer.MetricasObserver;
import br.com.ticketcode.observer.TicketEventPublisher;
import br.com.ticketcode.observer.TicketFacade;
import br.com.ticketcode.strategy.CalculadoraDeSLA;
import br.com.ticketcode.strategy.GerenciadorDeSLA;
import br.com.ticketcode.strategy.NivelUrgencia;
import br.com.ticketcode.strategy.SLAStrategyFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    private static final DateTimeFormatter FORMATADOR_PRAZO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        try {
            fluxoIntegrado();
        } catch (Exception e) {
            System.out.println("Erro no fluxo integrado: " + e.getMessage());
        }
    }


    private static void fluxoIntegrado() throws Exception {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       TICKETCODE — FLUXO INTEGRADO (6 padrões)   ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // ── 1. FACTORY METHOD ──────────────────────────────────────────
        secao("1. FACTORY METHOD — Categorias de Ticket");

        CategoriaTicket categoriaBug = CategoriaTicketFactory.criar(TipoCategoria.BUG);
        CategoriaTicket categoriaAcesso = CategoriaTicketFactory.criar(TipoCategoria.ACESSO);

        System.out.println("Categoria 1: " + categoriaBug.getNome()
                + " (peso " + categoriaBug.getPeso() + ") — " + categoriaBug.getDescricao());
        System.out.println("Categoria 2: " + categoriaAcesso.getNome()
                + " (peso " + categoriaAcesso.getPeso() + ") — " + categoriaAcesso.getDescricao());
        System.out.println();

        // ── 2. BUILDER ───────────────────────────────────────────────────
        secao("2. BUILDER — Montagem de Tickets");

        Ticket ticketUrgente = new Ticket.Builder()
                .numeroTicket(1)
                .titulo("Erro crítico no módulo financeiro")
                .descricao("Sistema trava ao fechar o mês contábil")
                .emailSolicitante("maria@devsolutions.com")
                .departamento("Financeiro")
                .versaoSistema("3.1.0")
                .anexos(List.of("erro.png", "log-sistema.txt"))
                .urgente(true)
                .build();

        Ticket ticketSimples = new Ticket.Builder()
                .numeroTicket(2)
                .titulo("Dúvida sobre permissões")
                .descricao("Como solicitar acesso ao módulo de RH?")
                .emailSolicitante("joao@devsolutions.com")
                .build();

        System.out.println("Ticket urgente (completo):");
        System.out.println(ticketUrgente);
        System.out.println();
        System.out.println("Ticket simples (só obrigatórios):");
        System.out.println(ticketSimples);
        System.out.println();

        // ── 3. STRATEGY ──────────────────────────────────────────────────
        secao("3. STRATEGY — Cálculo de SLA");

        GerenciadorDeSLA gerenciadorSLA = new GerenciadorDeSLA();
        CalculadoraDeSLA slaCritico = SLAStrategyFactory.criar(NivelUrgencia.CRITICO);
        CalculadoraDeSLA slaMedio = SLAStrategyFactory.criar(NivelUrgencia.MEDIO);

        System.out.println("SLA do ticket urgente (#1):");
        gerenciadorSLA.exibirPrazo(ticketUrgente, slaCritico);

        System.out.println("SLA do ticket simples (#2):");
        gerenciadorSLA.exibirPrazo(ticketSimples, slaMedio);

        LocalDateTime abertura = LocalDateTime.now();
        String prazoTicket1 = slaCritico.calcularPrazo(abertura).format(FORMATADOR_PRAZO);
        String prazoTicket2 = slaMedio.calcularPrazo(abertura).format(FORMATADOR_PRAZO);

        // ── 4. ADAPTER ───────────────────────────────────────────────────
        secao("4. ADAPTER — Notificação por E-mail");

        NotificadorDeTicket notificador = new EmailNotificadorAdapter();

        notificador.notificarAbertura(ticketUrgente, prazoTicket1);
        System.out.println();
        notificador.notificarAbertura(ticketSimples, prazoTicket2);
        System.out.println();

        // ── 5. DECORATOR ─────────────────────────────────────────────────
        secao("5. DECORATOR — Registro com Log e Validação");

        ServicoDeTicket servicoRegistro = new LogTicketDecorator(
                new ValidacaoDuplicidadeDecorator(
                        new TicketServiceImpl()
                )
        );

        System.out.println(servicoRegistro.registrar(ticketUrgente));
        System.out.println(servicoRegistro.registrar(ticketSimples));
        System.out.println();

        System.out.println("Tentativa de registrar ticket duplicado (#1)...");
        try {
            Ticket ticketDuplicado = new Ticket.Builder()
                    .numeroTicket(1)
                    .titulo("Tentativa duplicada")
                    .descricao("Não deve ser registrado")
                    .emailSolicitante("outro@devsolutions.com")
                    .build();
            servicoRegistro.registrar(ticketDuplicado);
        } catch (IllegalStateException e) {
            System.out.println("Exceção capturada (esperado): " + e.getMessage());
        }
        System.out.println();

        // ── 6. OBSERVER ──────────────────────────────────────────────────
        secao("6. OBSERVER — Abertura Oficial via Facade");

        TicketEventPublisher publisher = new TicketEventPublisher();
        FilaAtendimentoObserver filaObserver = new FilaAtendimentoObserver();

        publisher.registrar(new ConfirmacaoSolicitanteObserver());
        publisher.registrar(filaObserver);
        publisher.registrar(new MetricasObserver());

        TicketFacade facade = new TicketFacade(publisher);

        System.out.println("Abrindo tickets oficialmente no sistema...\n");

        facade.abrirTicket(ticketUrgente, NivelUrgencia.CRITICO, categoriaBug);
        facade.abrirTicket(ticketSimples, NivelUrgencia.MEDIO, categoriaAcesso);

        // Mais 2 tickets para variedade de categorias/urgências (requisito do Observer)
        Ticket ticket3 = new Ticket.Builder()
                .numeroTicket(3)
                .titulo("Melhorar tela de login")
                .descricao("Sugestão de UX para autenticação")
                .emailSolicitante("dev@devsolutions.com")
                .build();

        Ticket ticket4 = new Ticket.Builder()
                .numeroTicket(4)
                .titulo("Servidor de homologação offline")
                .descricao("Ambiente indisponível para testes")
                .emailSolicitante("ti@devsolutions.com")
                .build();

        facade.abrirTicket(ticket3, NivelUrgencia.BAIXO,
                CategoriaTicketFactory.criar(TipoCategoria.MELHORIA));
        facade.abrirTicket(ticket4, NivelUrgencia.ALTO,
                CategoriaTicketFactory.criar(TipoCategoria.INFRAESTRUTURA));

        filaObserver.exibirFila();

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║      FLUXO INTEGRADO CONCLUÍDO COM SUCESSO       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }

    private static void secao(String titulo) {
        System.out.println("── " + titulo + " ──\n");
    }
}
