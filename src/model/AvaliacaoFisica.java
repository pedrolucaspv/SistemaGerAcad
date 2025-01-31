package model;

public class AvaliacaoFisica {
    private double pesoAtual;
    private double percentualGordura;
    private int nivelForca; // Nível de força numa escala de 1 a 10
    private double pesoAnterior;

    public AvaliacaoFisica(double pesoAtual, double percentualGordura, int nivelForca) {
        this.pesoAtual = pesoAtual;
        this.percentualGordura = percentualGordura;
        this.nivelForca = nivelForca;
        this.pesoAnterior = pesoAtual; // Inicialmente, peso anterior é igual ao atual
    }

    public void atualizarAvaliacao(double novoPeso, double novoPercentualGordura, int novoNivelForca) {
        this.pesoAnterior = this.pesoAtual;
        this.pesoAtual = novoPeso;
        this.percentualGordura = novoPercentualGordura;
        this.nivelForca = novoNivelForca;
    }

    public void exibirAvaliacao() {
        System.out.println("Peso Atual: " + pesoAtual + " kg, Percentual de Gordura: " + percentualGordura + "%, Nível de Força: " + nivelForca);
        System.out.println("Peso Anterior: " + pesoAnterior + " kg");
    }
}

