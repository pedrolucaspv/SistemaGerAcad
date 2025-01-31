package view3;

import model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarPlanoTreinoPanel extends JPanel {
    private JTextField nomeField;
    private JTextField exercicioNomeField, exercicioDescricaoField, exercicioDuracaoField;
    private PlanoTreino planoTreino;
    private JComboBox<PlanoTreino> comboBoxPlanos; // ComboBox para selecionar o plano de treino

    public CriarPlanoTreinoPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout

        // Campos para o nome do plano
        add(new JLabel("Nome do Plano:"));
        nomeField = new JTextField();
        add(nomeField);

        JButton btnCriarPlano = new JButton("Criar Plano");
        add(btnCriarPlano);

        // ComboBox para selecionar o plano de treino
        add(new JLabel("Selecione o Plano de Treino:"));
        comboBoxPlanos = new JComboBox<>();
        atualizarComboBoxPlanos();
        add(comboBoxPlanos);

        // Campos para o exercício
        add(new JLabel("Nome do Exercício:"));
        exercicioNomeField = new JTextField();
        add(exercicioNomeField);

        add(new JLabel("Descrição do Exercício:"));
        exercicioDescricaoField = new JTextField();
        add(exercicioDescricaoField);

        add(new JLabel("Duração (minutos):"));
        exercicioDuracaoField = new JTextField();
        add(exercicioDuracaoField);

        JButton btnAdicionarExercicio = new JButton("Adicionar Exercício");
        add(btnAdicionarExercicio);

        // Ações dos botões
        btnCriarPlano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planoTreino = new PlanoTreino(nomeField.getText());
                GerenciadorPlanoTreino.cadastrarPlanoTreino(planoTreino);
                atualizarComboBoxPlanos(); // Atualiza a lista de planos no ComboBox
                JOptionPane.showMessageDialog(null, "Plano de treino criado com sucesso!");
            }
        });

        btnAdicionarExercicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlanoTreino planoSelecionado = (PlanoTreino) comboBoxPlanos.getSelectedItem();
                if (planoSelecionado != null) {
                    Exercicio exercicio = new Exercicio(
                            exercicioNomeField.getText(),
                            exercicioDescricaoField.getText(),
                            exercicioDuracaoField.getText()
                    );
                    planoSelecionado.adicionarExercicio(exercicio);
                    JOptionPane.showMessageDialog(null, "Exercício adicionado ao plano de treino.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um plano de treino antes de adicionar exercícios.");
                }
            }
        });
        EditarAlunoPanel.atualizarComboBoxPlanoTreino();
    }

    // Método para atualizar a ComboBox de planos de treino
    private void atualizarComboBoxPlanos() {
        comboBoxPlanos.removeAllItems(); // Limpa a ComboBox antes de adicionar novos itens
        for (PlanoTreino plano : GerenciadorPlanoTreino.getListaPlanosTreino()) {
            comboBoxPlanos.addItem(plano); // Adiciona os planos de treino existentes ao ComboBox
        }
    }
}
