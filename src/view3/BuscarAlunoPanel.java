package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarAlunoPanel extends JPanel {

    private JTextField nomeField;
    private JTextArea resultadoArea;

    public BuscarAlunoPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Nome do Aluno:"));
        nomeField = new JTextField();
        inputPanel.add(nomeField);

        JButton btnBuscar = new JButton("Buscar Aluno");
        inputPanel.add(btnBuscar);

        add(inputPanel, BorderLayout.NORTH);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                Aluno alunoEncontrado = GerenciadorAlunos.buscarAlunoPorNome(nome);

                if (alunoEncontrado != null) {
                    String academiaInfo = (alunoEncontrado.getAcademia() != null) ?
                            alunoEncontrado.getAcademia().getNome() : "Nenhuma academia associada";
                    String instrutorInfo = (alunoEncontrado.getPersonal() != null) ?
                            alunoEncontrado.getPersonal().getNome() : "Nenhum instrutor associado";

                    resultadoArea.setText("Nome: " + alunoEncontrado.getNome() + "\n" +
                            "CPF: " + alunoEncontrado.getCpf() + "\n" +
                            "Idade: " + alunoEncontrado.getIdade() + "\n" +
                            "Peso: " + alunoEncontrado.getPeso() + "\n" +
                            "Altura: " + alunoEncontrado.getAltura() + "\n" +
                            "Academia: " + academiaInfo + "\n" +
                            "Instrutor: " + instrutorInfo);
                } else {
                    resultadoArea.setText("Aluno não encontrado.");
                }
            }
        });
    }
}
