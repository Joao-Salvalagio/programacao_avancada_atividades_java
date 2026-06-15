package br.com.ticketcode.adapter;

public class SistemaEmailFornecedor {

    public void enviarMensagem(String destinatario, String assunto, String corpo) {
        System.out.println("[EMAIL FORNECEDOR] Para: " + destinatario);
        System.out.println("[EMAIL FORNECEDOR] Assunto: " + assunto);
        System.out.println("[EMAIL FORNECEDOR] Corpo: " + corpo);
    }

    public void enviarAlerta(String destinatario, String codigoAlerta, String detalhe) {
        System.out.println("[EMAIL FORNECEDOR] ALERTA " + codigoAlerta
                + " para " + destinatario + ": " + detalhe);
    }
}
