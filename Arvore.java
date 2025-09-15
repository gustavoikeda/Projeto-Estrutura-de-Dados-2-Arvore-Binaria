public class Arvore {
    No raiz;

    public Arvore(){
        raiz = null;
    }

    public void inserir_no(No p){
        if(raiz == null)
        {
            raiz = p;
        }
        else
        {
            if(raiz.esquerda == null)
            {
                raiz.esquerda = p;
            }
            else
            {
                raiz.direita = p;
            }
        }
    }
    
}
