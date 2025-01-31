package view3;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarAlunoPanel extends JPanel {

    private static JComboBox<Aluno> comboBoxAlunos;
    private JTextField nomeField, idadeField, cpfField, pesoField, alturaField;
    private static JComboBox<Instrutor> comboBoxInstrutores;
    private static JComboBox<Academia> comboBoxAcademias;
    private static JComboBox<PlanoTreino> comboBoxPlanos;

    public EditarAlunoPanel() {
        setLayout(new GridLayout(10, 2));

        // Inicializando os componentes do painel
        comboBoxAlunos = new JComboBox<>();
        atualizarComboBoxAlunos(); // Atualiza a lista de alunos no comboBox

        nomeField = new JTextField();
        idadeField = new JTextField();
        cpfField = new JTextField();
        pesoField = new JTextField();
        alturaField = new JTextField();

        comboBoxInstrutores = new JComboBox<>();
        comboBoxAcademias = new JComboBox<>();
        comboBoxPlanos = new JComboBox<>();

        // Adicionando os componentes ao painel
        add(new JLabel("Selecione o Aluno:"));
        add(comboBoxAlunos);
        add(new JLabel("Nome:"));
        add(nomeField);
        add(new JLabel("Idade:"));
        add(idadeField);
        add(new JLabel("CPF:"));
        add(cpfField);
        add(new JLabel("Peso:"));
        add(pesoField);
        add(new JLabel("Altura:"));
        add(alturaField);
        add(new JLabel("Instrutor:"));
        add(comboBoxInstrutores);
        add(new JLabel("Academia:"));
        add(comboBoxAcademias);
        add(new JLabel("Plano de Treino:"));
        add(comboBoxPlanos);

        // Botão para salvar as alterações
        JButton salvarButton = new JButton("Salvar Alterações");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });
        add(salvarButton);

        // Atualizar os campos ao selecionar um aluno
        comboBoxAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
                if (alunoSelecionado != null) {
                    atualizarCamposAluno(alunoSelecionado);
                }
            }

        });



        initComponents();
        atualizarComboBoxInstrutores();
        atualizarComboBoxAcademia();
        atualizarComboBoxPlanoTreino();
        atualizarComboBoxAlunos();
    }


    public static void atualizarComboBoxPlanoTreino() {
        comboBoxPlanos.removeAllItems();
        for (PlanoTreino planoTreino : GerenciadorPlanoTreino.getListaPlanosTreino()) {
            comboBoxPlanos.addItem(planoTreino);
        }
    }

    private void initComponents() {
    }

    // Método para atualizar a lista de alunos no comboBox
    public static void atualizarComboBoxAlunos() {
        comboBoxAlunos.removeAllItems();
        for (Aluno aluno : GerenciadorAlunos.getListaAlunos()) {
            comboBoxAlunos.addItem(aluno);
        }
    }

    public static void atualizarComboBoxInstrutores() {
        comboBoxInstrutores.removeAllItems();
        for (Instrutor instrutor : GerenciadorInstrutores.getInstrutores()) {
            comboBoxInstrutores.addItem(instrutor);
        }
    }

    public static void atualizarComboBoxAcademia() {
        comboBoxAcademias.removeAllItems();
        for (Academia academia : GerenciadorAcademias.getListaAcademias()) {
            comboBoxAcademias.addItem(academia);
        }
    }

    // Método para atualizar os campos com as informações do aluno selecionado
    private void atualizarCamposAluno(Aluno aluno) {
        nomeField.setText(aluno.getNome());
        idadeField.setText(String.valueOf(aluno.getIdade()));
        cpfField.setText(aluno.getCpf());
        pesoField.setText(String.valueOf(aluno.getPeso()));
        alturaField.setText(String.valueOf(aluno.getAltura()));

        // Seleciona o instrutor, academia e plano de treino atuais
        comboBoxInstrutores.setSelectedItem(aluno.getPersonal());
        comboBoxAcademias.setSelectedItem(aluno.getAcademia());
        comboBoxPlanos.setSelectedItem(aluno.getPlanosTreino());
    }

    // Método para salvar as alterações feitas no aluno
    private void salvarAlteracoes() {
        Aluno alunoSelecionado = (Aluno) comboBoxAlunos.getSelectedItem();
        if (alunoSelecionado != null) {
            alunoSelecionado.setNome(nomeField.getText());
            alunoSelecionado.setIdade(Integer.parseInt(idadeField.getText()));
            alunoSelecionado.setCpf(cpfField.getText());
            alunoSelecionado.setPeso(Double.parseDouble(pesoField.getText()));
            alunoSelecionado.setAltura(Double.parseDouble(alturaField.getText()));

            // Atualiza instrutor, academia e plano de treino conforme o que for selecionado
            alunoSelecionado.setPersonal((Instrutor) comboBoxInstrutores.getSelectedItem());
            alunoSelecionado.setAcademia((Academia) comboBoxAcademias.getSelectedItem());
            alunoSelecionado.setPlanoTreino((PlanoTreino) comboBoxPlanos.getSelectedItem());

            JOptionPane.showMessageDialog(this, "Alterações salvas com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum aluno selecionado.");
        }
    }
}
