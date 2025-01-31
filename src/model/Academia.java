package model;

public class Academia {
    private String nome;
    private String endereco;
    private String numeroInscricao;

    public Academia(String nome, String endereco, String numeroInscricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroInscricao = numeroInscricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumeroInscricao() {
        return numeroInscricao;
    }

    public String toString() {
        return nome;  // Retorna o nome da academia ao invés da representação padrão de objeto
    }
}
