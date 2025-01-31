package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class CriarAlunoPanel extends JPanel {

    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField cpfField;
    private JTextField pesoField;
    private JTextField alturaField;
    private JButton salvarButton;

    public CriarAlunoPanel() {
        setLayout(new GridLayout(6, 2));

        // Campos do formulário
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();

        JLabel idadeLabel = new JLabel("Idade:");
        idadeField = new JTextField();

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField();

        JLabel pesoLabel = new JLabel("Peso (kg):");
        pesoField = new JTextField();

        JLabel alturaLabel = new JLabel("Altura (m):");
        alturaField = new JTextField();

        salvarButton = new JButton("Salvar");

        // Adiciona os componentes ao painel
        add(nomeLabel);
        add(nomeField);
        add(idadeLabel);
        add(idadeField);
        add(cpfLabel);
        add(cpfField);
        add(pesoLabel);
        add(pesoField);
        add(alturaLabel);
        add(alturaField);
        add(new JLabel()); // Apenas para alinhar o botão
        add(salvarButton);

        // Ação ao clicar no botão de salvar
        salvarButton.addActionListener(e -> salvarAluno());
    }

    private void salvarAluno() {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String cpf = cpfField.getText();
        double peso = Double.parseDouble(pesoField.getText());
        double altura = Double.parseDouble(alturaField.getText());

        // Cria um novo aluno com os dados informados
        Aluno aluno = new Aluno(nome, idade, cpf, peso, altura);

        // Adiciona o aluno no sistema (exemplo)
        GerenciadorAlunos.cadastrarAluno(aluno);

        // Exibe mensagem de confirmação
        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
    }
}
