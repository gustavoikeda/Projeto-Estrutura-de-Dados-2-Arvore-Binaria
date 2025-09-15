public class Floresta {
    int quantidade_arvores;


    public Floresta(){
        this.quantidade_arvores = 0;
    }

    public void inserir_no_arvore(No filho, No pai, Raizes raizes){ //raizes vazio, pai existe e filho nao e pai nao existe
        if(raizes.getQuantidade_raizes() == 0)
        {
            Arvore nova_arvore = new Arvore();
            raizes.inserir_raiz(pai);
            nova_arvore.inserir_no(pai);
            nova_arvore.inserir_no(filho);
            this.quantidade_arvores++;
        }
        else if(raizes.getQuantidade_raizes() != 0 && raizes.get_No(pai, raizes) == null){
            Arvore nova_arvore = new Arvore();
            raizes.inserir_raiz(pai);
            nova_arvore.inserir_no(pai);
            nova_arvore.inserir_no(filho);
            this.quantidade_arvores++;
        }

    }

}
