package view3;

import model.*;
import javax.swing.*;
import java.awt.*;

public class CriarAlunoPanel extends JPanel {
    private JTextField nomeField, cpfField, idadeField, pesoField, alturaField;

    public CriarAlunoPanel() {
        setLayout(new GridLayout(6, 2));

        // Labels and text fields
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        add(new JLabel("Peso:"));
        pesoField = new JTextField();
        add(pesoField);

        add(new JLabel("Altura:"));
        alturaField = new JTextField();
        add(alturaField);

        // Botão de Criar Aluno
        JButton criarButton = new JButton("Criar Aluno");
        criarButton.addActionListener(e -> criarAluno());
        add(criarButton);
    }

    private void criarAluno() {
        // Pegando os dados do formulário
        String nome = nomeField.getText();
        String cpf = cpfField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        double peso = Double.parseDouble(pesoField.getText());
        double altura = Double.parseDouble(alturaField.getText());

        // Criando o objeto Aluno
        Aluno novoAluno = new Aluno(nome, idade, cpf, peso, altura);
        GerenciadorAlunos.cadastrarAluno(novoAluno);
        EditarAlunoPanel.atualizarComboBoxAlunos();
        VisualizarPlanoTreinoPanel.atualizarComboBoxAlunos();

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }


}
