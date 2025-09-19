public class Floresta {
    int quantidade_arvores;
    public Floresta(){
        this.quantidade_arvores = 0;
    }

    public void inserir_no_arvore(No filho, No pai, Raizes raizes){
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
            if(pai.esquerda == null)
            {
                pai.esquerda = filho;
            }
            else if(pai.direita == null)
            {
                pai.direita = filho;
            }
            if (buscar_filho != null) {
                raizes.remover_raiz(filho);
            }
        }

    }

    public No contem(No pessoa1,No pessoa2, Raizes raizes){
        for(No raiz_atual : raizes.raizes)
        {
            No resultado = raizes.percorrer(raiz_atual, pessoa1);
            No resultado2 = raizes.percorrer(raiz_atual, pessoa2);
            if(resultado != null && resultado2 != null)
            {
                return raiz_atual;
            }
        }
        return null;
    }

    public String relacao(No pessoa1, No pessoa2, Raizes raizes){
        No raiz_atual = contem(pessoa1, pessoa2, raizes);
        if(raiz_atual == null)
        {
            return "Sem relação";
        }
        else
        {
            String parentesco = linhagemDireta(pessoa1, pessoa2);
            if(parentesco.equals("primos"))
            {
                No ancestral_comum = get_ancestral_comum(raiz_atual, pessoa1, pessoa2);
                int nivel_ancestral_comum = nivelDescendencia(raiz_atual,ancestral_comum, 0);
                int nivel_pessoa1 = nivelDescendencia(raiz_atual, pessoa1, 0);
                int nivel_pessoa2 = nivelDescendencia(raiz_atual, pessoa2,0);
                return grau_primos(nivel_ancestral_comum, nivel_pessoa1, nivel_pessoa2);
            }
            else
            {
                return linhagemDireta(pessoa1, pessoa2);
            }
        }
    }

    public int nivelDescendencia(No raiz, No alvo, int nivel)
    {
        if (raiz == null)
        {
            return -1;
        }
        if (raiz == alvo)
        {
            return nivel;
        }
        int nivelEsq = nivelDescendencia(raiz.esquerda, alvo, nivel + 1);
        if (nivelEsq != -1)
        {
            return nivelEsq;
        }
        return nivelDescendencia(raiz.direita, alvo, nivel + 1);
    }

    public String linhagemDireta(No pessoa1, No pessoa2)
    {
        int nivelAB = nivelDescendencia(pessoa1, pessoa2, 0);
        if (nivelAB > 0)
        {
            switch (nivelAB)
            {
                case 1: return "pai";
                case 2: return "avô";
                case 3: return "bisavô";
                default: return tataravo(nivelAB);
            }
        }

        int nivelBA = nivelDescendencia(pessoa2, pessoa1, 0);
        if (nivelBA > 0)
        {
            switch (nivelBA)
            {
                case 1: return "filho";
                case 2: return "neto";
                case 3: return "bisneto";
                default: return tataraneto(nivelBA);
            }
        }

        return "primos";
    }

    public No get_ancestral_comum(No raiz, No pessoa1, No pessoa2)
    {
        if (raiz == null)
        {
            return null;
        }
        if (raiz == pessoa1 || raiz == pessoa2)
        {
            return raiz;
        }
        No esq = get_ancestral_comum(raiz.esquerda, pessoa1, pessoa2);
        No dir = get_ancestral_comum(raiz.direita, pessoa1, pessoa2);
        if (esq != null && dir != null)
        {
            return raiz;
        }
        if(esq != null)
        {
            return esq;
        }
        else
        {
            return dir;
        }
    }

    public String grau_primos(int nivel_ancestral_comum, int nivel_pessoa1, int nivel_pessoa2){
        int n = (nivel_pessoa1 - nivel_ancestral_comum) - 1;
        int m = (nivel_pessoa2 - nivel_ancestral_comum) - 1;
        int k = Math.min(n, m);
        int j = Math.abs(n - m);
        if(k == 0 && j == 0)
        {
            return "irmaos";
        }
        else
        {
            return "primo-" + k + " grau " + j;
        }
    }

    public String tataravo(int quantidade){
        StringBuilder resultado = new StringBuilder();
        for(int i = 4; i <= quantidade; i++)
        {
            resultado.append("tata");
        }
        resultado.append("ravô");
        return resultado.toString();
    }

    public String tataraneto(int quantidade){
        StringBuilder resultado = new StringBuilder();
        for(int i = 4; i <= quantidade; i++)
        {
            resultado.append("tata");
        }
        resultado.append("raneto");
        return resultado.toString();
    }


}
