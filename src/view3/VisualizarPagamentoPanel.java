package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarPagamentoPanel extends JPanel {

    private JComboBox<Aluno> comboBoxAlunos;
    private JTextArea pagamentoArea;

    public VisualizarPagamentoPanel() {
        setLayout(new BorderLayout());

        comboBoxAlunos = new JComboBox<>(GerenciadorAlunos.getListaAlunos().toArray(new Aluno[0]));
        add(new JLabel("Selecione o Aluno:"), BorderLayout.NORTH);
        add(comboBoxAlunos, BorderLayout.NORTH);

        pagamentoArea = new JTextArea(10, 30);
        pagamentoArea.setEditable(false);
        add(new JScrollPane(pagamentoArea), BorderLayout.CENTER);

        JButton btnVisualizarPagamentos = new JButton("Visualizar Pagamentos");
        add(btnVisualizarPagamentos, BorderLayout.SOUTH);

        btnVisualizarPagamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
                if (alunoSelecionado != null) {
                    pagamentoArea.setText("Pagamentos de " + alunoSelecionado.getNome() + ":\n\n");
                    for (Pagamento pagamento : alunoSelecionado.getPagamentos()) {
                        pagamentoArea.append("Valor: " + pagamento.getValor() + "\n" +
                                "Data: " + pagamento.getData() + "\n\n");
                    }
                    if (alunoSelecionado.getPagamentos().isEmpty()) {
                        pagamentoArea.setText("Nenhum pagamento realizado.");
                    }
                }
            }
        });
    }
}
