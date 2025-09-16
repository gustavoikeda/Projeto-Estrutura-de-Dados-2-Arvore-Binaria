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
        else if(raizes.getQuantidade_raizes() != 0 && raizes.get_No(pai) == null){
            Arvore nova_arvore = new Arvore();
            raizes.inserir_raiz(pai);
            nova_arvore.inserir_no(pai);
            nova_arvore.inserir_no(filho);
            this.quantidade_arvores++;
        }
        else
        {
            No buscar_filho = raizes.get_No(filho);
            if(buscar_filho == null)
            {
                if(pai.esquerda == null)
                {
                    pai.esquerda = filho;
                }
                else if(pai.direita == null)
                {
                    pai.direita = filho;
                }
            }
            else
            {
                if(pai.esquerda == null)
                {
                    pai.esquerda = filho;
                }
                else if(pai.direita == null)
                {
                    pai.direita = filho;
                }
                raizes.remover_raiz(filho);
            }
        }

    }

}
