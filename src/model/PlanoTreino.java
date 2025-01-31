    package model;
    import java.util.ArrayList;
    import java.util.List;

    public class PlanoTreino implements Exibivel {
        private String nome; // Exemplo: Ganho de massa, perda de peso, etc.
        private List<Exercicio> exercicios;

        public PlanoTreino(String nome) {
            this.nome = nome;
            this.exercicios = new ArrayList<>();
        }

        public void adicionarExercicio(Exercicio exercicio) {
            exercicios.add(exercicio);
        }

        public void exibirPlanoTreino() {
            System.out.println("Plano de Treino - Objetivo: " + nome);
            for (Exercicio exercicio : exercicios) {
                exercicio.exibirExercicio();
            }
        }

        public void exibirDados() {
            System.out.println("Plano de Treino - Objetivo: " + nome);
            for (Exercicio exercicio : exercicios) {
                exercicio.exibirExercicio();
            }
        }

        public String getNome() {
            return nome;
        }

        public void setObjetivo(String nome) {
            this.nome = nome;
        }

        public List<Exercicio> getExercicios() {
            return exercicios;
        }

        public void setExercicios(List<Exercicio> exercicios) {
            this.exercicios = exercicios;
        }

        public String toString(){
            return nome;
        }
    }

