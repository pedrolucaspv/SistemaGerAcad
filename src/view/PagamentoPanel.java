package view;

import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PagamentoPanel extends JPanel {
    private JComboBox<Aluno> alunoComboBox;
    private JTextField valorField;
    private JTextField dataField;
    private JButton realizarPagamentoButton;
    private GerenciadorAlunos gerenciadorAlunos;

    // Ajustar o construtor para receber uma instância de GerenciadorAlunos
    public PagamentoPanel(GerenciadorAlunos gerenciadorAlunos) {
        this.gerenciadorAlunos = gerenciadorAlunos;
        setLayout(new GridLayout(4, 2, 10, 10));

        // Label e combo box para selecionar o aluno
        JLabel alunoLabel = new JLabel("Selecione o Aluno:");
        alunoComboBox = new JComboBox<>(gerenciadorAlunos.getListaAlunos().toArray(new Aluno[0])); // Obter os alunos do gerenciador
        add(alunoLabel);
        add(alunoComboBox);

        // Campo para inserir o valor do pagamento
        JLabel valorLabel = new JLabel("Valor do Pagamento:");
        valorField = new JTextField();
        add(valorLabel);
        add(valorField);

        // Campo para inserir a data do pagamento
        JLabel dataLabel = new JLabel("Data do Pagamento:");
        dataField = new JTextField();
        add(dataLabel);
        add(dataField);

        // Botão para realizar o pagamento
        realizarPagamentoButton = new JButton("Realizar Pagamento");
        realizarPagamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPagamento();
            }
        });
        add(realizarPagamentoButton);
    }

    private void realizarPagamento() {
        Aluno alunoSelecionado = (Aluno) alunoComboBox.getSelectedItem();
        double valor = Double.parseDouble(valorField.getText());
        String data = dataField.getText();

        // Verificar se algum aluno foi selecionado
        if (alunoSelecionado != null) {
            alunoSelecionado.realizarPagamento(valor, data);
            JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um aluno.");
        }

        // Limpar os campos após a realização do pagamento
        valorField.setText("");
        dataField.setText("");
    }
}
