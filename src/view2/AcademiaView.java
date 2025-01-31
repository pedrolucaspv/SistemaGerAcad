//package view2;
//
//import model.*;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AcademiaView {
//
//    private static GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
//    private static GerenciadorInstrutores gerenciadorInstrutores = new GerenciadorInstrutores();
//
//    public static void main(String[] args) {
//        inicializarDados();
//        String[] opcoes = {
//                "Criar Aluno",
//                "Editar Aluno",
//                "Buscar Aluno",
//                "Criar Instrutor",
//                "Criar Plano de Treino",
//                "Visualizar Plano de Treino",
//                "Realizar Pagamento",
//                "Visualizar Pagamentos",
//                "Sair"
//        };
//
//        boolean executar = true;
//        while (executar) {
//            String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Academia",
//                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
//
//            if (escolha == null || escolha.equals("Sair")) {
//                executar = false;
//            } else {
//                switch (escolha) {
//                    case "Criar Aluno":
//                        criarAluno();
//                        break;
//                    case "Editar Aluno":
//                        editarAluno();
//                        break;
//                    case "Buscar Aluno":
//                        buscarAluno();
//                        break;
//                    case "Criar Instrutor":
//                        criarInstrutor();
//                        break;
//                    case "Criar Plano de Treino":
//                        criarPlanoTreino();
//                        break;
//                    case "Visualizar Plano de Treino":
//                        visualizarPlanoTreino();
//                        break;
//                    case "Realizar Pagamento":
//                        realizarPagamento();
//                        break;
//                    case "Visualizar Pagamentos":
//                        visualizarPagamentos();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//    }
//
//    // Função para inicializar alguns dados de exemplo
//    private static void inicializarDados() {
//        // Adicionando alguns instrutores e academias
//        Instrutor instrutor1 = new Instrutor("Carlos Silva", 35, "123.456.789-00", "Musculação");
//        Academia academia1 = new Academia("Academia BodyFit", "bla bla", "15");
//        gerenciadorInstrutores.cadastrarInstrutor(instrutor1);
//
//        // Adicionando alguns alunos de exemplo
//        Aluno aluno1 = new Aluno("João Souza", 25, "111.222.333-44", 70, 1.75);
//        aluno1.adicionarPersonal(instrutor1);
//        aluno1.adicionarAcademia(academia1);
//        gerenciadorAlunos.cadastrarAluno(aluno1);
//    }
//
//    // Criar Aluno
//    private static void criarAluno() {
//        String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
//        String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno:");
//        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno:"));
//        double peso = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso do aluno:"));
//        double altura = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura do aluno:"));
//
//        Aluno novoAluno = new Aluno(nome, idade, cpf, peso, altura);
//        GerenciadorAlunos.cadastrarAluno(novoAluno);
//    }
//
//    // Editar Aluno
//    private static void editarAluno() {
//        List<Aluno> alunos = GerenciadorAlunos.getListaAlunos();
//        if (alunos.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado.");
//            return;
//        }
//
//        String[] nomesAlunos = alunos.stream().map(Aluno::getNome).toArray(String[]::new);
//        String nomeSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o aluno para editar:",
//                "Editar Aluno", JOptionPane.PLAIN_MESSAGE, null, nomesAlunos, nomesAlunos[0]);
//
//        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeSelecionado);
//        if (aluno == null) return;
//
//        String novoNome = JOptionPane.showInputDialog("Editar nome:", aluno.getNome());
//        aluno.setNome(novoNome);
//
//        int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Editar idade:", aluno.getIdade()));
//        aluno.setIdade(novaIdade);
//
//        String novoCpf = JOptionPane.showInputDialog("Editar CPF:", aluno.getCpf());
//        aluno.setCpf(novoCpf);
//
//        double novoPeso = Double.parseDouble(JOptionPane.showInputDialog("Editar peso:", aluno.getPeso()));
//        aluno.setPeso(novoPeso);
//
//        double novaAltura = Double.parseDouble(JOptionPane.showInputDialog("Editar altura:", aluno.getAltura()));
//        aluno.setAltura(novaAltura);
//
//        // Associar instrutor
//        List<Instrutor> instrutores = GerenciadorInstrutores.getInstrutores();
//        if (!instrutores.isEmpty()) {
//            String[] nomesInstrutores = instrutores.stream().map(Instrutor::getNome).toArray(String[]::new);
//            String instrutorSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o instrutor:",
//                    "Associar Instrutor", JOptionPane.PLAIN_MESSAGE, null, nomesInstrutores, nomesInstrutores[0]);
//            Instrutor instrutor = GerenciadorInstrutores.buscarInstrutorPorNome(instrutorSelecionado);
//            aluno.adicionarPersonal(instrutor);
//        }
//
//        // Associar academia
//        Academia novaAcademia = new Academia(JOptionPane.showInputDialog("Digite o nome da academia:"));
//        aluno.adicionarAcademia(novaAcademia);
//
//        JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
//    }
//
//    // Buscar Aluno
//    private static void buscarAluno() {
//        String[] opcoesBusca = {"Buscar por Instrutor", "Buscar por Academia"};
//        String tipoBusca = (String) JOptionPane.showInputDialog(null, "Escolha o tipo de busca:",
//                "Buscar Aluno", JOptionPane.PLAIN_MESSAGE, null, opcoesBusca, opcoesBusca[0]);
//
//        if (tipoBusca == null) return;
//
//        if (tipoBusca.equals("Buscar por Instrutor")) {
//            String nomeInstrutor = JOptionPane.showInputDialog("Digite o nome do instrutor:");
//            gerenciadorAlunos.buscarAlunosPorInstrutor(nomeInstrutor);
//        } else {
//            String nomeAcademia = JOptionPane.showInputDialog("Digite o nome da academia:");
//            gerenciadorAlunos.buscarAlunosPorAcademia(nomeAcademia);
//        }
//    }
//
//    // Criar Instrutor
//    private static void criarInstrutor() {
//        String nome = JOptionPane.showInputDialog("Digite o nome do instrutor:");
//        String cpf = JOptionPane.showInputDialog("Digite o CPF do instrutor:");
//        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do instrutor:"));
//        String especialidade = JOptionPane.showInputDialog("Digite a especialidade do instrutor:");
//
//        Instrutor novoInstrutor = new Instrutor(nome, idade, cpf, especialidade);
//        GerenciadorInstrutores.cadastrarInstrutor(novoInstrutor);
//
//        JOptionPane.showMessageDialog(null, "Instrutor cadastrado com sucesso!");
//    }
//
//    // Criar Plano de Treino
//    private static void criarPlanoTreino() {
//        String nomePlano = JOptionPane.showInputDialog("Digite o nome do plano de treino:");
//        PlanoTreino plano = new PlanoTreino(nomePlano);
//
//        int numExercicios = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de exercícios:"));
//        for (int i = 0; i < numExercicios; i++) {
//            String nomeExercicio = JOptionPane.showInputDialog("Digite o nome do exercício:");
//            String descricao = JOptionPane.showInputDialog("Digite a descrição do exercício:");
//            String duracao = JOptionPane.showInputDialog("Digite a duração (em minutos):");
//
//            Exercicio exercicio = new Exercicio(nomeExercicio, descricao, duracao);
//            plano.adicionarExercicio(exercicio);
//        }
//
//        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno para associar este plano:");
//        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeAluno);
//        if (aluno != null) {
//            aluno.adicionarPlanoTreino(plano);
//        }
//    }
//
//    // Visualizar Plano de Treino
//    private static void visualizarPlanoTreino() {
//        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno:");
//        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeAluno);
//
//        if (aluno != null) {
//            aluno.exibirPlanosTreino();
//        }
//    }
//
//    // Realizar Pagamento
//    private static void realizarPagamento() {
//        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno:");
//        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeAluno);
//
//        if (aluno != null) {
//            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pagamento:"));
//            String data = JOptionPane.showInputDialog("Digite a data do pagamento:");
//
//            aluno.realizarPagamento(valor, data);
//        }
//    }
//
//    // Visualizar Pagamentos
//    private static void visualizarPagamentos() {
//        String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno:");
//        Aluno aluno = GerenciadorAlunos.buscarAlunoPorNome(nomeAluno);
//
//        if (aluno != null) {
//            aluno.exibirPagamentos();
//        }
//    }
//}
