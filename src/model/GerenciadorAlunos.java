package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlunos {
    private static List<Aluno> listaAlunos = new ArrayList<>();



    // Método para cadastrar um aluno
    public static void cadastrarAluno(Aluno aluno) {
        listaAlunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso!");
    }

    // Método para buscar alunos pelo nome do instrutor
    public static String buscarAlunosPorInstrutor(String nomeInstrutor) {
        System.out.println("Buscando alunos com instrutor " + nomeInstrutor + ":");
        boolean encontrado = false;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getPersonal() != null && aluno.getPersonal().getNome().equalsIgnoreCase(nomeInstrutor)) {
                System.out.println("- " + aluno.getNome());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aluno encontrado para o instrutor " + nomeInstrutor + ".");
        }
        return nomeInstrutor;
    }

    // Método para buscar alunos pelo nome da academia
    public static String buscarAlunosPorAcademia(String nomeAcademia) {
        System.out.println("Buscando alunos da academia " + nomeAcademia + ":");
        boolean encontrado = false;
        for (Aluno aluno : listaAlunos) {
            if (aluno.getAcademia() != null && aluno.getAcademia().getNome().equalsIgnoreCase(nomeAcademia)) {
                System.out.println("- " + aluno.getNome());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum aluno encontrado para a academia " + nomeAcademia + ".");
        }
        return nomeAcademia;
    }

    public static List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static Aluno buscarAlunoPorNome(String nome) {
        for (Aluno aluno : getListaAlunos()) {
            if (aluno.getNome().equalsIgnoreCase(nome)) { // Comparação de nome ignorando maiúsculas/minúsculas
                return aluno;
            }
        }
        return null; // Retorna null caso o aluno não seja encontrado
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
