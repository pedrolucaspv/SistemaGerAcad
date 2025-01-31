package model;

public class Exercicio {
    private String nome;
    private String descricao;
    private String duracaoMinutos; // Duração em minutos

    public Exercicio(String nome, String descricao, String duracaoMinutos) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
    }

    public Exercicio(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void exibirExercicio() {
        System.out.println("Exercício: " + nome + ", Duração: " + duracaoMinutos + " min");
        System.out.println("Descrição: " + descricao);
    }
}

