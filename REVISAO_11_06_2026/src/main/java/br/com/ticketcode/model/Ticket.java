package br.com.ticketcode.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ticket {

    private final int numeroTicket;
    private final String titulo;
    private final String descricao;
    private final String emailSolicitante;
    private final String departamento;
    private final String versaoSistema;
    private final List<String> anexos;
    private final boolean urgente;

    private Ticket(Builder builder) {
        this.numeroTicket = builder.numeroTicket;
        this.titulo = builder.titulo;
        this.descricao = builder.descricao;
        this.emailSolicitante = builder.emailSolicitante;
        this.departamento = builder.departamento;
        this.versaoSistema = builder.versaoSistema;
        this.anexos = Collections.unmodifiableList(new ArrayList<>(builder.anexos));
        this.urgente = builder.urgente;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getVersaoSistema() {
        return versaoSistema;
    }

    public List<String> getAnexos() {
        return anexos;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public static class Builder {
        private int numeroTicket;
        private String titulo;
        private String descricao;
        private String emailSolicitante;
        private String departamento = "Geral";
        private String versaoSistema = "Não informada";
        private List<String> anexos = new ArrayList<>();
        private boolean urgente = false;

        public Builder numeroTicket(int numeroTicket) {
            this.numeroTicket = numeroTicket;
            return this;
        }

        ;

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        ;

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        ;

        public Builder emailSolicitante(String emailSolicitante) {
            this.emailSolicitante = emailSolicitante;
            return this;
        }

        ;

        public Builder departamento(String departamento) {
            this.departamento = departamento;
            return this;
        }

        ;

        public Builder versaoSistema(String versaoSistema) {
            this.versaoSistema = versaoSistema;
            return this;
        }

        ;

        public Builder anexos(List<String> anexos) {
            this.anexos = new ArrayList<>(anexos);
            return this;
        }

        ;

        public Builder urgente(boolean urgente) {
            this.urgente = urgente;
            return this;
        }

        ;

        public Ticket build() throws Exception {
            if (titulo == null || titulo.isBlank()) throw new Exception("Titulo é obrigatório");
            if (emailSolicitante == null || !emailSolicitante.contains("@")) throw new Exception("Email é obrigatório");
            if (descricao == null || descricao.isBlank()) throw new Exception("Descrição é obrigatório");
            if (numeroTicket <= 0) throw new Exception("Número do ticket deve ser maior que 0");

            return new Ticket(this);
        }

        ;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "numeroTicket=" + numeroTicket +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", emailSolicitante='" + emailSolicitante + '\'' +
                ", departamento='" + departamento + '\'' +
                ", versaoSistema='" + versaoSistema + '\'' +
                ", anexos=" + anexos +
                ", urgente=" + urgente +
                '}';
    }
}
