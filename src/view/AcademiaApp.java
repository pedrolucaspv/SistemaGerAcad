package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class AcademiaApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private GerenciadorAlunos gerenciadorAlunos; // Gerenciador para controlar alunos
    private GerenciadorInstrutores gerenciadorInstrutores; // Gerenciador para controlar instrutores

    public AcademiaApp() {
        gerenciadorAlunos = new GerenciadorAlunos(); // Instância do GerenciadorAlunos
        gerenciadorInstrutores = new GerenciadorInstrutores();
        // Instância do gerenciador já criada em AcademiaApp

// Instância do GerenciadorInstrutores

        setTitle("Sistema de Gerenciamento de Academia");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAluno = new JMenu("Alunos");
        JMenu menuInstrutor = new JMenu("Instrutores");
        JMenu menuExercicio = new JMenu("Exercícios");
        JMenu menuPlanoTreino = new JMenu("Planos de Treino");

        JMenuItem itemCriarAluno = new JMenuItem("Criar Aluno");
        JMenuItem itemEditarAluno = new JMenuItem("Editar Aluno");
        JMenuItem itemBuscarAluno = new JMenuItem("Buscar Aluno"); // Novo item para buscar alunos
        JMenuItem itemCriarInstrutor = new JMenuItem("Criar Instrutor");
        JMenuItem itemCriarExercicio = new JMenuItem("Criar Exercício");
        JMenuItem itemCriarPlano = new JMenuItem("Criar Plano de Treino");

        // Adicionando itens aos menus
        menuAluno.add(itemCriarAluno);
        menuAluno.add(itemEditarAluno);
        menuAluno.add(itemBuscarAluno); // Adicionando item de busca ao menu Aluno
        menuInstrutor.add(itemCriarInstrutor);
        menuExercicio.add(itemCriarExercicio);
        menuPlanoTreino.add(itemCriarPlano);

        // Adicionando menus à barra
        menuBar.add(menuAluno);
        menuBar.add(menuInstrutor);
        menuBar.add(menuExercicio);
        menuBar.add(menuPlanoTreino);
        setJMenuBar(menuBar);

        // Painel principal com CardLayout para alternar entre diferentes telas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Painéis individuais
        JPanel criarAlunoPanel = new CriarAlunoPanel();
        JPanel editarAlunoPanel = new EditarAlunoPanel();
        JPanel buscarAlunoPanel = new BuscarAlunoPanel(gerenciadorAlunos); // Novo painel para busca de alunos
        JPanel criarInstrutorPanel = new CriarInstrutorPanel(); // Passando gerenciador de instrutores
        JPanel criarExercicioPanel = new CriarExercicioPanel();
        JPanel criarPlanoPanel = new CriarPlanoTreinoPanel();

        // Adiciona as telas ao painel principal
        mainPanel.add(criarAlunoPanel, "Criar Aluno");
        mainPanel.add(editarAlunoPanel, "Editar Aluno");
        mainPanel.add(buscarAlunoPanel, "Buscar Aluno"); // Adiciona o painel de busca ao card layout
        mainPanel.add(criarInstrutorPanel, "Criar Instrutor"); // Painel de criação de instrutores
        mainPanel.add(criarExercicioPanel, "Criar Exercicio");
        mainPanel.add(criarPlanoPanel, "Criar Plano");

        // Ações dos itens de menu
        itemCriarAluno.addActionListener(e -> cardLayout.show(mainPanel, "Criar Aluno"));
        itemEditarAluno.addActionListener(e -> cardLayout.show(mainPanel, "Editar Aluno"));
        itemBuscarAluno.addActionListener(e -> cardLayout.show(mainPanel, "Buscar Aluno")); // Nova ação para buscar alunos
        itemCriarInstrutor.addActionListener(e -> cardLayout.show(mainPanel, "Criar Instrutor"));
        itemCriarExercicio.addActionListener(e -> cardLayout.show(mainPanel, "Criar Exercicio"));
        itemCriarPlano.addActionListener(e -> cardLayout.show(mainPanel, "Criar Plano"));

        add(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AcademiaApp();
    }
}
