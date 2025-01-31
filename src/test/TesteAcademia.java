package test;

import model.*;

public class TesteAcademia {
    public static void main(String[] args) {
        // Criando Academias
        Academia academia1 = new Academia("Academia Fitness", "Rua das Flores, 123", "123456789");
        Academia academia2 = new Academia("Academia Saúde", "Avenida Brasil, 456", "987654321");

        GerenciadorAcademias.cadastrarAcademia(academia1);
        GerenciadorAcademias.cadastrarAcademia(academia2);

        // Criando Alunos
        Aluno aluno1 = new Aluno("João", 25, "12345678901", 70.0, 1.75);
        Aluno aluno2 = new Aluno("Maria", 30, "10987654321", 65.0, 1.65);

        GerenciadorAlunos.cadastrarAluno(aluno1);
        GerenciadorAlunos.cadastrarAluno(aluno2);

        // Criando Instrutores
        Instrutor instrutor1 = new Instrutor("Carlos", 35, "12345678901", "Musculação");
        Instrutor instrutor2 = new Instrutor("Ana", 28, "10987654321", "Yoga");

        GerenciadorInstrutores.cadastrarInstrutor(instrutor1);
        GerenciadorInstrutores.cadastrarInstrutor(instrutor2);

        // Associando alunos às academias e instrutores
        aluno1.adicionarAcademia(academia1);
        aluno1.adicionarPersonal(instrutor1);

        aluno2.adicionarAcademia(academia2);
        aluno2.adicionarPersonal(instrutor2);

        // Criando Planos de Treino
        PlanoTreino plano1 = new PlanoTreino("Ganho de Massa");
        PlanoTreino plano2 = new PlanoTreino("Perda de Peso");

        // Criando Exercícios
        Exercicio exercicio1 = new Exercicio("Supino", "Exercício para peito", "30");
        Exercicio exercicio2 = new Exercicio("Agachamento", "Exercício para pernas", "45");

        // Adicionando exercícios aos planos
        plano1.adicionarExercicio(exercicio1);
        plano2.adicionarExercicio(exercicio2);

        // Cadastrando Planos de Treino
        GerenciadorPlanoTreino.cadastrarPlanoTreino(plano1);
        GerenciadorPlanoTreino.cadastrarPlanoTreino(plano2);

        // Adicionando Planos de Treino aos alunos
        aluno1.adicionarPlanoTreino(plano1);
        aluno2.adicionarPlanoTreino(plano2);

        // Realizando Pagamentos
        aluno1.realizarPagamento(150.0, "01/10/2024");
        aluno2.realizarPagamento(120.0, "02/10/2024");

        // Adicionando Avaliação Física
        AvaliacaoFisica avaliacao1 = new AvaliacaoFisica(70.0, 15.0, 7);
        AvaliacaoFisica avaliacao2 = new AvaliacaoFisica(65.0, 20.0, 6);

        aluno1.adicionarAvaliacaoFisica(avaliacao1);
        aluno2.adicionarAvaliacaoFisica(avaliacao2);

        // Exibindo dados
        System.out.println("Dados do Aluno 1:");
        aluno1.exibirDados();
        System.out.println("\nDados do Aluno 2:");
        aluno2.exibirDados();

        // Buscando alunos por instrutor
        GerenciadorAlunos.buscarAlunosPorInstrutor("Carlos");
        GerenciadorAlunos.buscarAlunosPorAcademia("Academia Fitness");
    }
}
