public class Raizes {
    No[] raizes;
    int quantidade_raizes;
    int tamanho = 100;

    public Raizes(){
        this.raizes = new No[tamanho];
        this.quantidade_raizes = 0;
    }

    public int getQuantidade_raizes(){
        return quantidade_raizes;
    }

    public void inserir_raiz(No nova_raiz){
        this.raizes[quantidade_raizes] = nova_raiz;
        this.quantidade_raizes++;
    }

    public No getRaiz(int index){
        if(index >= 0 && index < quantidade_raizes){
            return raizes[index];
        }
        return null;
    }

    public No get_No(No target_no, Raizes raizes){
        for(int i = 0; i < raizes.getQuantidade_raizes(); i++)
        {
            No raiz_atual = raizes.getRaiz(i);
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
    
    public void imprimir(Raizes raizes){
        for(int i = 0; i < raizes.getQuantidade_raizes(); i++){
            No raiz_atual = raizes.getRaiz(i);
            raizes.imprime(raiz_atual, " ");
        }
    }
}
