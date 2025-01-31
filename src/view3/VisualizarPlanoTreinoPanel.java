package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarPlanoTreinoPanel extends JPanel {

    private static JComboBox<Aluno> comboBoxAlunos;
    private JComboBox<PlanoTreino> comboBoxPlanos; // JComboBox para planos
    private JTextArea planoTreinoArea;

    public VisualizarPlanoTreinoPanel() {
        setLayout(new BorderLayout());

        // Inicializa comboBoxAlunos e atualiza sua lista
        comboBoxAlunos = new JComboBox<>();
        atualizarComboBoxAlunos(); // Atualiza a lista de alunos no comboBox

        add(new JLabel("Selecione o Aluno:"), BorderLayout.NORTH);
        add(comboBoxAlunos, BorderLayout.NORTH);

        // JComboBox para selecionar planos
        comboBoxPlanos = new JComboBox<>();
        add(comboBoxPlanos, BorderLayout.NORTH);

        planoTreinoArea = new JTextArea(10, 30);
        planoTreinoArea.setEditable(false);
        add(new JScrollPane(planoTreinoArea), BorderLayout.CENTER);

        JButton btnVisualizarPlano = new JButton("Visualizar Plano de Treino");
        add(btnVisualizarPlano, BorderLayout.SOUTH);

        // Atualizar o JComboBox de planos ao selecionar um aluno
        comboBoxAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
                atualizarComboBoxPlanos(alunoSelecionado);
            }
        });

        btnVisualizarPlano.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
                PlanoTreino planoTreino = (PlanoTreino) comboBoxPlanos.getSelectedItem(); // Obtem o plano selecionado
                if (planoTreino != null) {
                    planoTreinoArea.setText("Plano de Treino: " + planoTreino.getNome() + "\n\n");
                    for (Exercicio exercicio : planoTreino.getExercicios()) {
                        planoTreinoArea.append("Exercício: " + exercicio.getNome() + "\n" +
                                "Descrição: " + exercicio.getDescricao() + "\n" +
                                "Duração: " + exercicio.getDuracaoMinutos() + " minutos\n\n");
                    }
                } else {
                    planoTreinoArea.setText("Nenhum plano de treino associado ao aluno.");
                }
            }
        });
    }

    // Método para atualizar a lista de alunos no comboBox
    public static void atualizarComboBoxAlunos() {
        comboBoxAlunos.removeAllItems(); // Limpa os itens anteriores
        for (Aluno aluno : GerenciadorAlunos.getListaAlunos()) {
            comboBoxAlunos.addItem(aluno); // Adiciona todos os alunos disponíveis
        }
    }

    public void atualizarComboBoxPlanos(Aluno alunoSelecionado) {
        comboBoxPlanos.removeAllItems(); // Limpa os planos anteriores
        if (alunoSelecionado != null && alunoSelecionado.getPlanosTreino() != null) {
            for (PlanoTreino plano : alunoSelecionado.getPlanosTreino()) {
                comboBoxPlanos.addItem(plano); // Adiciona os planos ao JComboBox
            }
        }
    }
}
