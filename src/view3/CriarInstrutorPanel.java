package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarInstrutorPanel extends JPanel {

    private JTextField nomeField, cpfField, idadeField, especialidadeField;

    public CriarInstrutorPanel() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("CPF:"));
        cpfField = new JTextField();
        add(cpfField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        add(new JLabel("Especialidade:"));
        especialidadeField = new JTextField();
        add(especialidadeField);

        JButton btnCriarInstrutor = new JButton("Criar Instrutor");
        add(btnCriarInstrutor);

        btnCriarInstrutor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                int idade = Integer.parseInt(idadeField.getText());
                String especialidade = especialidadeField.getText();

                Instrutor instrutor = new Instrutor(nome, idade, cpf, especialidade);
                GerenciadorInstrutores.cadastrarInstrutor(instrutor);
                EditarAlunoPanel.atualizarComboBoxInstrutores();

                JOptionPane.showMessageDialog(null, "Instrutor cadastrado com sucesso!");
            }
        });
    }
}
