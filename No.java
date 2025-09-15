public class No {
    String nome;
    No esquerda;
    No direita;

    public No(String nome) {
        this.nome = nome;
        this.esquerda = null;
        this.direita = null;
    }

    public No(){
        this.nome = "";
        this.esquerda = null;
        this.direita = null;
    }

    public String getNome() {
        return nome;
    }
}
