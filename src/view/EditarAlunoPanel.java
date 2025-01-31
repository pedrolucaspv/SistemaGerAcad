package view;

import model.Aluno;
import model.GerenciadorAlunos;
import model.Instrutor;
import model.GerenciadorInstrutores;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EditarAlunoPanel extends JPanel {

    private JComboBox<String> alunoComboBox;
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField cpfField;
    private JTextField pesoField;
    private JTextField alturaField;
    private JComboBox<String> instrutorComboBox;
    private JButton salvarButton;

    public EditarAlunoPanel() {
        setLayout(new GridLayout(8, 2));

        // Seleção de aluno
        JLabel alunoLabel = new JLabel("Selecionar Aluno:");
        alunoComboBox = new JComboBox<>();
        carregarAlunos();

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

        // Seleção de instrutor
        JLabel instrutorLabel = new JLabel("Selecionar Instrutor:");
        instrutorComboBox = new JComboBox<>();
        carregarInstrutores();

        salvarButton = new JButton("Salvar");

        // Adiciona os componentes ao painel
        add(alunoLabel);
        add(alunoComboBox);
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
        add(instrutorLabel);
        add(instrutorComboBox);
        add(new JLabel()); // Para alinhar o botão
        add(salvarButton);

        // Ação ao selecionar um aluno para preencher os campos
        alunoComboBox.addActionListener(e -> preencherCampos());

        // Ação ao clicar no botão de salvar
        salvarButton.addActionListener(e -> salvarAlteracoes());
    }

    private void carregarAlunos() {
        // Carrega os nomes dos alunos cadastrados no GerenciadorAlunos
        List<Aluno> alunos = GerenciadorAlunos.getListaAlunos();
        alunoComboBox.removeAllItems();
        for (Aluno aluno : alunos) {
            alunoComboBox.addItem(aluno.getNome());
        }
    }

    private void carregarInstrutores() {
        // Carrega os instrutores disponíveis (essa parte pode ser adaptada ao seu sistema)
        List<Instrutor> instrutores = GerenciadorInstrutores.getInstrutores();
        instrutorComboBox.removeAllItems();
        instrutorComboBox.addItem("Nenhum");
        for (Instrutor instrutor : instrutores) {
            instrutorComboBox.addItem(instrutor.getNome());
        }
    }

    private void preencherCampos() {
        // Preenche os campos com as informações do aluno selecionado
        String nomeSelecionado = (String) alunoComboBox.getSelectedItem();
        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeSelecionado);

        if (aluno != null) {
            nomeField.setText(aluno.getNome());
            idadeField.setText(String.valueOf(aluno.getIdade()));
            cpfField.setText(aluno.getCpf());
            pesoField.setText(String.valueOf(aluno.getPeso()));
            alturaField.setText(String.valueOf(aluno.getAltura()));
        }
    }

    private void salvarAlteracoes() {
        // Pega as informações dos campos e atualiza o aluno
        String nomeSelecionado = (String) alunoComboBox.getSelectedItem();
        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeSelecionado);

        if (aluno != null) {
            aluno.setNome(nomeField.getText());
            aluno.setIdade(Integer.parseInt(idadeField.getText()));
            aluno.setCpf(cpfField.getText());
            aluno.setPeso(Double.parseDouble(pesoField.getText()));
            aluno.setAltura(Double.parseDouble(alturaField.getText()));

            // Associa um instrutor, se houver um selecionado
            String instrutorSelecionado = (String) instrutorComboBox.getSelectedItem();
            if (!instrutorSelecionado.equals("Nenhum")) {
                Instrutor instrutor = GerenciadorInstrutores.buscarInstrutorPorNome(instrutorSelecionado);
                aluno.setPersonal(instrutor);
            } else {
                aluno.setPersonal(null);
            }

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Aluno atualizado com sucesso!");
        }
    }
}
