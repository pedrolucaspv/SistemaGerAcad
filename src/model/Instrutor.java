package model;


public class Instrutor extends Pessoa implements Exibivel {
    protected String especialidade;
    protected Academia academia;

    public Instrutor(String nome, int idade, String cpf, String especialidade) {
        super(nome, idade, cpf);
        this.especialidade = especialidade;
    }

    public void adicionarAcademia(Academia academia) {
        this.academia = academia;
    }

    @Override
    public String toString() {
        return this.getNome(); // ou "Instrutor: " + nome
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }





    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Especialidade: " + especialidade);
        System.out.println("Academia: " + academia);
        System.out.println("Lista de Alunos:");
    }
}

