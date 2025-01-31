package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealizarPagamentoPanel extends JPanel {

    private JComboBox<Aluno> comboBoxAlunos;
    private JTextField valorField, dataField;

    public RealizarPagamentoPanel() {
        setLayout(new GridLayout(4, 2));

        comboBoxAlunos = new JComboBox<>(GerenciadorAlunos.getListaAlunos().toArray(new Aluno[0]));
        add(new JLabel("Selecione o Aluno:"));
        add(comboBoxAlunos);

        add(new JLabel("Valor do Pagamento:"));
        valorField = new JTextField();
        add(valorField);

        add(new JLabel("Data do Pagamento:"));
        dataField = new JTextField();
        add(dataField);

        JButton btnRealizarPagamento = new JButton("Realizar Pagamento");
        add(btnRealizarPagamento);

        btnRealizarPagamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
                if (alunoSelecionado != null) {
                    double valor = Double.parseDouble(valorField.getText());
                    String data = dataField.getText();

                    Pagamento pagamento = new Pagamento(valor, data);
                    alunoSelecionado.adicionarPagamento(pagamento);

                    JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!");
                }
            }
        });
    }
}
