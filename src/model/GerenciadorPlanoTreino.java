package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPlanoTreino {

    private static List<PlanoTreino> listaPlanosTreino = new ArrayList<>();

    // Método para cadastrar um novo plano de treino
    public static void cadastrarPlanoTreino(PlanoTreino plano) {
        listaPlanosTreino.add(plano);
    }

    // Método para buscar um plano de treino pelo nome (opcional)
    public static PlanoTreino buscarPlanoTreinoPorNome(String nome) {
        for (PlanoTreino plano : listaPlanosTreino) {
            if (plano.getNome().equalsIgnoreCase(nome)) {
                return plano;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Método para retornar todos os planos de treino
    public static List<PlanoTreino> getListaPlanosTreino() {
        return listaPlanosTreino;
    }

    // Método para remover um plano de treino (opcional)
    public static void removerPlanoTreino(PlanoTreino plano) {
        listaPlanosTreino.remove(plano);
    }
}
