package view;
import java.awt.*;
import javax.swing.*;
import model.*;

class CriarExercicioPanel extends JPanel {
    private JTextField nomeExercicioField;
    private JTextField tipoField;
    private JTextField musculosEnvolvidosField;

    public CriarExercicioPanel() {
        setLayout(new GridLayout(4, 2));

        // Campos para criação de exercício
        add(new JLabel("Nome do Exercício:"));
        nomeExercicioField = new JTextField();
        add(nomeExercicioField);

        add(new JLabel("Descrição:"));
        tipoField = new JTextField();
        add(tipoField);

        add(new JLabel("Duração:"));
        musculosEnvolvidosField = new JTextField();
        add(musculosEnvolvidosField);

        // Botão para criar exercício
        JButton criarButton = new JButton("Criar Exercício");
        criarButton.addActionListener(e -> criarExercicio());
        add(criarButton);
    }

    private void criarExercicio() {
        // Pega os valores dos campos
        String nome = nomeExercicioField.getText();
        String descricao = tipoField.getText();
        String duracao = musculosEnvolvidosField.getText();

        // Cria um novo objeto Exercício (conecte ao sistema ou banco de dados)
        Exercicio novoExercicio = new Exercicio(nome, descricao, duracao);

        // Exibe uma mensagem de confirmação
        JOptionPane.showMessageDialog(this, "Exercício " + nome + " criado com sucesso!");

        // Limpa os campos
        nomeExercicioField.setText("");
        tipoField.setText("");
        musculosEnvolvidosField.setText("");
    }
}

