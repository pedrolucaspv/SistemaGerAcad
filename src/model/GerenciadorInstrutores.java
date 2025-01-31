package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorInstrutores {

    private static List<Instrutor> instrutores = new ArrayList<>();

    public static void cadastrarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public static Instrutor buscarInstrutorPorNome(String nome) {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getNome().equalsIgnoreCase(nome)) {
                return instrutor;
            }
        }
        return null;
    }

    public static List<Instrutor> getInstrutores() {
        return instrutores;
    }
}
