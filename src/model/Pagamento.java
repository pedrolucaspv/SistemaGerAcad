package model;

public class Pagamento {
    private double valor;
    private String data; // Data do pagamento
    private String status; // Status (pago, pendente, etc.)

    public Pagamento(double valor, String data) {
        this.valor = valor;
        this.data = data;
        this.status = "pago"; // ou "pendente" se o pagamento não for imediato
    }

    public void exibirStatusPagamento() {
        System.out.println("Valor: R$" + valor + ", Data: " + data + ", Status: " + status);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
