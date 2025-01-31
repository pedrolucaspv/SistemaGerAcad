package view3;

import javax.swing.*;
import java.awt.*;
import model.*;

public class MainView extends JFrame {

    private JPanel mainPanel;

    public MainView() {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        GerenciadorInstrutores gerenciadorInstrutores = new GerenciadorInstrutores();

        // Inicializa dados de teste
        inicializaDadosTeste(gerenciadorAlunos, gerenciadorInstrutores);

        // Configurações principais da janela
        configurarJanela();

        // Inicializa os painéis
        inicializaPainéis();

        // Configura e adiciona o menu
        configurarMenu();

        // Adiciona o painel principal ao frame
        add(mainPanel);
        setVisible(true);
    }

    private void inicializaDadosTeste(GerenciadorAlunos gerenciadorAlunos, GerenciadorInstrutores gerenciadorInstrutores) {
        Academia novaAcademia = new Academia("Smart Fit", "Avenida Pelinca, 268", "1");
        Academia novaAcademia2 = new Academia("Academia Gigantes", "Avenida Brasil", "2");
        GerenciadorAcademias gerenciadorAcademias = new GerenciadorAcademias();
        gerenciadorAcademias.cadastrarAcademia(novaAcademia);
        gerenciadorAcademias.cadastrarAcademia(novaAcademia2);
        PlanoTreino peito = new PlanoTreino ("Peito");
        peito.adicionarExercicio(new Exercicio("Supino reto","Barra ou halter", "3x15" ));
        peito.adicionarExercicio(new Exercicio("Supino Inclinado","Barra ou halter", "3x15" ));
        peito.adicionarExercicio(new Exercicio("Supino Declinado","Barra ou halter", "3x15" ));

        GerenciadorPlanoTreino gerenciadorPlanoTreino = new GerenciadorPlanoTreino();
        gerenciadorPlanoTreino.cadastrarPlanoTreino(peito);


        Aluno aluno = new Aluno("Lucas", 33, "98765432100", 61.2, 1.80);
        Instrutor instrutor = new Instrutor("Roberto", 45, "98765432100", "Corrida");

        gerenciadorInstrutores.cadastrarInstrutor(instrutor);
        aluno.adicionarAcademia(novaAcademia);
        gerenciadorAlunos.cadastrarAluno(aluno);
        gerenciadorAlunos.cadastrarAluno(new Aluno("Pedro", 25, "123.456.789-00", 70.0, 1.75));
        gerenciadorAlunos.cadastrarAluno(new Aluno("Maria", 30, "987.654.321-00", 60.0, 1.65));
    }

    private void configurarJanela() {
        setTitle("Gerenciamento de Academia");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel(new CardLayout());
    }

    private void inicializaPainéis() {
        mainPanel.add(new CriarAlunoPanel(), "Criar Aluno");
        mainPanel.add(new EditarAlunoPanel(), "Editar Aluno");
        mainPanel.add(new BuscarAlunoPanel(), "Buscar Aluno");
        mainPanel.add(new CriarInstrutorPanel(), "Criar Instrutor");
        mainPanel.add(new CriarPlanoTreinoPanel(), "Criar Plano Treino");
        mainPanel.add(new VisualizarPlanoTreinoPanel(), "Visualizar Plano Treino");
        mainPanel.add(new RealizarPagamentoPanel(), "Realizar Pagamento");
        mainPanel.add(new VisualizarPagamentoPanel(), "Visualizar Pagamentos");
        mainPanel.add(new CriarAcademiaPanel(), "Criar Academia"); // Novo painel de criar academia
    }

    private void configurarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menus
        JMenu menu = new JMenu("Academia");
        JMenu alunoMenu = new JMenu("Aluno");
        JMenu instrutorMenu = new JMenu("Instrutor");
        JMenu planoTreinoMenu = new JMenu("Plano de Treino");
        JMenu pagamentoMenu = new JMenu("Pagamentos");

        // Itens do menu
        adicionarItemMenu(alunoMenu, "Criar Aluno", "Criar Aluno");
        adicionarItemMenu(alunoMenu, "Editar Aluno", "Editar Aluno");
        adicionarItemMenu(alunoMenu, "Buscar Aluno", "Buscar Aluno");

        adicionarItemMenu(instrutorMenu, "Criar Instrutor", "Criar Instrutor");

        adicionarItemMenu(planoTreinoMenu, "Criar Plano Treino", "Criar Plano Treino");
        adicionarItemMenu(planoTreinoMenu, "Visualizar Plano Treino", "Visualizar Plano Treino");

        adicionarItemMenu(pagamentoMenu, "Realizar Pagamento", "Realizar Pagamento");
        adicionarItemMenu(pagamentoMenu, "Visualizar Pagamentos", "Visualizar Pagamentos");

        JMenuItem criarAcademiaItem = new JMenuItem("Criar Academia");
        criarAcademiaItem.addActionListener(e -> showPanel("Criar Academia"));
        menu.add(criarAcademiaItem); // Adicionando o item ao menu

        // Adiciona menus ao menuBar
        menuBar.add(menu);
        menuBar.add(alunoMenu);
        menuBar.add(instrutorMenu);
        menuBar.add(planoTreinoMenu);
        menuBar.add(pagamentoMenu);

        setJMenuBar(menuBar);
    }

    private void adicionarItemMenu(JMenu menu, String itemName, String panelName) {
        JMenuItem item = new JMenuItem(itemName);
        item.addActionListener(e -> showPanel(panelName));
        menu.add(item);
    }

    private void showPanel(String panelName) {
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, panelName);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
