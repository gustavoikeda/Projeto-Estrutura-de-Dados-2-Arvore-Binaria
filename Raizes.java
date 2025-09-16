import java.util.ArrayList;

public class Raizes {
    ArrayList<No> raizes;
    int quantidade_raizes;

    public Raizes(){
        this.raizes = new ArrayList<>();
        this.quantidade_raizes = 0;
    }

    public int getQuantidade_raizes(){
        return quantidade_raizes;
    }

    public void inserir_raiz(No nova_raiz){
        raizes.add(nova_raiz);
        this.quantidade_raizes++;
    }

    public void remover_raiz(No raiz_remover){
        raizes.remove(raiz_remover);
        this.quantidade_raizes--;
    }

    public No get_No(No target_no){
        for(No raiz_atual : raizes)
        {
            No resultado = percorrer(raiz_atual, target_no);
            if(resultado != null)
            {
                return resultado;
            }
        }
        return null;
    }

    public No percorrer(No raiz_atual, No target_no){//percorre a arvore buscando o no, caso encontre retorna o no, caso nao encontre retorna null
        if(raiz_atual == null)
        {
            return null;
        }
        if(raiz_atual.nome.equals(target_no.nome))
        {
            return raiz_atual;
        }
        No esquerda = percorrer(raiz_atual.esquerda, target_no);
        if(esquerda != null)
        {
            return esquerda;
        }
        return percorrer(raiz_atual.direita, target_no);
    }

    public void imprime(No p, String espaco){
        if(p != null){
            imprime(p.esquerda, espaco+" ");
            System.out.println(espaco+p.nome);
            imprime(p.direita, espaco+" ");
        }
    }

    public void imprime_todas_as_raizes(){
        for(No raiz_atual : raizes)
        {
            System.out.println("Raiz: " + raiz_atual.nome);
            imprime(raiz_atual, " ");
        }
    }
}
