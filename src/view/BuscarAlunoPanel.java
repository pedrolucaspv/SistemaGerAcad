package view;

import model.GerenciadorAlunos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BuscarAlunoPanel extends JPanel {
    private JTextField instrutorField;
    private JTextField academiaField;
    private JTextArea resultadoArea;
    private GerenciadorAlunos gerenciadorAlunos;

    public BuscarAlunoPanel(GerenciadorAlunos gerenciadorAlunos) {
        this.gerenciadorAlunos = gerenciadorAlunos;
        setLayout(new BorderLayout());

        JPanel buscaPanel = new JPanel(new GridLayout(3, 2));

        JLabel instrutorLabel = new JLabel("Buscar por Instrutor:");
        instrutorField = new JTextField();

        JLabel academiaLabel = new JLabel("Buscar por Academia:");
        academiaField = new JTextField();

        JButton buscarInstrutorButton = new JButton("Buscar Instrutor");
        JButton buscarAcademiaButton = new JButton("Buscar Academia");

        // Área para mostrar os resultados
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);

        buscaPanel.add(instrutorLabel);
        buscaPanel.add(instrutorField);
        buscaPanel.add(buscarInstrutorButton);
        buscaPanel.add(academiaLabel);
        buscaPanel.add(academiaField);
        buscaPanel.add(buscarAcademiaButton);

        add(buscaPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Ações dos botões
        buscarInstrutorButton.addActionListener((ActionEvent e) -> buscarPorInstrutor());
        buscarAcademiaButton.addActionListener((ActionEvent e) -> buscarPorAcademia());
    }

    private void buscarPorInstrutor() {
        String nomeInstrutor = instrutorField.getText();
        resultadoArea.setText("Resultados para o Instrutor " + nomeInstrutor + ":\n");
        resultadoArea.append(gerenciadorAlunos.buscarAlunosPorInstrutor(nomeInstrutor));
    }

    private void buscarPorAcademia() {
        String nomeAcademia = academiaField.getText();
        resultadoArea.setText("Resultados para a Academia " + nomeAcademia + ":\n");
        resultadoArea.append(gerenciadorAlunos.buscarAlunosPorAcademia(nomeAcademia));
    }
}
