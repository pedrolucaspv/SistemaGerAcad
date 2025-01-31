package view3;

import model.Academia;
import model.GerenciadorAcademias;

import javax.swing.*;
import java.awt.*;

public class CriarAcademiaPanel extends JPanel {

    // Campos de entrada para criar uma academia
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField numeroInscricaoField;

    public CriarAcademiaPanel() {
        setLayout(new GridLayout(5, 2));

        // Criando os rótulos e campos de texto
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoField = new JTextField(20);

        JLabel numeroInscricaoLabel = new JLabel("Número de Inscrição:");
        numeroInscricaoField = new JTextField(20);

        // Botão para criar academia
        JButton criarAcademiaButton = new JButton("Criar Academia");
        criarAcademiaButton.addActionListener(e -> criarAcademia());

        // Adicionando os componentes ao painel
        add(nomeLabel);
        add(nomeField);

        add(enderecoLabel);
        add(enderecoField);

        add(numeroInscricaoLabel);
        add(numeroInscricaoField);

        // Espaço reservado
        add(new JLabel(""));
        add(criarAcademiaButton);
    }

    // Método para criar uma academia
    private void criarAcademia() {
        // Pegando os dados do formulário
        String nome = nomeField.getText();
        String endereco = enderecoField.getText();
        String numeroInscricao = numeroInscricaoField.getText();

        // Criando o objeto Academia e atualizando lista
        Academia novaAcademia = new Academia(nome, endereco, numeroInscricao);
        GerenciadorAcademias.cadastrarAcademia(novaAcademia);
        EditarAlunoPanel.atualizarComboBoxAcademia();

        // Mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Academia cadastrada com sucesso!");

        // Limpar os campos após o cadastro
        nomeField.setText("");
        enderecoField.setText("");
        numeroInscricaoField.setText("");
    }
}
