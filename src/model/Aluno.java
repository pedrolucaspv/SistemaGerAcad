package model;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa implements Exibivel{
    protected double peso;
    protected double altura;
    protected List<PlanoTreino> planosTreino;
    protected List<Pagamento> pagamentos;
    protected AvaliacaoFisica avaliacaoFisica; // Pode começar como null
    protected Instrutor personal;
    protected Academia academia;

    public Aluno(String nome, int idade, String cpf, double peso, double altura) {
        super(nome, idade, cpf);
        this.peso = peso;
        this.altura = altura;
        this.planosTreino = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
        this.avaliacaoFisica = null; // Inicialmente, o aluno não tem avaliação física
    }

    public void adicionarAcademia(Academia academia) {
        this.academia = academia;
    }

    public void adicionarPersonal(Instrutor personal) {
        this.personal = personal;
    }

    public void realizarPagamento(double valor, String data) {
        Pagamento novoPagamento = new Pagamento(valor, data);
        pagamentos.add(novoPagamento);
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso em " + data + ".");
    }

    public void adicionarPagamento(Pagamento pagamento){
        this.pagamentos.add(pagamento);
    }

    @Override
    public String toString() {
        return this.getNome(); // ou "Aluno: " + nome
    }

    public void adicionarPlanoTreino(PlanoTreino plano) {
        planosTreino.add(plano);
        System.out.println("Plano de treino " + plano.getNome() + " adicionado.");
    }

    public void exibirPlanosTreino() {
        System.out.println("Planos de Treino:");
        if (planosTreino.isEmpty()) {
            System.out.println("Nenhum plano de treino cadastrado.");
        } else {
            for (PlanoTreino plano : planosTreino) {
                System.out.println("- " + plano.getNome());
            }
        }
    }

    public void exibirPagamentos() {
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento realizado.");
        } else {
            System.out.println("Pagamentos realizados por " + this.getNome() + ":");
            for (Pagamento pagamento : this.getPagamentos()) {
                System.out.println(pagamento);
            }
        }
    }

    // Método para adicionar ou atualizar a avaliação física do aluno
    public void adicionarAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public void exibirDados() {
        super.exibirDados();
        System.out.println("Peso: " + peso + ", Altura: " + altura);

        // Exibir todos os pagamentos
        System.out.println("Pagamentos:");
        for (Pagamento pagamento : pagamentos) {
            pagamento.exibirStatusPagamento(); // Chama o método para exibir os detalhes do pagamento
        }

        // Exibir avaliação física
        if (avaliacaoFisica != null) {
            avaliacaoFisica.exibirAvaliacao();
        } else {
            System.out.println("Avaliação Física: Não realizada ainda.");
        }

        if (personal != null) {
            System.out.println("Personal: " + personal.getNome());
        }
        else {
            System.out.println("Nenhum personal associado.");
        }

        // Exibir planos de treino
        exibirPlanosTreino();
    }

    public void setPlanosTreino(List<PlanoTreino> planosTreino) {
        this.planosTreino = planosTreino;
    }


    public List<PlanoTreino> getPlanosTreino() {
        return planosTreino != null ? planosTreino : new ArrayList<>(); // Retorna uma lista vazia se for null
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public AvaliacaoFisica getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public Instrutor getPersonal() {
        return personal;
    }

    public void setPersonal(Instrutor personal) {
        this.personal = personal;
    }

    public Academia getAcademia() {
        return academia;
    }

    public void setAcademia(Academia academia) {
        this.academia = academia;
    }

    public void setPlanoTreino(PlanoTreino selectedItem) {
    }
}
