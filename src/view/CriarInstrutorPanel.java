package view;
import model.*;
import javax.swing.*;
import java.awt.*;


class CriarInstrutorPanel extends JPanel {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField cpfField;
    private JTextField especialidadeField;

    public CriarInstrutorPanel() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("Especialidade:"));
        especialidadeField = new JTextField();
        add(especialidadeField);

        JButton criarButton = new JButton("Criar Instrutor");
        criarButton.addActionListener(e -> criarInstrutor());
        add(criarButton);
    }

    private void criarInstrutor() {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String cpf = cpfField.getText();
        String especialidade = especialidadeField.getText();

        Instrutor instrutor = new Instrutor(nome, idade, cpf, especialidade);

        JOptionPane.showMessageDialog(this, "Instrutor " + nome + " criado com sucesso!");

        nomeField.setText("");
        idadeField.setText("");
        cpfField.setText("");
        especialidadeField.setText("");
    }
}

