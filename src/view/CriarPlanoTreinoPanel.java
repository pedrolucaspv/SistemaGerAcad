package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import model.*;

public class CriarPlanoTreinoPanel extends JPanel {

    private JTextField nomePlanoField;
    private DefaultListModel<Exercicio> listaExerciciosModel;
    private JTextArea listaExerciciosArea;

    public CriarPlanoTreinoPanel() {
        setLayout(new BorderLayout());

        // Campo para nome do plano
        nomePlanoField = new JTextField(20);
        JPanel nomePanel = new JPanel();
        nomePanel.add(new JLabel("Nome do Plano de Treino:"));
        nomePanel.add(nomePlanoField);

        // Lista de exercícios
        listaExerciciosModel = new DefaultListModel<>();
        JList<Exercicio> listaExercicios = new JList<>(listaExerciciosModel);
        listaExerciciosArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(listaExerciciosArea);

        // Botão para adicionar exercício
        JButton adicionarExercicioButton = new JButton("Adicionar Exercício");
        adicionarExercicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarExercicio();
            }
        });

        // Botão para criar plano de treino
        JButton criarPlanoButton = new JButton("Criar Plano de Treino");
        criarPlanoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarPlanoTreino();
            }
        });

        // Adicionando componentes ao painel
        add(nomePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(adicionarExercicioButton, BorderLayout.WEST);
        add(criarPlanoButton, BorderLayout.SOUTH);
    }

    private void adicionarExercicio() {
        String nomeExercicio = JOptionPane.showInputDialog(this, "Nome do Exercício:");
        String descricaoExercicio = JOptionPane.showInputDialog(this, "Descrição do Exercício:");
        String duracaoExercicio = JOptionPane.showInputDialog(this, "Duração (minutos):");

        if (nomeExercicio != null && descricaoExercicio != null && duracaoExercicio != null) {
            Exercicio novoExercicio = new Exercicio(nomeExercicio, descricaoExercicio, duracaoExercicio);
            listaExerciciosModel.addElement(novoExercicio);
            listaExerciciosArea.append(novoExercicio.getNome() + "\n");
        } else {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos para adicionar o exercício.");
        }
    }

    private void criarPlanoTreino() {
        // Pega o nome do plano
        String nomePlano = nomePlanoField.getText();

        // Cria uma lista de exercícios a partir do DefaultListModel
        List<Exercicio> listaExercicios = new ArrayList<>();
        Enumeration<Exercicio> exerciciosEnumeration = listaExerciciosModel.elements();

        // Adiciona os elementos do Enumeration na ArrayList
        while (exerciciosEnumeration.hasMoreElements()) {
            listaExercicios.add(exerciciosEnumeration.nextElement());
        }

        // Cria um novo plano de treino (conecte ao sistema ou banco de dados)
        PlanoTreino plano = new PlanoTreino(nomePlano);
        for (Exercicio exercicio : listaExercicios) {
            plano.adicionarExercicio(exercicio);
        }

        JOptionPane.showMessageDialog(this, "Plano de Treino " + nomePlano + " criado com sucesso!");

        // Limpa os campos
        nomePlanoField.setText("");
        listaExerciciosModel.clear();
        listaExerciciosArea.setText("");
    }
}
